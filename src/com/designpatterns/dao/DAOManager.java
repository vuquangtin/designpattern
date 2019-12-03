package com.designpatterns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class DAOManager {
	// JDBC Driver Name And Database URL
	public static String JDBC_DRIVER = "Com.Mysql.Jdbc.Driver";
	public static String DB_URL = "Jdbc:mysql://Localhost/db_name";

	// Database Credentials
	public static String DB_USER = "db_username";
	public static String DB_PASS = "db_password";

	// Database Connection
	Connection conn = null;
	Statement stmt = null;

	public DAOManager() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Created DB Connection....");
		} catch (ClassNotFoundException e) {
			// Handle errors for Class.forName
			throw e;
		} catch (Exception e) {
			// Handle errors for Exception
			throw e;
		}
	}

	public void open() throws SQLException {
		try {
			if (this.conn == null && this.stmt == null) {
				this.conn = DriverManager.getConnection(DB_URL, DB_USER,
						DB_PASS);
				this.stmt = conn.createStatement();
			}
		} catch (SQLException e) {
			// Handle errors for JDBC
			e.printStackTrace();
			throw e;
		}
	}

	public void close() throws SQLException {
		try {
			if (this.conn != null)
				this.conn.close();
		} catch (SQLException e) {
			// Handle errors for JDBC
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * Implementation for one connection per user by singleton class
	 *
	 */
	private static class DAOManagerSingleton {
	    // Use ThreadLocal for one instance per thread.
	    public static ThreadLocal<DAOManager> INSTANCE;
	    static
	    {
	        ThreadLocal<DAOManager> dm;
	        try {
	            dm = new ThreadLocal<DAOManager>() {
	                @Override protected DAOManager initialValue() {
	                    try {
	                        return new DAOManager();
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                        return null;
	                    }
	                }
	            };
	        } catch (Exception e) {
	            e.printStackTrace();
	            dm = null;
	        }
	        INSTANCE = dm;
	    }
	}

	
	public static DAOManager getInstance() {
	    return DAOManagerSingleton.INSTANCE.get();
	}



}