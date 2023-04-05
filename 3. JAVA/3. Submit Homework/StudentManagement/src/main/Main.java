package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import model.Course;
import service.CourseService;

public class Main {
	public static void main(String[] args) throws SQLException {

//		Câu 1
		CourseService cs = new CourseService();
//		Course c1 = new Course("Fr05","Ja05","Fresher","Fresher academy",5);
//		Course c2 = new Course("In06","Ja06","Intern","Intern academy",6);
//		Course c3 = new Course("De07","Ja07","Dev","Dev academy",7);
//		cs.addCourse(new ArrayList<>(Arrays.asList(c1,c2,c3)));
		
//		Câu 2
		cs.getAllCourseTitleDesc();

//		Câu 3
		Course c4 = new Course("De07", "Dev course");
		cs.updateCourse(c4);
//		Course c5 = new Course("De08", "Dev abc");
//		cs.updateCourse(c5);
		
//		Câu 4
		cs.deleteCourse("In06");
		
//		Câu 5
		cs.findCourseTitleAcademy("academy");

//		System.out.println("*************************************************************************************************************");

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
//		
//		System.out.println("*************************************************************************************************************");
//		courseService.getAllCourseDetail();
	}
}
