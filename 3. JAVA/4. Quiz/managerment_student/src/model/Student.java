package model;

import java.sql.Date;

public class Student {
	private int ssn;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String street;
	private String phone;
	private String zipCode;

	public Student() {

	}

	public Student(int ssn, String firstName, String lastName, Date birthDate, String street, String phone,
			String zipCode) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.street = street;
		this.phone = phone;
		this.zipCode = zipCode;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
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

	@Override
	public String toString() {
		return "Student [ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", street=" + street + ", phone=" + phone + ", zipCode=" + zipCode + "]";
	}

	

}
