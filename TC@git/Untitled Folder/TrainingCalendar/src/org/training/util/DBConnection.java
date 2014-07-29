package org.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection = null;

	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			 connection =
			 DriverManager.getConnection("jdbc:mysql://mysql-dev-01.cloud.wso2.com:3306/staff_sabashan","staff_Sc9iK0nP","!@qwaszx");
			
//			connection = DriverManager.getConnection(
//			"jdbc:mysql://localhost:3306/training_calendar", "root", "root");
			
			System.out.println("connection = " + connection);
			System.out.println("Established");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}