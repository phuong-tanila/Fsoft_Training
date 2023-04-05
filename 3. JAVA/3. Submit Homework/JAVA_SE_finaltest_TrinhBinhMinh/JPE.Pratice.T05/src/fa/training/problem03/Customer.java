package fa.training.problem03;

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

	public Customer(String address) {
		super();
		this.address = address;
	}

	public Customer(int id) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullName=" + fullName + ", address=" + address + ", phone=" + phone + ", age="
				+ age + "]";
	}
}
