package fa.training.problem03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fa.training.problem03.models.Customer;
import fa.training.problem03.utils.DBUtil;

public class CustomerDao {
	// Add new Customer
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
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
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

	// update Customer
	public String update(Customer customer) throws SQLException {
		String SQL_UPDATE = "update Customers set age = age+1 where id=?";
		if (find(customer.getId()) == null) {
			System.out.println("Not found customer_id: " + customer.getId());
		}
		Connection con = DBUtil.getConnection();
		int rs = 0;
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_UPDATE)) {
				p.setInt(1, customer.getId());
				rs = p.executeUpdate();
				System.out.println("Update successful.");
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
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

	// find Customer by address
	public static List<Customer> findCustomer(String addr) throws SQLException {
		Customer c = null;
		String SQL_Find = "select * from Customers where address like concat('%',?,'%') order by age desc";
		List<Customer> listCustomer = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_Find)) {
				p.setString(1, addr);
				ResultSet rs = p.executeQuery();
				while (rs.next()) {
					int cus_id = rs.getInt("id");
					String full_name = rs.getString("fullName");
					String address = rs.getString("address");
					String phone = rs.getString("phoneNumber");
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

	// find Customer by id
	public static Customer find(int id) throws SQLException {
		Customer cus = null;
		String SQL_Find = "select * from Customers where id=?";
		List<Customer> listCustomer = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_Find)) {
				p.setInt(1, id);
				ResultSet rs = p.executeQuery();
				while (rs.next()) {
					int cus_id = rs.getInt("id");
					String full_name = rs.getString("fullName");
					String address = rs.getString("address");
					String phone = rs.getString("phoneNumber");
					int age = rs.getInt("age");

					cus = new Customer();
					cus.setId(cus_id);
					cus.setFullName(full_name);
					cus.setAddress(address);
					cus.setPhone(phone);
					cus.setAge(age);
					listCustomer.add(cus);
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
		return cus;
	}
}
