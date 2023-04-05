package fa.training.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import fa.training.constants.CustomerType;
import fa.training.constants.Sex;

@Entity
@Table(schema = "dbo", name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "idCardNumber", nullable = false)
	private String idCardNumber;

	@Column(name = "fullName", nullable = false)
	private String fullName;

	@Column(name = "email", nullable = false)
	@Pattern(regexp = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", message = "Email is invalid")
	private String email;

	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "sex")
	@Enumerated(EnumType.STRING)
	private Sex sex;

	@Column(name = "birthday")
	private String birthday;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private CustomerType type;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Room> room;

	public Customer() {
	}

	public Customer(long id, String idCardNumber, String fullName, String email, String phoneNumber, String address,
			Sex sex, String birthday, CustomerType type, List<Room> room) {
		super();
		this.id = id;
		this.idCardNumber = idCardNumber;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.type = type;
		this.room = room;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", idCardNumber=" + idCardNumber + ", fullName=" + fullName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", sex=" + sex + ", birthday=" + birthday
				+ ", type=" + type + ", room=" + room + "]";
	}

}
