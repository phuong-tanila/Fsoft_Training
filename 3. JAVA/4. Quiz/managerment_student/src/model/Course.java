package model;

public class Course {
	private String courseId;
	private String subjectId;
	private String courseCode;
	private String courseTitle;
	private int numberOfCredit;
	
	public Course(String courseId, String subjectId, String courseCode, String courseTitle, int numberOfCredit) {
		this.courseId = courseId;
		this.subjectId = subjectId;
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.numberOfCredit = numberOfCredit;
	}

	public Course() {
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getNumberOfCredit() {
		return numberOfCredit;
	}

	public void setNumberOfCredit(int numberOfCredit) {
		this.numberOfCredit = numberOfCredit;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", subjectId=" + subjectId + ", courseCode=" + courseCode
				+ ", courseTitle=" + courseTitle + ", numberOfCredit=" + numberOfCredit + "]";
	}
	
	
	
}
