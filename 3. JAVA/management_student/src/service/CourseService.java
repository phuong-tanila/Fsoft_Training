package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jdbc_demo.DatabaseConnection;
import model.Course;

public class CourseService {
	public List<Course> getAllCourseDetail() throws SQLException {
		String SQL_SELECT = "Select c.course_id, c.num_of_credits, cd.description from course c join course_detail cd on c.course_id = cd.course_id ORDER BY num_of_credits DESC";
		Connection conn = DatabaseConnection.getConnection();
		List<Course> result = new ArrayList<Course>();
		if (Objects.nonNull(conn)) {
			try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					String courseId = resultSet.getString("course_id");
					String description = resultSet.getString("description");
					int numOfCredit = resultSet.getInt("num_of_credits");

					Course obj = new Course();
					obj.setCourseId(courseId);
					obj.setDescription(description);
					obj.setNumberOfCredits(numOfCredit);
					System.out.println(obj);
				}
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				System.out.println();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				Objects.requireNonNull(conn).close();
				System.out.println("Closed connection");
				System.out.println();
			}
		}
		return result;		
	}
}
