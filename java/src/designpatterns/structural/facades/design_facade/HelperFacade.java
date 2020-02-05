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
public class HelperFacade {

	public static void generateReport(DBType dbType, ReportType reportType,
			String tableName) {
		Connection con = null;
		switch (dbType) {
		case MYSQL:
			con = MySqlHelper.getMySqlDBConnection();
			MySqlHelper mySqlHelper = new MySqlHelper();
			switch (reportType) {
			case HTML:
				mySqlHelper.generateMySqlHtmlReport(tableName, con);
				break;
			case PDF:
				mySqlHelper.generateMySqlPdfReport(tableName, con);
				break;
			}
			break;
		case ORACLE:
			con = OracleHelper.getOracleDBConnection();
			OracleHelper oracleHelper = new OracleHelper();
			switch (reportType) {
			case HTML:
				oracleHelper.generateOracleHtmlReport(tableName, con);
				break;
			case PDF:
				oracleHelper.generateOraclePdfReport(tableName, con);
				break;
			}
			break;
		}
	}

	public static enum DBType {
		MYSQL, ORACLE;
	}

	public static enum ReportType {
		HTML, PDF;
	}

}