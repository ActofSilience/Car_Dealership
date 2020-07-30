package com.dev.hagan.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnect {

	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				

				Class.forName("oracle.jdbc.driver.OracleDriver");

				FileInputStream input = new FileInputStream(
						DBConnect.class.getClassLoader().getResource("connection.properties").getFile());
				Properties props = new Properties();
				props.load(input);
				String url = props.getProperty("url");

				String username = props.getProperty("username");
				String password = props.getProperty("password");
				conn = DriverManager.getConnection(url, username, password);

				return conn;
			} else {
				return conn;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		Connection conn1 = getConnection();

		System.out.println(conn1);
	}

}