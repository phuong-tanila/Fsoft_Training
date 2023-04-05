package fa.training.restfulapi.entities;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Trainee")
public class Trainee {

	@Id
	@Column(name = "trainee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainee_id;

	@Column(name = "trainee_account")
	private String trainee_account;

	@Column(name = "trainee_name")
	private String trainee_name;

	@Column(name = "password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainee")
	@JsonIgnore
	private Set<Course> course;

	public Trainee() {
	}

	public Trainee(Integer trainee_id, String trainee_account, String trainee_name, String password,
			Set<Course> course) {
		super();
		this.trainee_id = trainee_id;
		this.trainee_account = trainee_account;
		this.trainee_name = trainee_name;
		this.password = password;
		this.course = course;
	}

	public Integer getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(Integer trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getTrainee_account() {
		return trainee_account;
	}

	public void setTrainee_account(String trainee_account) {
		this.trainee_account = trainee_account;
	}

	public String getTrainee_name() {
		return trainee_name;
	}

	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Trainee [trainee_id=" + trainee_id + ", trainee_account=" + trainee_account + ", trainee_name="
				+ trainee_name + ", password=" + password + ", course=" + course + "]";
	}

}
