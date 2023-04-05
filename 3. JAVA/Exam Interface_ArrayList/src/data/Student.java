package data;

import java.util.*;

public class Student implements BorrowBook{
	private String name;
	private String identityCard;
	private String className;
	private String bookTitle;
	public List<Double> mark = new ArrayList<Double>();

	public Student(String name) {
		this.name = name;
	}
	
	public Student(String identityCard, String className, String bookTitle) {
		this.identityCard = identityCard;
		this.className = className;
		this.bookTitle = bookTitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<Double> getMark() {
		return mark;
	}

	public void setMark(List<Double> mark) {
		this.mark = mark;
	}

	double sum = 0;
	int count = 0;
	public double calculateGpa() {
		for (Double o : mark) {
			sum += o;
			count++;
		}
		return sum/count;
	}

	@Override
	public void showInfor() {
		System.out.printf("Thông tin sinh viên mượn sách: CCCD: %s | Tên lớp: %s | Tên sách: %s\n", identityCard, className, bookTitle);
	}

}
