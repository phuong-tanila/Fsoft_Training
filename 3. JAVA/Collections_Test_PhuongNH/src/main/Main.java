package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.Student;

public class Main {
	public static void main(String[] args) {
		Student s = new Student();

		// Câu 1 :
		s.addSubject("Math");
		s.addSubject("English");
		s.addSubject("History");
		s.addSubject("Physical");
		s.addSubject("Geography");
		System.out.println("List subject:");
		s.showSubject();

		// Câu 2
		s.getList().add(2, "Chemistry");
		s.getList().add(3, "Biology");
		s.getList().remove("Geography");

		Collections.sort(s.getList());
		System.out.println("\n\nList subjects after sort A-Z: ");
		System.out.println(s.getList());

		// Câu 3
		List<String> a = new ArrayList<String>(Arrays.asList("Math", "Physical", "Chemistry"));
		List<String> b = new ArrayList<String>(Arrays.asList("Math", "Biology", "Chemistry"));
		List<String> a1 = new ArrayList<String>(Arrays.asList("Math", "Physical", "English"));

		// Câu 4
		Map<String, Integer> grade = new HashMap<String, Integer>();
		grade.put("Math", 8);
		grade.put("English", 4);
		grade.put("Physical", 1);
		grade.put("Chemistry", 8);
		grade.put("Biology", 7);

		System.out.println("\nHighest grade:");
		for (Map.Entry<String, Integer> o : grade.entrySet()) {
			if (Collections.max(grade.values()) == o.getValue()) {
				System.out.println(o.getKey() + "-" + o.getValue());
			}
		}

		if (!grade.keySet().equals("Music")) {
			grade.put("Music", null);
		}

		System.out.println("\nList subjects after update: ");
		for (Map.Entry<String, Integer> o : grade.entrySet()) {	
				System.out.print(o.getKey() + " ");
		}

		// Câu 5
		Student s1 = new Student("Phương");
		Student s2 = new Student("Thành");
		Student s3 = new Student("Phi");

		Map<String, Integer> grade1 = new HashMap<String, Integer>();
		grade.put("Math", 1);
		grade.put("English", 2);
		grade.put("Physical", 1);
		grade.put("Chemistry", 3);
		grade.put("Biology", 5);

		Map<String, Integer> grade2 = new HashMap<String, Integer>();
		grade.put("Math", 3);
		grade.put("English", 4);
		grade.put("Physical", 1);
		grade.put("Chemistry", 2);
		grade.put("Biology", 7);

		s1.setMark(grade);
		s2.setMark(grade1);
		s3.setMark(grade2);

	}

}
