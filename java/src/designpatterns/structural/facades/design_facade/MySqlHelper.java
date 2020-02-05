package design_facade;

import java.sql.Connection;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class MySqlHelper {

	public static Connection getMySqlDBConnection() {
		// get MySql DB connection using connection parameters
		return null;
	}

	public void generateMySqlPdfReport(String tableName, Connection con) {
		// get data from table and generate pdf report
	}

	public void generateMySqlHtmlReport(String tableName, Connection con) {
		// get data from table and generate html report
	}

}