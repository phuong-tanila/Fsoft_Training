package fa.training.main;

import java.util.Date;

import fa.training.dao.CinemaRoomDAO;
import fa.training.dao.CinemaRoomDetailDAO;
import fa.training.dao.SeatDAO;
import fa.training.dao.impl.CinemaRoomDaoImpl;
import fa.training.dao.impl.CinemaRoomDetailDaoImpl;
import fa.training.dao.impl.SeatDaoImpl;
import fa.training.entities.CinemaRoom;
import fa.training.entities.CinemaRoomDetail;
import fa.training.entities.Seat;

public class Main {
	public static void main(String[] args) {
		CinemaRoomDAO cnmRoomDao = new CinemaRoomDaoImpl();
		CinemaRoomDetailDAO cnmRoomDetailDao = new CinemaRoomDetailDaoImpl();
		SeatDAO seatDao = new SeatDaoImpl();

		CinemaRoom cnmRoom = new CinemaRoom(1, "The Sun", 50);
		cnmRoomDao.save(cnmRoom);
		
		Seat seat = new Seat(null, "1", 5, "Available", "VIP");
		seat.setCinemaRoom(cnmRoom);
		seatDao.save(seat);
		
		
		
		CinemaRoomDetail cnmRoomDetail = new CinemaRoomDetail(null, 5, new Date(), "So Nice");
		cnmRoomDetail.setCinemaRoom(cnmRoom);
		cnmRoomDetailDao.save(cnmRoomDetail);
		
		
	}
}
