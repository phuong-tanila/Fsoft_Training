package data;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
	private String ssn;
	private String firstName;
	private char mi;
	private String lastName;
	private LocalDate birthDate;
	private String street;
	private String phone;
	private String zipCode;

	public Student() {
	}

	public Student(String ssn, String firstName, char mi, String lastName, LocalDate birthDate, String street,
			String phone, String zipCode) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.mi = mi;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.street = street;
		this.phone = phone;
		this.zipCode = zipCode;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public char getMi() {
		return mi;
	}

	public void setMi(char mi) {
		this.mi = mi;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
