package fa.training.entity;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserDetail {
	@Size(max = 20, min = 3, message = "{userDetail.firstname.invalid}")
	@NotEmpty(message = "Please enter firstname")
	private String firstname;

	@Size(max = 20, min = 3, message = "{userDetail.lastname.invalid}")
	@NotEmpty(message = "Please enter lastname")
	private String lastname;

	
	@Pattern(regexp = "(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})")
	@NotEmpty(message = "Please enter date of birth")
	private String dob;

	public UserDetail(String firstname, String lastname, String dob) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "UserDetail [firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob + "]";
	}

}
