package fa.training.hibernate.model;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "Employee")
public class Employee {
	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "First_Name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "Last_Name", length = 50, nullable = false)
	private String lastName;

	public Employee() {
	}

	public Employee(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
