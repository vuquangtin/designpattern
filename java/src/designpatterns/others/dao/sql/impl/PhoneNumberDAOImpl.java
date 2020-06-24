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

import dao.sql.entity.Call;
import dao.sql.entity.PhoneNumber;
import dao.sql.entity.Subscriber;
import dao.sql.entity.impl.PhoneNumberImpl;
import dao.sql.entity.proxy.CallProxy;
import dao.sql.entity.proxy.OrganizationProxy;
import dao.sql.entity.proxy.PersonProxy;
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
public class PhoneNumberDAOImpl extends AbstractDAOImpl<PhoneNumber> implements PhoneNumberDAO {

    public PhoneNumberDAOImpl(Connection connection) {
        super(connection);
    }
    
    private static final Logger logger = Logger.getLogger(PhoneNumberDAOImpl.class.getName());

    @Override
    public void create(PhoneNumber entity) {
        entity.setId(getNextId());
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("INSERT INTO PHONE_NUMBER (ID_PHONE_NUMBER, SUBSCRIBER_ID, PHONENUMBER) "
                    + "VALUES (?,?,?)");
            st.setInt(1, entity.getId());
            st.setInt(2, entity.getOwner().getId());
            st.setString(3, entity.getNumber());
            st.execute();
            logger.log(Level.INFO, "Phone number with id={0} was created", entity.getId());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while creating phone number:{0}", e.getMessage());
            throw new DatabaseException("Can't create new PhoneNumber: " + entity.toString(), e);
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
    public PhoneNumber read(Integer id) {
        Statement st = null;
        Statement st3 = null;
        PreparedStatement st2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        PhoneNumber entity = null;
        try {
            st = connection.createStatement();
            st3 = connection.createStatement();
            st2 = connection.prepareStatement("SELECT SUBSCRIBER_TYPE FROM SUBSCRIBER WHERE ID_SUBSCRIBER=?");
            rs = st.executeQuery("SELECT SUBSCRIBER_ID, PHONENUMBER FROM PHONE_NUMBER WHERE ID_PHONE_NUMBER=" + id);
            if (rs.next()) {
                int subId = rs.getInt("SUBSCRIBER_ID");
                String num = rs.getString("PHONENUMBER").trim();
                entity = new PhoneNumberImpl(num);
                entity.setId(id);
                st2.setInt(1, subId);
                rs2 = st2.executeQuery();
                rs2.next();
                int typeSub = rs2.getInt("SUBSCRIBER_TYPE");
                Subscriber sub = null;
                if (subId != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subId);
                }
                entity.setOwner(sub);

                Call call;
                rs2 = st3.executeQuery("SELECT ID_CALL FROM PHONE_CALL WHERE NUMBER_FROM_ID=" + id);
                while (rs2.next()) {
                    call = new CallProxy();
                    call.setId(rs2.getInt("ID_CALL"));
                    entity.addOutCall(call);
                }

                rs2 = st3.executeQuery("SELECT ID_CALL FROM PHONE_CALL WHERE NUMBER_TO_ID=" + id);
                while (rs2.next()) {
                    call = new CallProxy();
                    call.setId(rs2.getInt("ID_CALL"));
                    entity.addInCall(call);
                }


            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while reading phone number with id={0}: {1}", new Object[]{id, e.getMessage()});
            throw new DatabaseException("Can't read PhoneNumber with ID=" + id, e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (st2 != null) {
                    st2.close();
                }
                if (st3 != null) {
                    st3.close();
                }
            } catch (SQLException ex) {
            }
        }

        if (entity == null) {
            throw new EntityNotFoundException("PhoneNumber with ID=" + id + " not found");
        }
        return entity;
    }

    @Override
    public void update(PhoneNumber entity) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("UPDATE PHONE_NUMBER SET SUBSCRIBER_ID=?, PHONENUMBER=? "
                    + " WHERE ID_PHONE_NUMBER=?");
            st.setInt(1, entity.getOwner().getId());
            st.setString(2, entity.getNumber());
            st.setInt(3, entity.getId());
            st.execute();
            logger.log(Level.INFO, "Phone number with id={0} updated", entity.getId());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while updating phone number with id={0}: {1}", new Object[]{entity.getId(), e.getMessage()});
            throw new DatabaseException("Can't update PhoneNumber with ID=" + entity.getId(), e);
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
    public void delete(PhoneNumber entity) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("DELETE FROM PHONE_NUMBER WHERE ID_PHONE_NUMBER=?");
            st.setInt(1, entity.getId());
            st.execute();
            if (st.getUpdateCount()==0) {
                throw new EntityNotFoundException("Phone number not found");
            }
            logger.log(Level.INFO, "Phone number with id={0} was removed", entity.getId());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while removing phone number with id={0}: {1}", new Object[]{entity.getId(), e.getMessage()});
            throw new DatabaseException("Can't delete phoneNumber with ID=" + entity.getId(), e);
        } finally {
            try {
                if (st !=null) {
                    st.close();                    
                }
            } catch (SQLException ex) {
            }
        }
    }

    @Override
    public List<PhoneNumber> findAll() {
        Statement st = null;
        Statement st2 = null;
        Statement st3 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        try {
            st = connection.createStatement();
            st2 = connection.createStatement();
            st3 = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM PHONE_NUMBER");
            int typeSub;
            int id;

            while (rs.next()) {
                PhoneNumber phoneNumber;
                id = rs.getInt("ID_PHONE_NUMBER");
                int subId = rs.getInt("SUBSCRIBER_ID");
                rs3 = st3.executeQuery("SELECT SUBSCRIBER_TYPE FROM SUBSCRIBER WHERE ID_SUBSCRIBER=" + subId);
                rs3.next();
                typeSub = rs3.getInt("SUBSCRIBER_TYPE");
                String num = rs.getString("PHONENUMBER").trim();

                phoneNumber = new PhoneNumberImpl();
                phoneNumber.setId(id);
                phoneNumber.setNumber(num);

                Subscriber sub = null;

                if (subId != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subId);
                }
                phoneNumber.setOwner(sub);

                Call call;
                rs2 = st2.executeQuery("SELECT ID_CALL FROM PHONE_CALL WHERE NUMBER_FROM_ID=" + id);
                while (rs2.next()) {
                    call = new CallProxy();
                    call.setId(rs2.getInt("ID_CALL"));
                    phoneNumber.addOutCall(call);
                }

                rs2 = st2.executeQuery("SELECT ID_CALL FROM PHONE_CALL WHERE NUMBER_TO_ID=" + id);
                while (rs2.next()) {
                    call = new CallProxy();
                    call.setId(rs2.getInt("ID_CALL"));
                    phoneNumber.addInCall(call);
                }

                phoneNumberList.add(phoneNumber);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while reading phone numbers list: {0}", ex.getMessage());
            throw new DatabaseException("Can't read phoneNumber list", ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (st2 != null) {
                    st2.close();
                }
                if (st3 != null) {
                    st3.close();
                }
            } catch (SQLException ex) {
            }
        }
        return phoneNumberList;
    }

    @Override
    public PhoneNumber readByNumber(String number) {
        Statement st = null;
        ResultSet rs = null;
        PhoneNumber entity = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT ID_PHONE_NUMBER, SUBSCRIBER_ID "
                    + "FROM PHONE_NUMBER "
                    + "WHERE PHONENUMBER=" + number);
            if (rs.next()) {
                int subId = rs.getInt("SUBSCRIBER_ID");
                int id = rs.getInt("ID_PHONE_NUMBER");
                entity = new PhoneNumberImpl(number);
                entity.setId(id);
                rs = st.executeQuery("SELECT SUBSCRIBER_TYPE "
                        + "FROM SUBSCRIBER "
                        + "WHERE ID_SUBSCRIBER=" + subId);
                rs.next();
                int typeSub = rs.getInt("SUBSCRIBER_TYPE");
                Subscriber sub = null;
                if (subId != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subId);
                }
                entity.setOwner(sub);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Can't read PhoneNumber " + number, e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }

        if (entity == null) {
            throw new EntityNotFoundException("PhoneNumber " + number + " not found");
        }
        return entity;
    }

    @Override
    public List<PhoneNumber> findBySubscriber(String name) {
        Statement st = null;
        Statement st2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<PhoneNumber> list = new ArrayList<>();
        PhoneNumber entity;
        try {
            st = connection.createStatement();
            st2 = connection.createStatement();
            rs = st.executeQuery("SELECT ID_PHONE_NUMBER, PHONENUMBER, SUBSCRIBER_ID "
                    + "FROM PHONE_NUMBER "
                    + "JOIN SUBSCRIBER ON ID_SUBSCRIBER=SUBSCRIBER_ID " +
                    "WHERE lower(SUBSCRIBER_NAME) like '%"+ name.toLowerCase() +"%'"
                    + "OR lower(PHONENUMBER) like '%"+ name.toLowerCase() +"%'");
            while (rs.next()) {
                int subId = rs.getInt("SUBSCRIBER_ID");
                int id = rs.getInt("ID_PHONE_NUMBER");
                entity = new PhoneNumberImpl(rs.getString("PHONENUMBER"));
                entity.setId(id);
                
                rs2 = st2.executeQuery("SELECT SUBSCRIBER_TYPE "
                        + "FROM SUBSCRIBER "
                        + "WHERE ID_SUBSCRIBER=" + subId);
                rs2.next();
                int typeSub = rs2.getInt("SUBSCRIBER_TYPE");
                Subscriber sub = null;
                if (subId != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subId);
                }
                entity.setOwner(sub);
                list.add(entity);
            }
            
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while searching phone number: {0}", e.getMessage());
            throw new DatabaseException("Can't find Phone numbers", e);
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

        return list;
    }
}
