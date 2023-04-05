package data;

import java.util.List;

public class Teacher implements Salary, BorrowBook {
	private String name;
	private int factor; // hệ số
	private int areaCode; // mã vùng
	private String bookTitle;
	
//	Tạo list student do 1 giảng viên quản lý
	private List<Student> students;

	public Teacher(String name, String bookTitle) {
		this.name = name;
		this.bookTitle = bookTitle;
	}

	public Teacher(String name, int factor, int areaCode) {
		this.name = name;
		this.factor = factor;
		this.areaCode = areaCode;
	}

	public Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	
//	Add student vào arraylist students
	public void addStudent(Student s) {
		this.students.add(s) ;
	}
	
	@Override
	public double calculateSalary() {
		if (areaCode == 1) {
			return factor * 4680000;
		}
		if (areaCode == 2) {
			return factor * 4160000;
		}
		if (areaCode == 3) {
			return factor * 3640000;
		}
		if (areaCode == 4) {
			return factor * 3250000;
		}
		return 0;
	}

	@Override
	public void showInfor() {
		System.out.printf("Thông tin giáo viên mượn sách: Họ và Tên: %10s | Tên sách: %8s\n", name, bookTitle);
	}
}
