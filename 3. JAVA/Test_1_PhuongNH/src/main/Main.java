package main;

import data.Student;

public class Main {
	public static void main(String[] args) {
		
		Student s1 = new Student("Nguyen Hoai Phuong", "Ky thuat phan mem", 7, 3, 9);
		
		s1.showInfor();
		System.out.println();
		s1.showGpa();
		s1.showResult();
		s1.showHighGrade();
	}
}
