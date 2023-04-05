package fa.training.restfulapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer course_id;

	@Column(name = "course_code")
	private String course_code;

	@Column(name = "course_title")
	private String course_title;

	@Column(name = "course_type")
	private String course_type;

	@Column(name = "year")
	private Integer year;

	@Column(name = "semester")
	private String semester;

	@ManyToOne
	@JoinColumn(name = "trainee_id", referencedColumnName = "trainee_id")
	private Trainee trainee;

	public Course() {
	}

	public Course(Integer course_id, String course_code, String course_title, String course_type, Integer year,
			String semester, Trainee trainee) {
		super();
		this.course_id = course_id;
		this.course_code = course_code;
		this.course_title = course_title;
		this.course_type = course_type;
		this.year = year;
		this.semester = semester;
		this.trainee = trainee;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public String getCourse_type() {
		return course_type;
	}

	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_code=" + course_code + ", course_title=" + course_title
				+ ", course_type=" + course_type + ", year=" + year + ", semester=" + semester + ", trainee=" + trainee
				+ "]";
	}

}
