package singletons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h1>Singleton</h1> Đảm bảo rằng một class (lớp) chỉ có duy nhất một instance
 * (thể hiện), và cung cấp một điểm chung, toàn cục để truy cập vào lớp đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DBSingletonConnection {

	private static DBSingletonConnection instance = null;

	private Connection connection = null;

	/**
	 * 
	 */
	private DBSingletonConnection() {

		super();

		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/singletondb", "postgres",
					"123456");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @return the instance
	 */
	public static DBSingletonConnection getInstance() {

		try {
			if (instance == null || instance.getConnection().isClosed()) {

				instance = new DBSingletonConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return instance;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
}