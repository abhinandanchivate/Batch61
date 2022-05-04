package com.cogent.empms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	
	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection!=null);
	}
	
	// to hold the connection related details 
	// 1. getConnection  : to get the connection object to perform the db 
	// related work
	
	public static Connection getConnection() {
		
		Properties properties= loadPropertiesFile();
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(
					properties.getProperty("db.url"),
					properties.getProperty("db.userName"),
					properties.getProperty("db.password"));
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	// 2. closeConnection : to close the connection after completion of work. 

	public static void closeConnection(Connection connection ) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Properties loadPropertiesFile() {
		// load the properties
		Properties properties = null;
		InputStream inputStream  = DBUtils
				.class.getResourceAsStream("/application.properties");
		
		properties = new Properties();
		try {
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
}
