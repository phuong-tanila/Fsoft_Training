package jdbc_demo;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import model.Student;
import service.CourseService;
import service.StudentService;

public class Test {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {
		StudentService stService = new StudentService();
		CourseService courseService = new CourseService();
		
//		System.out.println("*************************************************************************************************************");
//		stService.getAllStudents();
//		
//		System.out.println("*************************************************************************************************************");
//		stService.getStudentById(1);
//		
//		System.out.println("*************************************************************************************************************");
//		Student st1 = new Student("Le Thanh", "Nhut6", new Date(1998, 7, 20), "Vanh dai", "123456", "3456");
//		Student st2 = new Student("Le Thanh", "Nhut4", new Date(1998, 7, 20), "Vanh dai", "123456", "3456");
//		stService.addStudents(new ArrayList<Student>(Arrays.asList(st1, st2)));
//		
//		System.out.println("*************************************************************************************************************");
//		Student st3 = new Student(0, "Le Thanh90", "Nhut7", new Date(1998, 7, 20), "Vanh dai", "123456", "3456");
//		Student st4 = new Student(11, "Le Thanh93", "Nhut4", new Date(1998, 7, 20), "Vanh dai", "123456", "3456");
//		stService.updateStudents(new ArrayList<Student>(Arrays.asList(st4, st3)));
//		
//		System.out.println("*************************************************************************************************************");
//		stService.deleteStudent(new ArrayList<Integer>(Arrays.asList(7)));
//		
//		System.out.println("*************************************************************************************************************");
//		stService.findByFirstname("90");
		
		System.out.println("*************************************************************************************************************");
		courseService.getAllCourseDetail();
	}
}
