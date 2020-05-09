package ControlDataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=Library;"
			+ "integratedSecurity=true";
	private static String USER_NAME = "lam1";
	private static String PASSWORD = "12345678";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}
