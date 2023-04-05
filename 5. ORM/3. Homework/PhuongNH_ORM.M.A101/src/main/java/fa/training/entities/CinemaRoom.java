package fa.training.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "CINEMA_ROOM")
public class CinemaRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CINEMA_ROOM_ID")
	private Integer cinemaRoomId;

	@Column(name = "CINEMA_ROOM_NAME", length = 255, nullable = false)
	private String cinemaRoomName;

	@Column(name = "SEAT_QUANTITY", nullable = false)
	private Integer seatQuantity;

	@OneToOne(mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
	private CinemaRoomDetail cinemaRoomDetail;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cinemaRoom")
	private Set<Seat> seat;

	public CinemaRoom() {
	}

	public CinemaRoom(Integer cinemaRoomId, String cinemaRoomName, Integer seatQuantity) {
		super();
		this.cinemaRoomId = cinemaRoomId;
		this.cinemaRoomName = cinemaRoomName;
		this.seatQuantity = seatQuantity;
	}

	public Integer getCinemaRoomId() {
		return cinemaRoomId;
	}

	public void setCinemaRoomId(Integer cinemaRoomId) {
		this.cinemaRoomId = cinemaRoomId;
	}

	public String getCinemaRoomName() {
		return cinemaRoomName;
	}

	public void setCinemaRoomName(String cinemaRoomName) {
		this.cinemaRoomName = cinemaRoomName;
	}

	public Integer getSeatQuantity() {
		return seatQuantity;
	}

	public void setSeatQuantity(Integer seatQuantity) {
		this.seatQuantity = seatQuantity;
	}

	public CinemaRoomDetail getCinemaRoomDetail() {
		return cinemaRoomDetail;
	}

	public void setCinemaRoomDetail(CinemaRoomDetail cinemaRoomDetail) {
		this.cinemaRoomDetail = cinemaRoomDetail;
	}

	public Set<Seat> getSeat() {
		return seat;
	}

	public void setSeat(Set<Seat> seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "CinemaRoom [cinemaRoomId=" + cinemaRoomId + ", cinemaRoomName=" + cinemaRoomName + ", seatQuantity="
				+ seatQuantity + ", cinemaRoomDetail=" + cinemaRoomDetail + ", seat=" + seat + "]";
	}
}
