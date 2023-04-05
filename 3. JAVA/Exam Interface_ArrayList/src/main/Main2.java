package main;

import data.Guard;
import data.Student;
import data.Teacher;

public class Main2 {
	public static void main(String[] args) {
//		Tính lương giáo viên và bảo vệ
		Teacher t1 = new Teacher("Lâm", 2, 3);
		Teacher t2 = new Teacher("Khang", 3, 1);
		
		Guard g1 = new Guard("Minh Bảo Vệ", 12);
		Guard g2 = new Guard("Vương Bảo Vệ", 9.5);
		
		System.out.printf("Lương của giáo viên %s là %.1f VNĐ\n", t1.getName(), t1.calculateSalary());
		System.out.printf("Lương của giáo viên %s là %.1f VNĐ\n", t2.getName(), t2.calculateSalary());
		
		System.out.printf("Lương của %s là %.1f VNĐ\n", g1.getName(), g1.calculateSalary());
		System.out.printf("Lương của %s là %.1f VNĐ\n", g2.getName(), g2.calculateSalary());
		
//		In ra thông tin người mượn sách thư viện
		System.out.println("-------------------------------------------");
		Teacher t3 = new Teacher("Khoa Trần", "Tôi thấy hoa vàng trên cỏ xanh");
		Teacher t4 = new Teacher("Nam Cao", "Lão Hạc");
		
		Student s1 = new Student("07223355123", "11A1", "Tắt đèn");
		Student s2 = new Student("07225500123", "12A3", "Vợ chồng A Phủ");
		
		t3.showInfor();
		t4.showInfor();
		s1.showInfor();
		s2.showInfor();
	}
}
