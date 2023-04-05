package fa.training.problem03.models;

public class Customer {
	private int id;
	private String fullName;
	private String address;
	private String phone;
	private int age;

	public Customer() {
		super();
	}

	public Customer(int id, String fullName, String address, String phone, int age) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
