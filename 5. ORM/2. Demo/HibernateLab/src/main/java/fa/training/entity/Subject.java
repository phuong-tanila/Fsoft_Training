package fa.training.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(schema = "dbo", name = "SUBJECT")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@Column(name = "name", nullable = false)
	@NotEmpty(message = "Please enter name of subject")
	private String name;

	@Column(name = "description")
	@NotEmpty(message = "Please enter description of subject")
	private String description;

	@Column(name = "created_on")
	@CreationTimestamp //generate date
	private LocalDate createdOn;

	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private List<Assignment> assignments;

	public Subject() {
	}

	public Subject(int id, String name, String description, LocalDate createdOn, List<Assignment> assignments) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdOn = createdOn;
		this.assignments = assignments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + ", createdOn=" + createdOn
				+ ", assignments=" + assignments + "]";
	}

}
