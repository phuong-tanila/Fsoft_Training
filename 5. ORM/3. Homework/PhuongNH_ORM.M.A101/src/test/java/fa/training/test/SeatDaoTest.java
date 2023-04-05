package fa.training.test;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fa.training.dao.SeatDAO;
import fa.training.dao.impl.SeatDaoImpl;
import fa.training.entities.CinemaRoom;
import fa.training.entities.Seat;

public class SeatDaoTest {
	static SeatDAO seatDao;

	@Before
	public void setUpBeforeClass() throws Exception {
		seatDao = new SeatDaoImpl();
	}
	
	@Test
	public void testSaveSeat() throws Exception {
		Seat seat = new Seat(null, "1", 4, "Available", "Normal");
		CinemaRoom cnmRoom = new CinemaRoom(2, "The Sun", 50);
		
		seat.setCinemaRoom(cnmRoom);
		assertEquals(true, seatDao.save(seat));
	}

	
	@Test
	public void testFindSeat() throws Exception{
		Seat seat = new Seat(1, "1", 1, "Available", "VIP");
		assertEquals(seat.toString(), seatDao.findSeatById(1).toString());
	}
}
