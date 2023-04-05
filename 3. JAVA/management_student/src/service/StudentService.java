package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jdbc_demo.DatabaseConnection;
import model.Student;

public class StudentService {
	public List<Student> getAllStudents() throws SQLException {
		// cau query
		String SQL_SELECT = "Select * from student";
		// danh sach luu ket qua
		List<Student> result = new ArrayList<>();
		// get connection
		Connection conn = DatabaseConnection.getConnection();
		// check connection null hay khong
		if (Objects.nonNull(conn)) {
			// khai bao Prepareed statement va khong can goi ham close
			try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
				// result set chua ket qua tra ve tu db
				ResultSet resultSet = preparedStatement.executeQuery();
				// duyet qua danh sach ket qua tra
				while (resultSet.next()) {
					// get data tu column trong db
					int id = resultSet.getInt("ssn");
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					Date createdDate = resultSet.getDate("birth_date");
					String street = resultSet.getString("street");
					String phone = resultSet.getString("phone");
					String zipCode = resultSet.getString("zip_code");

					// set data tu db vao object
					Student obj = new Student();
					obj.setBirthDate(createdDate);
					obj.setFirstName(firstName);
					obj.setLastName(lastName);
					obj.setPhone(phone);
					obj.setSsn(id);
					obj.setStreet(street);
					obj.setZipCode(zipCode);
					// them phan tu vao danh sach
					result.add(obj);
				}
				// in ra
				result.forEach(x -> System.out.println(x));
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

	public Student getStudentById(int id) throws SQLException {
		String SQL_SELECT = "Select * from student where ssn=?";
		Connection conn = DatabaseConnection.getConnection();
		Student obj = null;
		if (Objects.nonNull(conn)) {
			try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					Date createdDate = resultSet.getDate("birth_date");
					String street = resultSet.getString("street");
					String phone = resultSet.getString("phone");
					String zipCode = resultSet.getString("zip_code");

					obj = new Student();
					obj.setBirthDate(createdDate);
					obj.setFirstName(firstName);
					obj.setLastName(lastName);
					obj.setPhone(phone);
					obj.setSsn(id);
					obj.setStreet(street);
					obj.setZipCode(zipCode);
					System.out.println(obj);
				}else {
					System.out.println("Not found Student with ssn " + id);					
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
		return obj;
	}

	public boolean addStudents(List<Student> students) throws SQLException {
		String sqlInsert = "INSERT INTO public.student (first_name, last_name, birth_date, street, phone, zip_code) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		Connection conn = DatabaseConnection.getConnection();
		int[] result = null;
		if (Objects.nonNull(conn)) {
			try (PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {
				for (Student st : students) {
					preparedStatement.setString(1, st.getFirstName());
					preparedStatement.setString(2, st.getLastName());
					preparedStatement.setDate(3, st.getBirthDate());
					preparedStatement.setString(4, st.getStreet());
					preparedStatement.setString(5, st.getPhone());
					preparedStatement.setString(6, st.getZipCode());

					preparedStatement.addBatch();
				}
				result = preparedStatement.executeBatch();
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
		return result.length == students.size();
	}

	public boolean updateStudents(List<Student> students) throws SQLException {
		List<Student> notFounds = new ArrayList<Student>();
		for (Student student : students) {
			if(getStudentById(student.getSsn()) == null) {
				notFounds.add(student);
			}			
		}
		
		if (notFounds.size() == students.size()) return false;
		
		students.removeAll(notFounds);
		
		String sqlUpdate = "UPDATE public.student SET first_name=?, last_name=?, birth_date=?, street=?, phone=?, zip_code=? WHERE ssn=?";
		Connection conn = DatabaseConnection.getConnection();
		int[] result = null;
		if (Objects.nonNull(conn)) {
			try (PreparedStatement preparedStatement = conn.prepareStatement(sqlUpdate)) {
				for (Student st : students) {
					preparedStatement.setString(1, st.getFirstName());
					preparedStatement.setString(2, st.getLastName());
					preparedStatement.setDate(3, st.getBirthDate());
					preparedStatement.setString(4, st.getStreet());
					preparedStatement.setString(5, st.getPhone());
					preparedStatement.setString(6, st.getZipCode());
					preparedStatement.setInt(7, st.getSsn());
					preparedStatement.addBatch();				
				}
				result = preparedStatement.executeBatch();
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				Objects.requireNonNull(conn).close();
				System.out.println("Closed connection");
				System.out.println();
			}
		}
		return result == null;
	}
	
	public boolean deleteStudent(List<Integer> ssns) throws SQLException {

		List<Integer> notFounds = new ArrayList<Integer>();
		for (Integer ssn : ssns) {
			if(getStudentById(ssn) == null) {
				notFounds.add(ssn);
			}			
		}
		
		if (notFounds.size() == ssns.size()) return false;
		
		ssns.removeAll(notFounds);
		
		String sqlDelete = "DELETE FROM public.student WHERE ssn=?";
		Connection conn = DatabaseConnection.getConnection();
		int[] result = null;
		if (Objects.nonNull(conn)) {
			try (PreparedStatement preparedStatement = conn.prepareStatement(sqlDelete)) {
				for (Integer ssn : ssns) {
					preparedStatement.setInt(1, ssn);
					preparedStatement.addBatch();				
				}
				result = preparedStatement.executeBatch();
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				Objects.requireNonNull(conn).close();
				System.out.println("Closed connection");
				System.out.println();
			}
		}
		return result == null;
	}
	
	public List<String> findByFirstname(String keyword) throws SQLException {
		String SQL_SELECT = "Select first_name from student where first_name LIKE CONCAT('%',?,'%')";
		Connection conn = DatabaseConnection.getConnection();
		List<String> result = new ArrayList<String>();
		if (Objects.nonNull(conn)) {
			try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
				preparedStatement.setString(1, keyword);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					String firstName = resultSet.getString("first_name");
					System.out.println(firstName);
					result.add(firstName);
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
