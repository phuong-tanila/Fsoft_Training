package main;

import java.util.ArrayList;
import java.util.List;

import data.*;

public class Main {
	public static void main(String[] args) {
		Teacher t1 = new Teacher("Kiều Ân");

		Student s1 = new Student("Hoài Phương");
		Student s2 = new Student("Ngô Đông");
		Student s3 = new Student("Huỳnh Phi");

//		t1.addStudent(s1);
//		t1.addStudent(s2);
//		t1.addStudent(s3);

		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		System.out.println("LỚP HIỆN TẠI");
		System.out.println("Giảng viên " + t1.getName() + " quản lý: ");
		for (Student s : list) {
			System.out.println(s.getName());
		}

		s1.mark.add(9.0);
		s1.mark.add(10.0);
		s1.mark.add(8.0);

		s2.mark.add(3.0);
		s2.mark.add(6.0);
		s2.mark.add(2.0);

		s3.mark.add(10.0);
		s3.mark.add(6.25);
		s3.mark.add(7.25);

//		Kiểm tra xem sinh viên vào bị đuổi khỏi lớp
		System.out.println("\nKẾT QUẢ SAU KÌ THI");
		for (Student s : list) {
			if (s.calculateGpa() < 4.0) {
				list.remove(s);
				System.out.println(s.getName() + " đã bị kick khỏi lớp vì học NGU");
			}
		}

		System.out.println("\nThành viên còn lại trong lớp:");
		for (Student s : list) {
			System.out.println(s.getName());
		}

//		Lập danh sách sinh viên giỏi
		System.out.println("\nSINH VIÊN GIỎI SAU KỲ THI");
		for (Student o : list) {
			if (o.calculateGpa() >= 8) {
				System.out.println("Sinh viên " + o.getName() + " với GPA là " + o.calculateGpa());
			}
		}

//		Thêm 1 sinh viên mới vào vị trí thứ 2 trong danh sách học sinh của giảng viên
		Student s4 = new Student("Lan Hương");
		System.out.println("\nThêm vào danh sách học sinh mới ở vị trí thứ 2");
		list.add(1, s4);
		for (Student o : list) {
			System.out.println(o.getName());
		}

//		Kiểm tra danh sách lớp trống hay có sinh viên
		if (list.isEmpty()) {
			System.out.println("\nLớp của giảng viên " + t1.getName() + " không có ai");
		} else {
			System.out.println("\nLớp của giảng viên " + t1.getName() + " có " + list.size() + " sinh viên");
		}

//		Kiểm tra xem giảng viên có quản lý 1 sinh viên hay không.
		if (list.contains(s4)) {
			System.out.println("\nGiảng viên " + t1.getName() + " có quản lý " + s4.getName());
		} else {
			System.out.println("\nGiảng viên " + t1.getName() + " không có quản lý " + s4.getName());
		}

	}
}
