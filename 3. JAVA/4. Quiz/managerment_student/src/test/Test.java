package test;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Student;
import service.StudentService;

public class Test {
	public static void main(String[] args) throws SQLException, ParseException {
		StudentService sv = new StudentService();
		sv.selectAll();
		sv.find(3);
//		sv.find(2);
//		Date d = new java.sql.Date(2001, 9,12);
//		//Student st = new Student(3,"phu","trinh",d,"cmt8","123456","a");
//		//sv.addStudent(st);
//		//Student st1 = new Student(4,"phu","nguyen",d,"cmt8","123456","a");
//		//sv.addStudent(st1);
//		Student st2 = new Student(3,"phuc","trinh",d,"lac long quan","123456","a");
//		sv.updateStudent(st2);
//		sv.deleteStudent(4);
//		Student st3 = new Student(4,"dat","nguyen",new Date(2000,12,1),"lac long quan","123456","a");
//		Student st4 = new Student(5,"thach","nguyen",new Date(1998,12,1),"lac long quan","123456","a");
//		sv.addAllStudent(new ArrayList<>(Arrays.asList(st3,st4)));
//		Date d = new Date(100000);
//		Student st5 = new Student(6,"phu","trinh",d,"cmt8","123456","a");
//		sv.addStudent(st5);
		sv.deleteStudent(6);
		java.util.Date utilDate = new java.util.Date();
		String a = "2021/10/22";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		utilDate = sdf.parse(a);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		Student st5 = new Student(6,"phu","trinh",sqlDate,"cmt8","123456","a");
		sv.addStudent(st5);
		
		
		
	}
}
