package fa.training.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fa.training.dao.CinemaRoomDAO;
import fa.training.dao.impl.CinemaRoomDaoImpl;
import fa.training.entities.CinemaRoom;


public class CinemaRoomDaoTest {
	static CinemaRoomDAO cnmRoomDao;

	@Before
	public void setUpBeforeClass() throws Exception {
		cnmRoomDao = new CinemaRoomDaoImpl();
	}
	
	@Test
	public void testSaveCinemaRoom() throws Exception {
		CinemaRoom cnmRoom = new CinemaRoom(null, "The Sun", 50);
		assertEquals(true, cnmRoomDao.save(cnmRoom));
	}

	
	@Test
	public void testFindCinemaRoom() throws Exception{
		CinemaRoom cnmRoom = new CinemaRoom(1, "The Sun", 50);
		assertEquals(cnmRoom.toString(), cnmRoomDao.findCinemaRoomById(1).toString());
	}
}
