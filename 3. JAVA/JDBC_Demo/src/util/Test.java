package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=TrainingDB;username=sa;password=12345;;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1;");
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

//	private static Connection conn;
//	public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        if (conn == null) {
//            String url = "jdbc:sqlserver://localhost;databaseName=FEP_DB;username=sa;password=12345;encrypt=true;trustServerCertificate=true";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            conn = DriverManager.getConnection(url);
//        }
//        return conn;
//    }
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Test.getConnection();
//	}
}
