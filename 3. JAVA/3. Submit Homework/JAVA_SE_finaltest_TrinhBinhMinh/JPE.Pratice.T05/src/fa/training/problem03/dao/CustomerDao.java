package fa.training.problem03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fa.training.problem03.Customer;
import fa.training.problem03.utils.DBUtil;

public class CustomerDao {
	public String save(Customer customer) throws SQLException {
		String SQL_INSERT = "insert into Customers values(?,?,?,?,?)";
		int rs = 0;
		Connection con = DBUtil.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_INSERT)) {

				p.setInt(1, customer.getId());
				p.setString(2, customer.getFullName());
				p.setString(3, customer.getAddress());
				p.setString(4, customer.getPhone());
				p.setInt(5, customer.getAge());

				rs = p.executeUpdate();
				System.out.println("Add successful.");
				return "Success";
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				return "Fail";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
		}
		if (rs > 0) {
			return "Success";
		} else {
			return "Fail";
		}
	}

	public List<Customer> findCustomer() throws SQLException {
		Customer c = null;
		String SQL_Find = "SELECT * From Customers Where address = /'District 1/' ORDER BY   age  ASC";
		List<Customer> listCustomer = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_Find)) {
				ResultSet rs = p.executeQuery();
				while (rs.next()) {
					int cus_id = rs.getInt("id");
					String full_name = rs.getString("full_name");
					String address = rs.getString("address");
					String phone = rs.getString("phone_number");
					int age = rs.getInt("age");

					c = new Customer();
					c.setId(cus_id);
					c.setFullName(full_name);
					c.setAddress(address);
					c.setPhone(phone);
					c.setAge(age);
					listCustomer.add(c);
				}
				listCustomer.forEach(x -> System.out.println(x.toString()));

			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
		}
		return listCustomer;
	}

	public String update() throws SQLException {
		String SQL_UPDATE = "UPDATE Customers SET age = age+1 Where id = 1003";

		Connection con = DBUtil.getConnection();
		int rs = 0;
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_UPDATE)) {

				rs = p.executeUpdate();
				System.out.println("Update successful.");
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
//				System.out.println("OK!!!!!!!");
			}
		}
		if (rs > 0) {
			return "Success";
		} else {
			return "Fail";
		}
	}

}
