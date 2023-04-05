package fa.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fa.training.entities.User;
import fa.training.utils.DBUtils;

public class UserDao {

	public boolean registerUser(User user) throws SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_registerUser(?,?,?,?,?)}");
			int param = 0;
			callableStatement.setString(++param, user.getFirstName());
			callableStatement.setString(++param, user.getLastName());
			callableStatement.setString(++param, user.getEmail());
			callableStatement.setString(++param, user.getUserName());
			callableStatement.setString(++param, user.getPassword());
			int result = callableStatement.executeUpdate();
			if (result > 0) {
				return true;
			}
			return false;

		} finally {
			connection.close();
		}
	}
}
