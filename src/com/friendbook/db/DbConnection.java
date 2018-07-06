package com.friendbook.db;
/**
  This class is to set the connection between database and server and return the connection to the required method.
 */
import java.sql.Connection;


public class DbConnection {
	private static Connection connection;
	public static void setConnection(Connection connection) {
		DbConnection.connection = connection;
	}
	public static Connection getConnection()
	{
		return DbConnection.connection;
	}
}
