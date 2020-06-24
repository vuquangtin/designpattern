package dao.sql.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.sql.entity.Organization;
import dao.sql.entity.Person;
import dao.sql.entity.PhoneNumber;
import dao.sql.entity.Subscriber;
import dao.sql.entity.impl.OrganizationImpl;
import dao.sql.entity.impl.PersonImpl;
import dao.sql.entity.proxy.PhoneNumberProxy;
import dao.sql.exception.DatabaseException;
import dao.sql.exception.EntityNotFoundException;

/**
 * <h1>Data Access Object (DAO) Pattern</h1>
 * 
 * Data Access Object (DAO) Pattern là một trong những Pattern thuộc nhóm cấu
 * trúc (Structural Pattern). Mẫu thiết kế DAO được sử dụng để phân tách logic
 * lưu trữ dữ liệu trong một lớp riêng biệt. Theo cách này, các service được che
 * dấu về cách các hoạt động cấp thấp để truy cập cơ sở dữ liệu được thực hiện.
 * Nó còn được gọi là nguyên tắc Tách logic (Separation of Logic).
 * 
 * <br/>
 * Ý tưởng là thay vì có logic giao tiếp trực tiếp với cơ sở dữ liệu, hệ thống
 * file, dịch vụ web hoặc bất kỳ cơ chế lưu trữ nào mà ứng dụng cần sử dụng,
 * chúng ta sẽ để logic này sẽ giao tiếp với lớp trung gian DAO. Lớp DAO này sau
 * đó giao tiếp với hệ thống lưu trữ, hệ quản trị CSDL như thực hiện các công
 * việc liên quan đến lưu trữ và truy vấn dữ liệu (tìm kiếm, thêm, xóa, sửa,…).
 * 
 * <br/>
 * DAO Pattern dựa trên các nguyên tắc thiết kế abstraction và encapsulation. Nó
 * bảo vệ phần còn lại của ứng dụng khỏi mọi thay đổi trong lớp lưu trữ, ví dụ:
 * thay đổi database từ Oracle sang MySQL, thay đổi công nghệ lưu trữ từ file
 * sang database. <br/>
 * 
 * Trong Java, DAO được triển khai theo nhiều cách khác nhau như Java
 * Persistence API, Enterprise Java Bean (EJP), Object-relational mapping (ORM)
 * với các implement cụ thể như Hibernate, iBATIS, Spring JPA, … Chi tiết về các
 * phần này chúng ta sẽ cùng thảo luận ở một bài viết khác.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class SubscriberDAOImpl<TypeEn extends Subscriber> extends AbstractDAOImpl<TypeEn> implements SubscriberDAO<TypeEn> {

    public SubscriberDAOImpl(Connection connection) {
        super(connection);
    }

    private final static Logger logger = Logger.getLogger(SubscriberDAOImpl.class.getName());

    @Override
    public void create(TypeEn entity) {
        entity.setId(getNextId());

        PreparedStatement st = null;
        logger.log(Level.INFO, "Creating new subscriber: {0}, id={1}", new Object[]{entity.getName(), entity.getId()});

        try {
            if (entity.getClass().equals(PersonImpl.class)) {
                st = connection.prepareStatement("insert into SUBSCRIBER"
                        + " (ID_SUBSCRIBER, SUBSCRIBER_TYPE, SUBSCRIBER_NAME,"
                        + " ADDRESS, PASSPORT_NUMBER) values (?,?,?,?,?)");
                st.setInt(2, 0);
                st.setString(5, ((Person) entity).getPassportNumber());
            } else {
                st = connection.prepareStatement("insert into SUBSCRIBER"
                        + " (ID_SUBSCRIBER, SUBSCRIBER_TYPE, SUBSCRIBER_NAME,"
                        + " ADDRESS, BANKING_DETAILS) values (?,?,?,?,?)");
                st.setInt(2, 1);
                st.setString(5, ((Organization) entity).getBankingDetails());
            }

            st.setInt(1, entity.getId());
            st.setString(3, entity.getName());
            st.setString(4, entity.getAddress());

            st.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while creating new subscriber ({0}): {1}", new Object[]{entity.getName(), ex.getMessage()});
            throw new DatabaseException("Can't create new subscriber with name: " + entity.getName(), ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }
//        return entity.getId();
    }

    @Override
    public TypeEn read(Integer id) {
        Statement st = null;
        ResultSet rs = null;
        TypeEn subscriber = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select * from SUBSCRIBER where ID_SUBSCRIBER=" + id);

            if (rs.next()) {
                int type = rs.getInt("SUBSCRIBER_TYPE");
                if (type == 0) {
                    subscriber = (TypeEn) new PersonImpl(rs.getString("PASSPORT_NUMBER").trim(),
                            rs.getString("SUBSCRIBER_NAME").trim(), rs.getString("ADDRESS").trim());

                } else {
                    subscriber = (TypeEn) new OrganizationImpl(rs.getString("SUBSCRIBER_NAME").trim(),
                            rs.getString("ADDRESS").trim());
                    ((Organization) subscriber).setBankingDetails(rs.getString("BANKING_DETAILS").trim());
                }
                subscriber.setId(id);

                rs = st.executeQuery("select ID_PHONE_NUMBER from PHONE_NUMBER where SUBSCRIBER_ID=" + id);

                while (rs.next()) {
                    PhoneNumber pn = new PhoneNumberProxy();
                    pn.setId(rs.getInt("ID_PHONE_NUMBER"));
                    subscriber.addPhoneNumber(pn);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while reading subscriber with id={0}: {1}", new Object[]{id, ex.getMessage()});
            throw new DatabaseException("Can't read subscriber with id=" + id, ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }
        if (subscriber == null) {
            throw new EntityNotFoundException("Subscriber with id=" + id + " not found");
        }
        return subscriber;
    }

    @Override
    public void update(TypeEn entity) {
        logger.log(Level.INFO, "Updating {0}..", entity.getName());
        PreparedStatement st = null;
        try {
            if (entity.getClass().equals(PersonImpl.class)) {
                st = connection.prepareStatement("update SUBSCRIBER set SUBSCRIBER_TYPE=0, SUBSCRIBER_NAME=?, "
                        + " ADDRESS=?, PASSPORT_NUMBER=? where ID_SUBSCRIBER=?");

                st.setString(3, ((Person) entity).getPassportNumber());
            } else {
                st = connection.prepareStatement("update SUBSCRIBER set SUBSCRIBER_TYPE=1, SUBSCRIBER_NAME=?, "
                        + " ADDRESS=?, BANKING_DETAILS=? where ID_SUBSCRIBER=?");
                st.setString(3, ((Organization) entity).getBankingDetails());
            }

            st.setString(1, entity.getName());
            st.setString(2, entity.getAddress());
            st.setInt(4, entity.getId());
            st.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while updating {0} information:{1}", new Object[]{entity.getName(), e.getMessage()});
            throw new DatabaseException("Can't update subscriber with ID=" + entity.getId(), e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public void delete(TypeEn entity) {
        logger.log(Level.INFO, "Deleting subscriber with id={0}..", entity.getId());
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("delete from SUBSCRIBER where ID_SUBSCRIBER=?");
            st.setInt(1, entity.getId());
            st.execute();

            if (st.getUpdateCount() == 0) {
                throw new EntityNotFoundException("Subscriber not found");
            }

            st = connection.prepareStatement("delete from USERS where SUBSCRIBER_ID=?");
            st.setInt(1, entity.getId());
            st.execute();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while deleting {0}: {1}", new Object[]{entity.getName(), e.getMessage()});
            throw new DatabaseException("Can't delete subscriber with ID=" + entity.getId(), e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public List<TypeEn> readByName(String name, int sType) {
        Statement st = null;
        Statement st2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<TypeEn> searchResult = new ArrayList<>();
        try {
            TypeEn subscriber;
            st = connection.createStatement();
            st2 = connection.createStatement();
            rs = st.executeQuery("select * from SUBSCRIBER where lower(SUBSCRIBER_NAME) "
                    + "LIKE '%" + name.toLowerCase() + "%' AND SUBSCRIBER_TYPE=" + sType);

            while (rs.next()) {
                int type = rs.getInt("SUBSCRIBER_TYPE");
                if (type == 0) {
                    subscriber = (TypeEn) new PersonImpl(rs.getString("PASSPORT_NUMBER").trim(),
                            rs.getString("SUBSCRIBER_NAME").trim(), rs.getString("ADDRESS").trim());

                } else {
                    subscriber = (TypeEn) new OrganizationImpl(rs.getString("SUBSCRIBER_NAME").trim(),
                            rs.getString("ADDRESS").trim());
                    ((Organization) subscriber).setBankingDetails(rs.getString("BANKING_DETAILS").trim());
                }
                subscriber.setId(rs.getInt("ID_SUBSCRIBER"));

                rs2 = st2.executeQuery("select ID_PHONE_NUMBER from PHONE_NUMBER where SUBSCRIBER_ID=" + rs.getInt("ID_SUBSCRIBER"));

                while (rs2.next()) {
                    PhoneNumber pn = new PhoneNumberProxy();
                    pn.setId(rs2.getInt("ID_PHONE_NUMBER"));
                    subscriber.addPhoneNumber(pn);
                }
                searchResult.add(subscriber);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while searching subscriber: {0}", ex.getMessage());
            throw new DatabaseException("Can't read subscriber with name like: " + name, ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (st2 != null) {
                    st2.close();
                }
            } catch (SQLException ex) {
            }
        }

        return searchResult;
    }
}