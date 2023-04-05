package fa.training.problem03.dao;

import fa.training.problem03.models.Customer;
import fa.training.problem03.utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerDao {
    public static Customer getIntance() {
        return new Customer();
    }

    public String save(Customer customer) throws SQLException {
        String SQL_INSERT = "INSERT INTO Customers(id,fullName,address,phoneNumber,age)"
                +" VALUES(?,?,?,?,?)";
        int result = 0;
        Connection connection = ConnectDB.getConnection();
            System.out.println("You have executed " + SQL_INSERT);
            if(Objects.nonNull(connection)) {
                try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)){
                    preparedStatement.setInt(1,customer.getId());
                    preparedStatement.setString(2, customer.getFullname());
                    preparedStatement.setString(3, customer.getAddress());
                    preparedStatement.setString(4,customer.getPhonenumber());
                    preparedStatement.setInt(5,customer.getAge());

                    result = preparedStatement.executeUpdate();
                    System.out.println("There are " + result + " lines changed");
                } catch (SQLException e) {
                    System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    try {
                        Objects.requireNonNull(connection).close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Closed connection");
                    System.out.println();
                    connection.close();
                }
            }
            if(result > 0) {
                return "success";
            }else {
                return "fail";
            }
        }
        public String update() throws SQLException {
            String SQL_UPDATE = "UPDATE Customers SET age = age+1 Where id = 1003";
            int result = 0;
            Connection connection = ConnectDB.getConnection();
            System.out.println("You have executed " + SQL_UPDATE);
            if(Objects.nonNull(connection)) {
                try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)){
                    result = preparedStatement.executeUpdate();
                    connection.commit();
                    System.out.println("There are " + result + " lines changed");
                } catch (SQLException e) {
                    System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    try {
                        Objects.requireNonNull(connection).close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Closed connection");
                    System.out.println();
                    connection.close();
                }
            }
            if(result > 0) {
                return "success";
            }else {
                return "fail";
            }
        }

        public List<Customer> findCustomer() {
            String SQL_SELECTALL =  "SELECT * From Customers Where address = /'District 1/' ORDER BY ageDESC";
            List<Customer> result = new ArrayList<Customer>();
            Connection connection = ConnectDB.getConnection();
            System.out.println("You have executed " + SQL_SELECTALL);
            if(Objects.nonNull(connection)) {
                try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECTALL)){
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String fullName = resultSet.getString("Full_name");
                        String address = resultSet.getString("Address");
                        String phoneNumber = resultSet.getString("Phone_number");
                        int age = resultSet.getInt("Age");
                        Customer customer = new Customer(id, fullName, address, phoneNumber, age);
                        result.add(customer);
                    }
                    System.out.println("There have "+ result.size() + " lines print");
                    resultSet.close();
                    connection.close();
                } catch (SQLException e) {
                    System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    try {
                        Objects.requireNonNull(connection).close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Closed connection");
                    System.out.println();
                }
            }
            return result;
        }
}
