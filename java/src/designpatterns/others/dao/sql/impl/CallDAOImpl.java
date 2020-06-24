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
import dao.sql.entity.impl.CallImpl;
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
public class CallDAOImpl extends AbstractDAOImpl<Call> implements CallDAO {

    public CallDAOImpl(Connection connection) {
        super(connection);
    }
    
    private final static Logger logger = Logger.getLogger(CallDAOImpl.class.getName());
    
    @Override
    public void create(Call call) {
        call.setId(getNextId());
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("INSERT INTO PHONE_CALL (ID_CALL, NUMBER_FROM_ID, NUMBER_TO_ID, DURATION, DATE_OF_CALL) "
                                    + "VALUES (?,?,?,?,?)");
            st.setInt(1, call.getId());
            st.setInt(2, call.getNumberFrom().getId());
            st.setInt(3, call.getNumberTo().getId());
            st.setInt(4, call.getDuration());
            st.setDate(5, new java.sql.Date(call.getDateOfCall().getTime()) );
            st.execute();
            logger.log(Level.INFO, "Call with id={0} added", call.getId());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exception while creating phone call: {0}", e.getMessage());
            throw new DatabaseException("Can't create new Call: " + call.toString(), e);
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
    public Call read(Integer id) {
        Statement st = null;
        ResultSet rs;
        Call call = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT NUMBER_FROM_ID, NUMBER_TO_ID, DURATION, DATE_OF_CALL "
                               + "FROM PHONE_CALL "
                               + "WHERE ID_CALL=" + id);
            if (rs.next()) {
                int numId = rs.getInt("NUMBER_FROM_ID");
                PhoneNumber phNumFr = new PhoneNumberProxy();
                phNumFr.setId(numId);
                
                numId = rs.getInt("NUMBER_TO_ID");
                PhoneNumber phNumTo = new PhoneNumberProxy();
                phNumTo.setId(numId);
                
                int dur = rs.getInt("DURATION");               
                
                java.util.Date dt = new java.util.Date(rs.getTimestamp("DATE_OF_CALL").getTime());
                call = new CallImpl(phNumFr,phNumTo, dur, dt);
                call.setId(id);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Can't read call with ID=" + id, e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }

        if (call == null) {
            throw new EntityNotFoundException("Call with ID=" + id + " not found");
        }
        return call;
    }

    @Override
    public void delete(Call call) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("DELETE FROM CALL WHERE ID_CALL=?");
            st.setInt(1, call.getId());
            st.execute();
        } catch (SQLException e) {
            throw new DatabaseException("Can't delete call with ID=" + call.getId(), e);
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
    public List<Call> findAll() {
        Connection cn = getConnection();
        Statement st = null;
        ResultSet rs;
        Call call;
        List<Call> callList = new ArrayList<>();
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM PHONE_CALL");
            while (rs.next()) {
                int id=rs.getInt("ID_CALL");
                
                int numId = rs.getInt("NUMBER_FROM_ID");
                PhoneNumber phNumFr = new PhoneNumberProxy();
                phNumFr.setId(numId);
                
                numId = rs.getInt("NUMBER_TO_ID");
                PhoneNumber phNumTo = new PhoneNumberProxy();
                phNumTo.setId(numId);
                
                int dur = rs.getInt("DURATION");
                
                java.util.Date dt = new java.util.Date(rs.getTimestamp("DATE_OF_CALL").getTime());
                call = new CallImpl(phNumFr,phNumTo, dur, dt);
                call.setId(id);
                callList.add(call);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Exceotion while reading call list{0}", e.getMessage());
            throw new DatabaseException("Can't read call list", e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }
        return callList;
    }

    @Override
    public void update(Call call) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("UPDATE CALL SET NUMBER_FROM_ID=?, NUMBER_TO_ID=?, DURATION=?, DATE_OF_CALL=? WHERE ID_CALL=?");
            st.setInt(1, call.getNumberFrom().getId());
            st.setInt(2, call.getNumberTo().getId());
            st.setInt(3, call.getDuration());
            st.setDate(4, new java.sql.Date(call.getDateOfCall().getTime()));
            st.setInt(5, call.getId());
            st.execute();            
        } catch (SQLException e) {
            throw new DatabaseException("Can't update call with ID=" + call.getId(), e);
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
    public Call readByNumbersAndTime(PhoneNumber out, PhoneNumber in, java.util.Date dateOfCall) {
        Statement st = null;
        ResultSet rs;
        Call call = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT ID_CALL, DURATION "
                               + "FROM PHONE_CALL "
                               + "WHERE NUMBER_FROM_ID=" + out.getId()
                               + "AND NUMBER_TO_ID=" + in.getId()
                               + "AND DATE_OF_CALL=" + new java.sql.Date(dateOfCall.getTime()));
            if (rs.next()) {
                int dur = rs.getInt("DURATION");
                int id = rs.getInt("ID_CALL");
                call = new CallImpl(out, in, dur, dateOfCall);
                call.setId(id);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Can't read call", e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }

        if (call == null) {
            throw new EntityNotFoundException("Call with selected data not found");
        }
        return call;
    }
    
    @Override
    public List<Call> readByNumber(int phoneNumberId) {
        Statement st = null;
        ResultSet rs;
        Call call;
        List<Call> callList = new ArrayList<>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT ID_CALL, DURATION, NUMBER_FROM_ID, NUMBER_TO_ID, DATE_OF_CALL"
                               + "FROM PHONE_CALL WHERE NUMBER_FROM_ID="+ phoneNumberId +" OR NUMBER_TO_ID="+phoneNumberId);
            while (rs.next()) {
                int out_id = rs.getInt("NUMBER_FROM_ID");
                int in_id = rs.getInt("NUMBER_TO_ID");
                PhoneNumber in = new PhoneNumberProxy();
                in.setId(in_id);
                PhoneNumber out = new PhoneNumberProxy();
                in.setId(out_id);
                
                int dur = rs.getInt("DURATION");
                int id = rs.getInt("ID_CALL");
                java.util.Date dt = new java.util.Date(rs.getTimestamp("DATE_OF_CALL").getTime());
                
                call = new CallImpl(out, in, dur, dt);
                call.setId(id);
                
                callList.add(call);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Can't read call", e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            }
        }

        return callList;
    }

}
