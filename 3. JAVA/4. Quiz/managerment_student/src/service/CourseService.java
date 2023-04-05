package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jdbc_demo.ConnectionDatabase;
import model.Course;

public class CourseService {
	public void selectAllCourse() {
		String SQL_Select_Course = "Select * from Course";
		List<Course> listCourse = new ArrayList<>(); 
		Connection con =  ConnectionDatabase.getConnection();
		if(Objects.nonNull(con)) {
			try(PreparedStatement p = con.prepareStatement(SQL_Select_Course)) 
			{
				for (Course course : listCourse) {
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
