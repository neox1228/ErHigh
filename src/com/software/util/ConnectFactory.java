package com.software.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectFactory {
	static String driver;
	static String url;
	static String username;
	static String password;
	
	// ��̬�����
	static {
		
		// ʵ����Properties�࣬��������ȡProperties�ļ�
		Properties properties = new Properties();
		try {
			//
			properties.load(ConnectFactory.class.getResourceAsStream("jdbcinfo.properties"));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
		    username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		
		// 1.ע�����ݿ�����
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		// 2.�����ݿ⽨������
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}

}
