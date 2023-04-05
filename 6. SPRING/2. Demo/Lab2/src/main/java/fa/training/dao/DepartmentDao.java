package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Department;
import fa.training.utils.DBUtil;

public class DepartmentDao {

	private List<Department> listDepartments;

	public List<Department> findAllDepartment() throws SQLException {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			if (con != null) {
				String sql = "SELECT [department_id], [dapartment_name] FROM [Department]";
				stm = con.prepareStatement(sql);

				rs = stm.executeQuery();
				while (rs.next()) {
					int departmentId = rs.getInt("departmentId");
					String deepartmentName = rs.getString("deepartmentName");
					Department dto = new Department(departmentId, deepartmentName);
					if (listDepartments == null) {
						listDepartments = new ArrayList<Department>();
					}
					listDepartments.add(dto);
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
		return listDepartments;

	}
}
