package jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

//	public static Connection getConnection() {
//		try {
//			Connection conn = DriverManager.getConnection(
//	                "jdbc:postgresql://localhost:5432/TrainingDB", "postgres", "Pokemonunite82");
//            if (conn != null) {
//                System.out.println("Connected to the database!");
//            } else {
//                System.out.println("Failed to make connection!");
//            }
//            return conn;
//        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		return null;
//	}
	
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

}
