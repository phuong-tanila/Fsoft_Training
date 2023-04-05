package fa.training.entities;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "SEAT")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEAT_ID")
	private Integer seatId;

	@Column(name = "SEAT_COLUMN", length = 255, nullable = false)
	private String seatColumn;

	@Column(name = "SEAT_ROW", nullable = false)
	private Integer seatRow;

	@Column(name = "SEAT_STATUS", length = 255, nullable = false)
	private String seatStatus;

	@Column(name = "SEAT_TYPE", length = 255, nullable = false)
	private String seatType;

	@ManyToOne
	@JoinColumn(name = "CINEMA_ROOM_ID", referencedColumnName = "CINEMA_ROOM_ID")
	private CinemaRoom cinemaRoom;

	public Seat() {
	}

	public Seat(Integer seatId, String seatColumn, Integer seatRow, String seatStatus, String seatType) {
		super();
		this.seatId = seatId;
		this.seatColumn = seatColumn;
		this.seatRow = seatRow;
		this.seatStatus = seatStatus;
		this.seatType = seatType;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public String getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(String seatColumn) {
		this.seatColumn = seatColumn;
	}

	public Integer getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(Integer seatRow) {
		this.seatRow = seatRow;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public CinemaRoom getCinemaRoom() {
		return cinemaRoom;
	}

	public void setCinemaRoom(CinemaRoom cinemaRoom) {
		this.cinemaRoom = cinemaRoom;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatColumn=" + seatColumn + ", seatRow=" + seatRow + ", seatStatus="
				+ seatStatus + ", seatType=" + seatType + "]";
	}

}
