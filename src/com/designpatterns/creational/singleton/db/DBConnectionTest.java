package com.designpatterns.creational.singleton.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class DBConnectionTest {

	private static String	SELECT_QUERY	= "SELECT * FROM student";
	private static String	COUNT_QUERY		= "SELECT count(*) FROM student";

	private static void printAllRecord() {

		DBConnection dbConnection = new DBConnection();

		try {
			Connection connection = dbConnection.getConnection();

			Statement statement = connection.createStatement();

			ResultSet rs = null;
			//int count = 0;
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

			if (statement != null) {
				rs = statement.executeQuery(SELECT_QUERY);
				while (rs.next()) {

					System.out.println("Code: " + rs.getString("code"));
					System.out.println("Name: " + rs.getString("name"));

					Date birthday = rs.getDate("birthday");
					System.out.println("Birthday: " + (birthday != null ? format.format(birthday) : ""));
					System.out.println("Gender: " + (rs.getBoolean("gender") == true ? "Nam" : "Nu"));
					System.out.println("=============================================");
				}
				statement.close();
			}

			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void countAllRecord() {

		DBConnection dbConnection = new DBConnection();

		try {
			Connection connection = dbConnection.getConnection();

			Statement statement = connection.createStatement();

			ResultSet rs = null;
			//int count = 0;

			if (statement != null) {
				rs = statement.executeQuery(COUNT_QUERY);
				if (rs.next()) {

					System.out.println("Number of record: " + rs.getInt(1));
				}
				statement.close();
			}

			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		countAllRecord();

		printAllRecord();
	}

}