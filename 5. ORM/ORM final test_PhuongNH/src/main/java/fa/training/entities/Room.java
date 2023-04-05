package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.*;

import fa.training.constants.RoomType;

@Entity
@Table(schema = "dbo", name = "Room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "roomCode", nullable = false)
	private String roomCode;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
	private Customer customer;

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private RoomType type;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "startDate", nullable = false)
	private LocalDate startDate;

	@Column(name = "endDate", nullable = true)
	private LocalDate endDate;

	@Column(name = "serviceDescription")
	private String serviceDescription;

	public Room() {
	}

	public Room(long id, String roomCode, Customer customer, RoomType type, double price, LocalDate startDate,
			LocalDate endDate, String serviceDescription) {
		super();
		this.id = id;
		this.roomCode = roomCode;
		this.customer = customer;
		this.type = type;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.serviceDescription = serviceDescription;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomCode=" + roomCode + ", type=" + type + ", price=" + price + ", startDate="
				+ startDate + ", endDate=" + endDate + ", serviceDescription=" + serviceDescription + "]";
	}

}
