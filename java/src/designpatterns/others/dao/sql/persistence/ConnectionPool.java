package dao.sql.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;
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
public class ConnectionPool {

	private final static Logger LOG = Logger.getLogger(ConnectionPool.class
			.getName());
	private static ConnectionPool pool = new ConnectionPool();
	private static ConcurrentLinkedQueue<Connection> connections;
	private static int poolSize;
	private static String url;
	private static String login;
	private static String password;

	private ConnectionPool() {
	}

	public static void init(String dbUrl, String dbLogin, String dbPassword,
			String dbDriver, int cpSize) throws DatabaseException {

		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, "Can't find database driver: {0}",
					e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
		url = dbUrl;
		login = dbLogin;
		password = dbPassword;
		poolSize = cpSize;
		connections = new ConcurrentLinkedQueue<>();
		try {
			Connection connection;
			for (int i = 0; i < poolSize; i++) {
				connection = DriverManager.getConnection(url, login, password);
				connection.setAutoCommit(false);
				connections.add(connection);
			}
		} catch (SQLException e2) {
			LOG.log(Level.SEVERE, "Can't get connection to database: {0}",
					e2.getMessage());
			throw new DatabaseException(e2.getMessage());
		}
	}

	public static ConnectionPool getInstance() {
		return pool;
	}

	public synchronized Connection getConnection() {
		Connection c = null;
		while (c == null) {
			try {
				if (!connections.isEmpty()) {
					c = connections.remove();
					if (!c.isValid(0)) {
						c = null;
					}
				} else {
					c = DriverManager.getConnection(url, login, password);
					c.setAutoCommit(false);
				}
			} catch (SQLException e) {
				LOG.log(Level.SEVERE, "Can't get connection to database: {0}",
						e.getMessage());
			}
		}
		return c;
	}

	public synchronized boolean releaseConnection(Connection connection) {
		if (connections.size() == poolSize) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOG.log(Level.SEVERE, "Can't release connection: {0}",
						e.getMessage());
			}
		} else {
			connections.add(connection);
		}
		return false;
	}

	public static synchronized boolean close() {
		if (connections.size() != poolSize) {
			return false;
		}
		boolean error = false;
		for (Connection c : connections) {
			try {
				c.close();
			} catch (SQLException e) {
				LOG.log(Level.SEVERE, "Can't close connection: {0}",
						e.getMessage());
				error = true;
			}
		}
		return !error;

	}
}
