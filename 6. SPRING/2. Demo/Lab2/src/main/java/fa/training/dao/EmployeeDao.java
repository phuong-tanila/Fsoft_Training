package fa.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fa.training.entities.Employee;
import fa.training.utils.DBUtil;
import fa.training.utils.DateUtils;

public class EmployeeDao {
	private List<Employee> listEmployees;

	public boolean addEmployee(Employee emp) throws SQLException {
		String SQL_INSERT = "insert into Employee values(?,?,?,?)";
		Connection con = DBUtil.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_INSERT)) {
				DateUtils d = new DateUtils();
				p.setString(1, emp.getEmployeeName());
				p.setByte(2, emp.getGender());
				p.setDate(3, d.convertJavaDateToSqlDate(emp.getDateOfBirth()));
				p.setInt(4, emp.getDepartmentId());
				int rs = p.executeUpdate();
				if (rs != 0) {
					System.out.println("Add successfull");
				}
				return (rs != 0);
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				con.close();
			}
		} else {
			System.out.println("Error");
			return false;
		}
	}

	public List<Employee> findAllEmployee() throws SQLException {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			if (con != null) {
				String sql = "SELECT [employee_id]\r\n" + "      ,[employee_name]\r\n" + "      ,[gender]\r\n"
						+ "      ,[date_of_birth]\r\n" + "  FROM [Employee]";
				stm = con.prepareStatement(sql);

				rs = stm.executeQuery();
				while (rs.next()) {
					int emolId = rs.getInt("employee_id");
					String emplName = rs.getString("employee_name");
					Byte gender = rs.getByte("gender");
					Date dob = rs.getDate("date_of_birth");
					Employee dto = new Employee(emolId, emplName, gender, dob);
					if (listEmployees == null) {
						listEmployees = new ArrayList<Employee>();
					}
					listEmployees.add(dto);
				}

			}
		} finally {
			if (con != null) {
				con.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return listEmployees;

	}
}
