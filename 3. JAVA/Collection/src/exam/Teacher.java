package exam;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	private String name;

	public Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {

		Teacher tc = new Teacher("Lan");

		Student s1 = new Student("Phương");
		Student s2 = new Student("Thiện");
		Student s3 = new Student("Phi");

		List<Student> list = new ArrayList<>();

		list.add(s1);
		list.add(s2);
		list.add(s3);

		for (Student s : list) {
			System.out.println("Giáo viên " + tc.getName() + " quản lý học sinh " + s.getName());
		}
	}
}
