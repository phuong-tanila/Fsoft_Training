package data;

public class Student {
	private String name;
	private String major;
	private double math;
	private double english;
	private double history;
	
	public Student() {
	}

	public Student(String name, String major, double math, double english, double history) {
		this.name = name;
		this.major = major;
		this.math = math;
		this.english = english;
		this.history = history;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	public double getHistory() {
		return history;
	}

	public void setHistory(double history) {
		this.history = history;
	}
	
	public void showInfor() {
		System.out.printf("Sinh viên: %10s, Khoa: %10s", name, major);
	}
	
	public double getGpa() {
		return (math + english + history) / 3;
	}
	
	public void showGpa() {
		System.out.printf("Sinh viên: %10s, Điểm trung binh: %4.2f", name, getGpa());
	}
	
	public void showResult() {
		if(getGpa() > 4 && getMath() > 4 && getEnglish() > 4 && getHistory() > 4) {
			System.out.printf("\nSinh viên: %10s: Passed.", getName());
		}else {
			System.out.printf("\nSinh viên: %10s: Failed.", getName());
		}
	}
	
	public void showHighGrade() {
		if (getMath() >= getEnglish() && getMath() >= getHistory()) {
			System.out.printf("\nĐiểm cao nhất là: %4.2f", getMath());
		} else if (getEnglish() >= getHistory()) {
			System.out.printf("\nĐiểm cao nhất là: %4.2f", getEnglish());
		} else {
			System.out.printf("\nĐiểm cao nhất là: %4.2f", getHistory());
		}
	}
}
