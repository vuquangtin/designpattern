package dao.sql.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class SettingsManager {

	private final static Logger logger = Logger.getLogger(SettingsManager.class
			.getName());

	public static ApusSettings getSettings() {
		Connection connection = ConnectionPool.getInstance().getConnection();
		Statement st = null;
		ResultSet rs = null;
		ApusSettings apusSettings = new ApusSettings();
		try {
			st = connection.createStatement();

			rs = st.executeQuery("select PVALUE from PARAMS where PKEY='PREFIX';");
			if (rs.next()) {
				apusSettings.setNumberPrefix(rs.getString("PVALUE").trim());
			}

			rs = st.executeQuery("select PVALUE from PARAMS where PKEY='NSIZE';");
			if (rs.next()) {
				apusSettings.setNumberSize(Integer.parseInt(rs.getString(
						"PVALUE").trim()));
			}

			rs = st.executeQuery("select PVALUE from PARAMS where PKEY='TARIFF';");
			if (rs.next()) {
				apusSettings.setTariff(Integer.parseInt(rs.getString("PVALUE")
						.trim()));
			}

			rs = st.executeQuery("select PVALUE from PARAMS where PKEY='DEF_LANG';");
			if (rs.next()) {
				apusSettings.setDefaultLanguage(rs.getString("PVALUE").trim());
			}

			rs = st.executeQuery("select PVALUE from PARAMS where PKEY='QUICK_SEARCH';");
			if (rs.next()) {
				apusSettings.setQuickSearch((rs.getString("PVALUE").trim()
						.equals("1")) ? true : false);
			}

			connection.commit();
			return apusSettings;
		} catch (SQLException e) {
			logger.log(Level.SEVERE,
					"Exception while reading settings from DB: {0}",
					e.getMessage());
			throw new DatabaseException("Can't read settings", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException ex) {
				System.err.println("Can't close statement");
				ex.printStackTrace(System.err);
			} finally {
				ConnectionPool.getInstance().releaseConnection(connection);
			}
		}
	}

	public static void setSettings(ApusSettings apusSettings) {
		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			logger.info("Saving settings to database..");

			st = connection
					.prepareStatement("UPDATE PARAMS SET PVALUE=? WHERE PKEY=?");

			st.setString(1, apusSettings.getNumberPrefix());
			st.setString(2, "PREFIX");
			st.execute();

			st.setString(1, Integer.toString(apusSettings.getNumberSize()));
			st.setString(2, "NSIZE");
			st.execute();

			st.setString(1, Integer.toString(apusSettings.getTariff()));
			st.setString(2, "TARIFF");
			st.execute();

			st.setString(1, apusSettings.getDefaultLanguage());
			st.setString(2, "DEF_LANG");
			st.execute();

			st.setBoolean(1, apusSettings.getQuickSearch());
			st.setString(2, "QUICK_SEARCH");
			st.execute();

			connection.commit();
		} catch (SQLException e) {
			logger.log(Level.SEVERE,
					"Exception while saving settings to DB: {0}",
					e.getMessage());
			throw new DatabaseException("Can't change settings", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException ex) {
				System.err.println("Can't close statement");
				ex.printStackTrace(System.err);
			} finally {
				ConnectionPool.getInstance().releaseConnection(connection);
			}
		}
	}
}