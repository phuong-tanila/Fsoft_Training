package fa.training.utils;

import java.sql.*;

//public class DBUtils {
//	public static Connection getConnection() {
//		try {
//			Connection conn = DriverManager.getConnection(
//					"jdbc:sqlserver://localhost:1433;databaseName=JNWEBML101_SMS;encrypt=true;trustServerCertificate=true;",
//					"sa", "12345");
//			if (conn != null) {
////				System.out.println("Connected to the database!");
//			} else {
//				System.out.println("Failed to make connection!");
//			}
//			return conn;
//		} catch (SQLException e) {
//			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public static void main(String[] args) {
//		DBUtils con = new DBUtils();
//		System.out.println(con.getConnection());
//	}
//
//}

public class DBUtils {
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=JNWEBML101_SMS;encrypt=true;trustServerCertificate=true;",
					"sa", "12345");
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}
			return conn;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
