package model;

public class Course {
	private String courseId;
	private String subjectId;
	@Override
	public String toString() {
		return "Course [" + (courseId != null ? "courseId=" + courseId + ", " : "")
				+ (subjectId != null ? "subjectId=" + subjectId + ", " : "")
				+ (courseCode != null ? "courseCode=" + courseCode + ", " : "")
				+ (title != null ? "title=" + title + ", " : "") 
				+ "numberOfCredits=" + numberOfCredits + ", "
				+ (description != null ? "description=" + description : "") + "]";
	}
	private String courseCode;
	private String title;
	private int numberOfCredits;
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course(String courseId, String subjectId, String courseCode, String title, int numberOfCredits,
			String description) {
		super();
		this.courseId = courseId;
		this.subjectId = subjectId;
		this.courseCode = courseCode;
		this.title = title;
		this.numberOfCredits = numberOfCredits;
		this.description = description;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	public Course(String courseId, String subjectId, String courseCode, String title, int numberOfCredits) {
		super();
		this.courseId = courseId;
		this.subjectId = subjectId;
		this.courseCode = courseCode;
		this.title = title;
		this.numberOfCredits = numberOfCredits;
	}
	public Course() {
	}
}
