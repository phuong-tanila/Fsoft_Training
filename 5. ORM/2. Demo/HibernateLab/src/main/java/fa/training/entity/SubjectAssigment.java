package fa.training.entity;

import java.util.List;

public class SubjectAssigment {
	private String name;
	private String description;
	private List<Assignment> assignments;

	public SubjectAssigment() {
		super();
	}

	public SubjectAssigment(String name, String description, List<Assignment> assignments) {
		super();
		this.name = name;
		this.description = description;
		this.assignments = assignments;
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

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	@Override
	public String toString() {
		return "SubjectAssigment [name=" + name + ", description=" + description + ", assignments=" + assignments + "]";
	}

}
