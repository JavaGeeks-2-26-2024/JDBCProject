package com.jdbcproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	
	final static String DB_URL ="jdbc:mysql://localhost:3306/school";
	final static String DB_USERNAME ="root";
	final static String DB_PASSWORD = "123456789";
	
	
	public static Connection createConnection() {
		
		Connection connectionVar = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
                                                   
            connectionVar = DriverManager.getConnection(DB_URL, DB_USERNAME,DB_PASSWORD);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			
	        System.out.println( e.getMessage());
        }
		
		return connectionVar;
		
	}
	
	
	
	public  static void closeConnection(Connection connection) {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
