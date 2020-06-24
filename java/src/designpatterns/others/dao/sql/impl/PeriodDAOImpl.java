package dao.sql.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.sql.entity.Period;
import dao.sql.entity.impl.PeriodImpl;
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
public class PeriodDAOImpl extends AbstractDAOImpl<Period> implements PeriodDAO {

    public PeriodDAOImpl(Connection connection) {
        super(connection);
    }
    
    private static final Logger logger = Logger.getLogger(PeriodDAOImpl.class.getName());

    @Override
    public void create(Period entity) {
        entity.setId(getNextId());
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("insert into TIME_PERIOD"
                    + " (ID_PERIOD, DATE_START, DATE_END) values (?,?,?)");
            st.setInt(1, entity.getId());
            st.setDate(2, new java.sql.Date(entity.getStartDate().getTime()));
            st.setDate(3, new java.sql.Date(entity.getEndDate().getTime()));
            st.execute();
            logger.log(Level.INFO, "New period with id={0} added", entity.getId());
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while creating new period: {0}", ex.getMessage());
            throw new DatabaseException("Can't create new period!", ex);
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
    public Period read(Integer id) {
        Statement st = null;
        ResultSet rs;
        Period period = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select * from TIME_PERIOD where ID_PERIOD = " + id);
            if (rs.next()) {
                period = new PeriodImpl(new java.util.Date(rs.getDate("DATE_START").getTime()),
                        new java.util.Date(rs.getDate("DATE_END").getTime()));
                period.setId(rs.getInt("ID_PERIOD"));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while reading period: {0}", ex.getMessage());
            throw new DatabaseException("Can't read period with id=" + id, ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }
        if (period == null) {
            throw new EntityNotFoundException("Period with id = " + id + " not found");
        }
        return period;
    }

    @Override
    public void update(Period entity) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("update TIME_PERIOD set DATE_START=?, DATE_START=? "
                    + "where ID_PERIOD=?");
            st.setDate(1, new java.sql.Date(entity.getStartDate().getTime()));
            st.setDate(2, new java.sql.Date(entity.getEndDate().getTime()));
            st.setInt(3, entity.getId());
            st.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while updating period: {0}", e.getMessage());
            throw new DatabaseException("Can't update period with ID=" + entity.getId(), e);
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
    public void delete(Period entity) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("delete from TIME_PERIOD where ID_PERIOD=?");
            st.setInt(1, entity.getId());
            st.execute();
            logger.log(Level.INFO, "Period with id={0} was deleted", entity.getId());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while deleting period: {0}", e.getMessage());
            throw new DatabaseException("Can't delete period with ID=" + entity.getId(), e);
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
    public List<Period> findAll() {
        Statement st = null;
        ResultSet rs;
        List<Period> periodList = new ArrayList<>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("select * from TIME_PERIOD");
            Period period;
            while (rs.next()) {
                period = new PeriodImpl(new java.util.Date(rs.getDate("DATE_START").getTime()),
                        new java.util.Date(rs.getDate("DATE_END").getTime()));
                period.setId(rs.getInt("ID_PERIOD"));
                periodList.add(period);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Exception while reading period list: {0}", ex.getMessage());
            throw new DatabaseException("Can't read period list", ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }
        return periodList;
    }

    @Override
    public Period readByStartAndEndDates(Date start, Date end) {
        PreparedStatement st = null;
        ResultSet rs;
        Period period = null;
        try {
            st = connection.prepareStatement("select ID_PERIOD, DATE_START, DATE_END"
                    + " from TIME_PERIOD where DATE_START=? and DATE_END=?");
            st.setDate(1, new java.sql.Date(start.getTime()));
            st.setDate(2, new java.sql.Date(end.getTime()));
            rs = st.executeQuery();
            if (rs.next()) {
                period = new PeriodImpl(new java.util.Date(rs.getDate("DATE_START").getTime()),
                        new java.util.Date(rs.getDate("DATE_END").getTime()));
                period.setId(rs.getInt("ID_PERIOD"));
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Can't read period.", ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }
        if (period == null) {
            throw new EntityNotFoundException("Period not found.");
        }
        return period;
    }
}
