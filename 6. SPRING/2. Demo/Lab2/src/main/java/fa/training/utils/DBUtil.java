package fa.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=JNWEBML201_SMS;encrypt=true;trustServerCertificate=true;",
					"sa", "12345");
			if (conn != null) {
//				System.out.println("Connected to the database!");
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
	
	public static void main(String[] args) {
		DBUtil con = new DBUtil();
		System.out.println(con.getConnection());
	}
}
