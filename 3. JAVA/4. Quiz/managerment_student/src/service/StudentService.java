package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import jdbc_demo.ConnectionDatabase;
import model.Student;

public class StudentService {
	public void deleteStudent(int ssn) throws SQLException {
		String SQL_DELETE = "Delete from Student where ssn=?";
		Connection con = ConnectionDatabase.getConnection();
		if(Objects.nonNull(con)) {
			try(PreparedStatement p = con.prepareStatement(SQL_DELETE)) 
			{
				p.setInt(1, ssn);
				p.executeUpdate();
			}catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				con.close();
				System.out.println("Delete ssn = " + ssn);
			}
		}
	}
	
	public void updateStudent(Student stu)throws SQLException {
		String SQL_UPDATE = "Update student "
				+ "set first_name=?,last_name=?,birth_date=?,street=?,phone=?,zip_code=? "
				+ "where ssn=?";
		Connection con = ConnectionDatabase.getConnection();
		if(Objects.nonNull(con)) {
			try(PreparedStatement p = con.prepareStatement(SQL_UPDATE)) 
			{
				p.setString(1, stu.getFirstName());
				p.setString(2, stu.getLastName());
				p.setDate(3, stu.getBirthDate());
				p.setString(4, stu.getStreet());
				p.setString(5, stu.getPhone());
				p.setString(6, stu.getZipCode());
				p.setInt(7, stu.getSsn());
				p.executeUpdate();
			}catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				con.close();
				System.out.println("OK!!!!!!!");
			}
		}
	}
	
	public boolean addStudent(Student st) throws SQLException {
		String SQL_INSERT = "insert into student values(?,?,?,?,?,?,?)";
		Connection con = ConnectionDatabase.getConnection();
		if(Objects.nonNull(con)) {
			try(PreparedStatement p = con.prepareStatement(SQL_INSERT)) 
			{
				p.setInt(1, st.getSsn());
				p.setString(2, st.getFirstName());
				p.setString(3, st.getLastName());
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				p.setString(4, sd.format(st.getBirthDate()));
				p.setString(5, st.getStreet());
				p.setString(6, st.getPhone());
				p.setString(7, st.getZipCode());
				p.executeUpdate();
			}catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				con.close();
				System.out.println("Add successfull!!!");
			}
		}
		return false;
		
	}
	
	public boolean addAllStudent(List<Student> list) throws SQLException {
		List<Student> notFounds = new ArrayList<Student>();
		for (Student student : list) {
			if(find(student.getSsn()) == null) {
				notFounds.add(student);
			}			
		}
		
		if (notFounds.size() == list.size()) return false;
		
		list.removeAll(notFounds);
		String SQL_INSERT = "insert into student values(?,?,?,?,?,?,?)";
		int[] result = null;
		Connection con = ConnectionDatabase.getConnection();
		if(Objects.nonNull(con)) {
			try(PreparedStatement p = con.prepareStatement(SQL_INSERT)) 
			{
				for (Student st : list) {
					p.setInt(1, st.getSsn());
					p.setString(2, st.getFirstName());
					p.setString(3, st.getLastName());
					p.setDate(4, st.getBirthDate());
					p.setString(5, st.getStreet());
					p.setString(6, st.getPhone());
					p.setString(7, st.getZipCode());
					p.addBatch();
				}
				result = p.executeBatch();
			}catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("Add all successful.");
				con.close();
			}
			return (result.length == list.size());
		}
		return false;
		
	}
	
	public Student find(int ssn) throws SQLException{
		Student st = null;
		String SQL_Find = "select * from student where ssn=?";
		List<Student> result = new ArrayList<>();
		Connection con = ConnectionDatabase.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_Find)) {
				p.setInt(1, ssn);
				ResultSet rs = p.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("ssn");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					Date createdDate = rs.getDate("birth_date");
					String street = rs.getString("street");
					String phone = rs.getString("phone");
					String zipCode = rs.getString("zip_code");
					
					 Student obj = new Student();
	                    obj.setBirthDate(createdDate);
	                    obj.setFirstName(firstName);
	                    obj.setLastName(lastName);
	                    obj.setPhone(phone);
	                    obj.setSsn(id);
	                    obj.setStreet(street);
	                    obj.setZipCode(zipCode);
	                    result.add(obj);
				}
				 result.forEach(x -> System.out.println(x.toString()));
				
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				con.close();
			}
		}
		return st;
	}
	
	public Student selectAll() throws SQLException{
		Student st = null;
		String SQL_SELECT = "select * from student ";
		List<Student> result = new ArrayList<>();
		Connection con = ConnectionDatabase.getConnection();
		if (Objects.nonNull(con)) {
			try (PreparedStatement p = con.prepareStatement(SQL_SELECT)) {
				ResultSet rs = p.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("ssn");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					Date createdDate = rs.getDate("birth_date");
					String street = rs.getString("street");
					String phone = rs.getString("phone");
					String zipCode = rs.getString("zip_code");
					
					 Student obj = new Student();
	                    obj.setBirthDate(createdDate);
	                    obj.setFirstName(firstName);
	                    obj.setLastName(lastName);
	                    obj.setPhone(phone);
	                    obj.setSsn(id);
	                    obj.setStreet(street);
	                    obj.setZipCode(zipCode);
	                    result.add(obj);
				}
				 result.forEach(x -> System.out.println(x.toString()));
				
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				con.close();
			}
		}
		return st;
	}
	
		
}
