package dao.sql.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class DataBaseStatistics {

    private final static Logger logger = Logger.getLogger(DataBaseStatistics.class.getName());

    public static Map<String, Integer> getStatistics() {
        Map<String, Integer> statistics = new HashMap<>();
        Connection connection = ConnectionPool.getInstance().getConnection();
        Statement st = null;
        ResultSet rs;

        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT COUNT(*) AS COU FROM SUBSCRIBER WHERE SUBSCRIBER_TYPE=0");
            if (rs.next()) {
                statistics.put("Persons", rs.getInt("COU"));
            }

            rs = st.executeQuery("SELECT COUNT(*) AS COU FROM SUBSCRIBER WHERE SUBSCRIBER_TYPE=1");
            if (rs.next()) {
                statistics.put("Organizations", rs.getInt("COU"));
            }

            rs = st.executeQuery("SELECT COUNT(*) AS COU FROM ACCOUNT");
            if (rs.next()) {
                statistics.put("Accounts", rs.getInt("COU"));
            }

            rs = st.executeQuery("SELECT COUNT(*) AS COU FROM PHONE_NUMBER");
            if (rs.next()) {
                statistics.put("Phone numbers", rs.getInt("COU"));
            }

            rs = st.executeQuery("SELECT COUNT(*) AS COU FROM PHONE_CALL");
            if (rs.next()) {
                statistics.put("Calls", rs.getInt("COU"));
            }

            logger.info("Statistics obtained");

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Can't read statistics: {0}", ex.getMessage());
            throw new DatabaseException("Error while database statistics obtaining");
        } finally {
            if (st != null) {
                try {
                    st.close();
                    ConnectionPool.getInstance().releaseConnection(connection);
                } catch (SQLException ex) {
                    ConnectionPool.getInstance().releaseConnection(connection);
                    throw new DatabaseException("Can't close statement");
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return statistics;
    }
}
