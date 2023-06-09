package fa.training.entity;

import javax.validation.constraints.*;
public class User {
	@NotNull(message = "Please enter id")
	private Long id;
	
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	@NotEmpty(message = "Please enter name")
	private String name;
	
	@Email(message = "{user.email.invalid}")
	@NotEmpty(message = "Please enter email")
	private String email;

	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
