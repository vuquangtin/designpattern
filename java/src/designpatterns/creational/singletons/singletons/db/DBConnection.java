package singletons.db;

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
public class DBConnection {

	private String	driverClassName;
	private String	url;
	private String	username;
	private String	password;

	/**
	 * 
	 */
	public DBConnection() {

		super();
		this.driverClassName = "org.postgresql.Driver";
		this.url = "jdbc:postgresql://localhost:5432/singletondb";

		this.password = "123456";
		this.username = "postgres";
	}

	public java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName(this.driverClassName);

		return DriverManager.getConnection(this.url, this.username, this.password);
	}
}