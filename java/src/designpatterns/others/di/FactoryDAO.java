package di;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class FactoryDAO {
	public static AbstractDAO getDAO() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("source/config.properties");
			// load a properties file
			prop.load(input);
			// get the database value
			String database = prop.getProperty("database");
			if (database.equals("1")) {
				return new MySQLDAO();
			}
			if (database.equals("2")) {
				return new PostgreDAO();
			}
			if (database.equals("3")) {
				return new MSSQLDAO();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return null;
	}
}