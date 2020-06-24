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

import dao.sql.entity.Account;
import dao.sql.entity.Period;
import dao.sql.entity.Subscriber;
import dao.sql.entity.impl.AccountImpl;
import dao.sql.entity.proxy.OrganizationProxy;
import dao.sql.entity.proxy.PeriodProxy;
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
public class AccountDAOImpl extends AbstractDAOImpl<Account> implements AccountDAO {

    public AccountDAOImpl(Connection connection) {
        super(connection);
    }
    private final static Logger logger = Logger.getLogger(AccountDAOImpl.class.getName());

    @Override
    public Account read(Integer id) {

        logger.log(Level.INFO, "Reading account with id={0} information from DB..", id);
        Statement st = null;
        PreparedStatement st2 = null;
        ResultSet rs;
        ResultSet rs2;
        Account account = null;
        try {
            st = connection.createStatement();
            // не ооп :(
            st2 = connection.prepareStatement("select SUBSCRIBER_TYPE from SUBSCRIBER where ID_SUBSCRIBER=?");
            rs = st.executeQuery("select * from ACCOUNT where ID_ACCOUNT=" + id);
            int typeSub;

            if (rs.next()) {
                st2.setInt(1, rs.getInt("SUBSCRIBER_ID"));
                rs2 = st2.executeQuery();
                rs2.next();
                typeSub = rs2.getInt("SUBSCRIBER_TYPE");

                int subscriber = rs.getInt("SUBSCRIBER_ID");
                int period = rs.getInt("PERIOD_ID");

                account = new AccountImpl();
                account.setId(rs.getInt("ID_ACCOUNT"));
                account.setPay(rs.getBoolean("IS_PAID"));
                account.setPrice(rs.getInt("PRICE"));

                Subscriber sub = null;

                if (subscriber != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subscriber);
                }
                account.setSubscriber(sub);


                Period per = new PeriodProxy();
                per.setId(period);
                account.setPeriod(per);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while reading account: {0}", ex.getMessage());
            throw new DatabaseException("Can't read account with ID=" + id, ex);
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
        if (account == null) {
            throw new EntityNotFoundException("Account with ID=" + id + " not found");
        }
        return account;
    }

    @Override
    public void update(Account entity) {
        logger.log(Level.INFO, "Updating account with id={0} information..", entity.getId());
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("update ACCOUNT set SUBSCRIBER_ID=?, PERIOD_ID=?, IS_PAID=?, PRICE=?"
                    + " where ID_ACCOUNT=?");
            st.setInt(1, entity.getSubscriber().getId());
            st.setInt(2, entity.getPeriod().getId());
            st.setBoolean(3, entity.isPaid());
            st.setInt(4, entity.getPrice());
            st.setInt(5, entity.getId());
            st.execute();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while updating account with id={0}", entity.getId());
            throw new DatabaseException("Can't update account with ID=" + entity.getId(), e);
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
    public void delete(Account entity) {
        logger.log(Level.INFO, "Removing account with id={0}", entity.getId());
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("delete from ACCOUNT where ID_ACCOUNT=?");
            st.setInt(1, entity.getId());
            st.execute();
            if (st.getUpdateCount() == 0) {
                throw new EntityNotFoundException("Account not found");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while removing account with id={0}", entity.getId());
            throw new DatabaseException("Can't delete account with ID=" + entity.getId(), e);
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
    public List<Account> findAll() {
        logger.info("Reading account list..");
        Statement st = null;
        PreparedStatement st2 = null;
        ResultSet rs;
        ResultSet rs2;
        List<Account> accountList = new ArrayList<>();
        try {
            st = connection.createStatement();
            st2 = connection.prepareStatement("select SUBSCRIBER_TYPE from SUBSCRIBER where ID_SUBSCRIBER=?");
            rs = st.executeQuery("select * from ACCOUNT");
            int typeSub;

            while (rs.next()) {
                Account account;
                st2.setInt(1, rs.getInt("SUBSCRIBER_ID"));
                rs2 = st2.executeQuery();
                rs2.next();
                typeSub = rs2.getInt("SUBSCRIBER_TYPE");

                int subscriber = rs.getInt("SUBSCRIBER_ID");
                int period = rs.getInt("PERIOD_ID");

                account = new AccountImpl();
                account.setId(rs.getInt("ID_ACCOUNT"));
                account.setPay(rs.getBoolean("IS_PAID"));
                account.setPrice(rs.getInt("PRICE"));

                Subscriber sub = null;

                if (subscriber != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subscriber);
                }
                account.setSubscriber(sub);

                Period per = new PeriodProxy();
                per.setId(period);
                account.setPeriod(per);

                accountList.add(account);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error while reading account list: {0}", ex.getMessage());
            throw new DatabaseException("Can't read account list", ex);
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
        return accountList;
    }

    @Override
    public void create(Account entity) {
        entity.setId(getNextId());
        entity.calculate();

        PreparedStatement st = null;
        try {
            try {
                findBySubscriberAndPeriod(entity.getSubscriber(), entity.getPeriod());
            } catch (EntityNotFoundException e) {
                st = connection.prepareStatement("insert into ACCOUNT (ID_ACCOUNT, SUBSCRIBER_ID, PERIOD_ID, PRICE, IS_PAID) VALUES (?,?,?,?,?)");
                st.setInt(1, entity.getId());
                st.setInt(2, entity.getSubscriber().getId());
                st.setInt(3, entity.getPeriod().getId());
                st.setInt(4, entity.getPrice());
                st.setBoolean(5, entity.isPaid());
                st.execute();
                logger.log(Level.INFO, "Account with id={0} created", entity.getId());
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while creating account: {0}", e.getMessage());
            throw new DatabaseException("Can't create new account", e);
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
    public Account findBySubscriberAndPeriod(Subscriber subscriber, Period period) {
        Statement st = null;
        PreparedStatement st2 = null;
        ResultSet rs;
        ResultSet rs2;
        Account account = null;
        try {
            st2 = connection.prepareStatement("select SUBSCRIBER_TYPE from SUBSCRIBER where ID_SUBSCRIBER=?");
            st = connection.createStatement();
            rs = st.executeQuery("select * from ACCOUNT where SUBSCRIBER_ID=" + subscriber.getId() + " AND "
                    + "PERIOD_ID=" + period.getId());
            int typeSub;

            if (rs.next()) {
                st2.setInt(1, subscriber.getId());
                rs2 = st2.executeQuery();
                rs2.next();
                typeSub = rs2.getInt("SUBSCRIBER_TYPE");
                int subscriberLoc = rs.getInt("SUBSCRIBER_ID");
                int periodLoc = rs.getInt("PERIOD_ID");

                account = new AccountImpl();
                account.setId(rs.getInt("ID_ACCOUNT"));
                account.setPay(rs.getBoolean("IS_PAID"));
                account.setPrice(rs.getInt("PRICE"));

                Subscriber sub = null;

                if (subscriberLoc != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subscriberLoc);
                }
                account.setSubscriber(sub);


                Period per = new PeriodProxy();
                per.setId(periodLoc);
                account.setPeriod(per);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while reading account by subscriber and period: {0}", ex.getMessage());
            throw new DatabaseException("Can't read account", ex);
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
        if (account == null) {
            throw new EntityNotFoundException("Account not found");
        }
        return account;
    }

    @Override
    public List<Account> findBySubscriber(String parameter) {
        Statement st = null;
        PreparedStatement st2 = null;
        ResultSet rs;
        ResultSet rs2;
        List<Account> list = new ArrayList<>();
        try {
            st = connection.createStatement();
            st2 = connection.prepareStatement("select SUBSCRIBER_TYPE from SUBSCRIBER where ID_SUBSCRIBER=?");
            rs = st.executeQuery("SELECT * FROM ACCOUNT "
                    + "JOIN SUBSCRIBER ON ID_SUBSCRIBER=SUBSCRIBER_ID "
                    + "WHERE lower(SUBSCRIBER_NAME) like '%" + parameter.toLowerCase() + "%'");
            while (rs.next()) {

                Account account;
                st2.setInt(1, rs.getInt("SUBSCRIBER_ID"));
                rs2 = st2.executeQuery();
                rs2.next();
                int typeSub = rs2.getInt("SUBSCRIBER_TYPE");

                int subscriber = rs.getInt("SUBSCRIBER_ID");
                int period = rs.getInt("PERIOD_ID");

                account = new AccountImpl();
                account.setId(rs.getInt("ID_ACCOUNT"));
                account.setPay(rs.getBoolean("IS_PAID"));
                account.setPrice(rs.getInt("PRICE"));

                Subscriber sub = null;

                if (subscriber != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subscriber);
                }
                account.setSubscriber(sub);

                Period per = new PeriodProxy();
                per.setId(period);
                account.setPeriod(per);

                list.add(account);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while finding account by subscriber: {0}", e.getMessage());
            throw new DatabaseException("Can't find accounts", e);
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

    @Override
    public void payAccount(Integer id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("update ACCOUNT set IS_PAID=true where ID_ACCOUNT=?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while paying account with id={0}:{1}", new Object[]{id, e.getMessage()});
            throw new DatabaseException("Can't pay account with ID=" + id, e);
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
    public List<Account> readBySubscriber(Integer id) {
        Statement st = null;
        PreparedStatement st2 = null;
        ResultSet rs;
        ResultSet rs2;
        Account account;
        List<Account> accountList = new ArrayList<>();
        try {
            st = connection.createStatement();
            st2 = connection.prepareStatement("select SUBSCRIBER_TYPE from SUBSCRIBER where ID_SUBSCRIBER=?");
            rs = st.executeQuery("select * from ACCOUNT where SUBSCRIBER_ID=" + id + ";");
            int typeSub;

            while (rs.next()) {
                st2.setInt(1, id);
                rs2 = st2.executeQuery();
                rs2.next();
                typeSub = rs2.getInt("SUBSCRIBER_TYPE");
                int subscriberLoc = rs.getInt("SUBSCRIBER_ID");
                int periodLoc = rs.getInt("PERIOD_ID");

                account = new AccountImpl();
                account.setId(rs.getInt("ID_ACCOUNT"));
                account.setPay(rs.getBoolean("IS_PAID"));
                account.setPrice(rs.getInt("PRICE"));

                Subscriber sub = null;

                if (subscriberLoc != 0) {
                    if (typeSub == 0) {
                        sub = new PersonProxy();
                    } else {
                        sub = new OrganizationProxy();
                    }
                    sub.setId(subscriberLoc);
                }
                account.setSubscriber(sub);


                Period per = new PeriodProxy();
                per.setId(periodLoc);
                account.setPeriod(per);

                accountList.add(account);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while reading account by subscriber: {0}", ex.getMessage());
            throw new DatabaseException("Can't read account", ex);
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
        return accountList;
    }
}
