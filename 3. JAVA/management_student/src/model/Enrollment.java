package model;

import java.time.LocalDate;

public class Enrollment {
	private int ssn;
	private String courseId;
	private LocalDate dateRegister;
	private String grade;
	public Enrollment(int ssn, String courseId, LocalDate dateRegister, String grade) {
		super();
		this.ssn = ssn;
		this.courseId = courseId;
		this.dateRegister = dateRegister;
		this.grade = grade;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public LocalDate getDateRegister() {
		return dateRegister;
	}
	public void setDateRegister(LocalDate dateRegister) {
		this.dateRegister = dateRegister;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
