package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Course;
import util.DBUtill;

public class CourseService {
	public boolean addCourse(List<Course> list) throws SQLException {

		String SQL_INSERT = "insert into course values(?,?,?,?,?)";
		int[] result = null;
		Connection con = DBUtill.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_INSERT)) {
				for (Course cou : list) {
					p.setString(1, cou.getCourseId());
					p.setString(2, cou.getSubjectId());
					p.setString(3, cou.getCourseCode());
					p.setString(4, cou.getCourseTitle());
					p.setInt(5, cou.getNumberOfCredit());
					p.addBatch();
				}
				result = p.executeBatch();
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Add all successful.");
				con.close();
			}

		}
		return (result.length == list.size());
	}

	public List<Course> getAllCourseTitleDesc() throws SQLException {
		String SQL_SELECT = "SELECT course_title, num_of_credits FROM Course ORDER BY num_of_credits DESC";
		Connection conn = DBUtill.getConnection();
		List<Course> result = new ArrayList<Course>();
		if (Objects.nonNull(conn)) {
			try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					Course obj = new Course();
					obj.setCourseTitle(resultSet.getString("course_title"));
					obj.setNumberOfCredit(resultSet.getInt("num_of_credits"));
					System.out.printf("Course Title: %s | Number Of Credits: %d\n", obj.getCourseTitle(),
							obj.getNumberOfCredit());
				}
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				System.out.println();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				Objects.requireNonNull(conn).close();
//				System.out.println("Closed connection");
				System.out.println();
			}
		}
		return result;
	}

	public void updateCourse(Course course) throws SQLException {
		String SQL_UPDATE = "Update Course set course_title=? where course_id=?";
		if (find(course.getCourseId()) == null) {
			System.out.println("Not found course_id: " + course.getCourseId());
		}
		Connection con = DBUtill.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_UPDATE)) {
				p.setString(1, course.getCourseTitle());
				p.setString(2, course.getCourseId());
				p.executeUpdate();
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
				System.out.println("Updated!");
			}
		}
	}

	public void deleteCourse(String str) throws SQLException {
		String SQL_DELETE = "Delete from course where course_id=?";
		Connection con = DBUtill.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_DELETE)) {
				p.setString(1, str);
				p.executeUpdate();
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
				System.out.println("Deleted course_id = " + str);
			}
		}
	}

	public Course findCourseTitleAcademy(String str) throws SQLException {
		Course cou = null;
		String SQL_Find = "select * from course where course_title like concat('%',?,'%')";
		List<Course> listCourse = new ArrayList<>();
		Connection con = DBUtill.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_Find)) {
				p.setString(1, str);
				ResultSet rs = p.executeQuery();
				while (rs.next()) {
					String courseId = rs.getString("course_id");
					String subjectId = rs.getString("subject_id");
					String courseCode = rs.getString("course_code");
					String courseTitle = rs.getString("course_title");
					int numberOfCredit = rs.getInt("num_of_credits");

					cou = new Course();
					cou.setCourseId(courseId);
					cou.setSubjectId(subjectId);
					cou.setCourseCode(courseCode);
					cou.setCourseTitle(courseTitle);
					cou.setNumberOfCredit(numberOfCredit);
					listCourse.add(cou);
				}
				listCourse.forEach(x -> System.out.println(x.toString()));

			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
		}
		return cou;
	}

	public Course find(String str) throws SQLException {
		Course cou = null;
		String SQL_Find = "select * from course where course_id=?";
		List<Course> listCourse = new ArrayList<>();
		Connection con = DBUtill.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_Find)) {
				p.setString(1, str);
				ResultSet rs = p.executeQuery();
				while (rs.next()) {
					String courseId = rs.getString("course_id");
					String subjectId = rs.getString("subject_id");
					String courseCode = rs.getString("course_code");
					String courseTitle = rs.getString("course_title");
					int numberOfCredit = rs.getInt("num_of_credits");

					cou = new Course();
					cou.setCourseId(courseId);
					cou.setSubjectId(subjectId);
					cou.setCourseCode(courseCode);
					cou.setCourseTitle(courseTitle);
					cou.setNumberOfCredit(numberOfCredit);
					listCourse.add(cou);
				}
				listCourse.forEach(x -> System.out.println(x.toString()));

			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
		}
		return cou;
	}
}
