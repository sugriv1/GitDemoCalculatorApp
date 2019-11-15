package com.universal.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class JdbcUtil {
	private static final Logger LOGGER=Logger.getLogger(JdbcUtil.class);
	
	private JdbcUtil() {
		LOGGER.debug("JdbcUtil() :: 0-param construntor");
	}

	private static final String DRIVER_CLASS_NAME="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER_NAME="system";
	private static final String PASSWORD="manager";
	
	public static Connection getConnection() {
		LOGGER.debug("getConnection() execution started...");
		Connection con=null;
		try {
			Class.forName(DRIVER_CLASS_NAME);
			LOGGER.info("Driver class is loaded");
			con=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		catch (Exception e) {
			LOGGER.error("Error occured during connection creation");
		}
		return con;
	}
}
