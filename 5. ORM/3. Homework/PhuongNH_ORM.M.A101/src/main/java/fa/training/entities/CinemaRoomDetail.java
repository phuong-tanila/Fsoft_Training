package fa.training.entities;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "CINEMA_ROOM_DETAIL")
public class CinemaRoomDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CINEMA_ROOM_DETAIL_ID")
	private Integer cinemaRoomDetailId;

	@Column(name = "ROOM_RATE", nullable = false)
	private Integer roomRate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACTIVE_DATE", nullable = false)
	private Date activeDate;

	@Column(name = "ROOM_DESCRIPTION", length = 255, nullable = false)
	private String roomDescription;

	@OneToOne
	@JoinColumn(name = "CINEMA_ROOM_ID")
	private CinemaRoom cinemaRoom;

	public CinemaRoomDetail() {
	}

	public CinemaRoomDetail(Integer cinemaRoomDetailId, Integer roomRate, Date activeDate, String roomDescription) {
		super();
		this.cinemaRoomDetailId = cinemaRoomDetailId;
		this.roomRate = roomRate;
		this.activeDate = activeDate;
		this.roomDescription = roomDescription;
	}

	public Integer getCinemaRoomDetailId() {
		return cinemaRoomDetailId;
	}

	public void setCinemaRoomDetailId(Integer cinemaRoomDetailId) {
		this.cinemaRoomDetailId = cinemaRoomDetailId;
	}

	public Integer getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(Integer roomRate) {
		this.roomRate = roomRate;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public CinemaRoom getCinemaRoom() {
		return cinemaRoom;
	}

	public void setCinemaRoom(CinemaRoom cinemaRoom) {
		this.cinemaRoom = cinemaRoom;
	}

	@Override
	public String toString() {
		return "CinemaRoomDetail [cinemaRoomDetailId=" + cinemaRoomDetailId + ", roomRate=" + roomRate + ", activeDate="
				+ activeDate + ", roomDescription=" + roomDescription + "]";
	}

}
