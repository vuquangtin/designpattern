package dao.sql.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import dao.sql.entity.AbstractEntity;
import dao.sql.exception.DatabaseException;

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
public abstract class AbstractDAOImpl<TypeEn extends AbstractEntity> implements AbstractDAO<TypeEn> {

    protected Connection connection;
    private final static Logger logger = Logger.getLogger(AbstractDAOImpl.class.getName());

    public AbstractDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getNextId() {
        Statement st = null;
        Statement st2 = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            st2 = connection.createStatement();
            rs = st.executeQuery("select PVALUE from PARAMS where PKEY='ENTITY_ID'");
            int id = 0;
            if (rs.next()) {
                id = Integer.parseInt(rs.getString("PVALUE").trim());
            } else {
                st.execute("INSERT INTO PARAMS (PKEY,PVALUE) VALUES ('ENTITY_ID','0')");
                connection.commit();
            }
            id++;
            st.execute("update PARAMS set PVALUE=" + id + " where PKEY='ENTITY_ID'");
            connection.commit();
            return id;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new DatabaseException("Can't create new ID", e);
        } finally {
            
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e){}
            }

            if (st2 != null) {
                try {
                    st2.close();
                } catch (Exception e){}
            }
        }
    }

    public int getNextUser() {
        Statement st = null;
        Statement st2 = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();
            st2 = connection.createStatement();
            st2.execute("START TRANSACTION");
            rs = st.executeQuery("SELECT PVALUE FROM PARAMS WHERE PKEY='USER_ID'");
            int id = 0;
            if (rs.next()) {
                id = Integer.parseInt(rs.getString("PVALUE").trim());
            } else {
                st.execute("INSERT INTO PARAMS (PKEY,PVALUE) VALUES ('USER_ID','0')");
                st2.execute("COMMIT");
            }
            id++;
            st.execute("update PARAMS set PVALUE=" + id + " where PKEY='USER_ID'");
            st2.execute("COMMIT");
            return id;
        } catch (SQLException e) {
            throw new DatabaseException("Can't create new user", e);
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                System.err.println("Can't close statement");
                ex.printStackTrace(System.err);
            }
        }
    }
}
