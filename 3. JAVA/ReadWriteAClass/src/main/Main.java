package main;

import java.io.IOException;
import java.time.LocalDate;

import data.Student;
import data.StudentService;


public class Main {
	public static void main(String[] args) {
		LocalDate birthDate = LocalDate.of(1999, 1, 1);

		Student s1 = new Student("12345", "Nguyen Manh", 'K', "Truong", birthDate, "Duytan", "0987654321", "084");

		StudentService studentServices = new StudentService();
		try {
			studentServices.write(s1);
			System.out.println("Complete write a student to file!");

			System.out.println("Reading file:");
			System.out.println(studentServices.read());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
