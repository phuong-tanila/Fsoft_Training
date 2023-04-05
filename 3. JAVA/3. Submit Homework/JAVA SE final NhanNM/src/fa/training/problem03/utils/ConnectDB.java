package fa.training.problem03.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CustomerManagement;encrypt=true;trustServerCertificate=true;", "sa", "123");
            if (connection != null) {
                System.out.println("Connection Successfull");
            } else {
                System.out.println("Connection Fail!");
            }
            return connection;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s " + e.getSQLState() + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
