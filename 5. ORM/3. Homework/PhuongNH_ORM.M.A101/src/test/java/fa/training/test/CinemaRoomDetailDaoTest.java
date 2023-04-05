package fa.training.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import fa.training.dao.CinemaRoomDetailDAO;
import fa.training.dao.impl.CinemaRoomDetailDaoImpl;
import fa.training.entities.CinemaRoom;
import fa.training.entities.CinemaRoomDetail;


public class CinemaRoomDetailDaoTest {
	static CinemaRoomDetailDAO cnmRoomDetailDao;

	@Before
	public void setUpBeforeClass() throws Exception {
		cnmRoomDetailDao = new CinemaRoomDetailDaoImpl();
	}
	
	@Test
	public void testSaveCinemaRoomDetail() throws Exception {
		CinemaRoomDetail cnmRoomDetail = new CinemaRoomDetail(null, 5, new Date(), "So Nice");
		CinemaRoom cnmRoom = new CinemaRoom(2, "The Sun", 50);
		
		cnmRoomDetail.setCinemaRoom(cnmRoom);
		assertEquals(true, cnmRoomDetailDao.save(cnmRoomDetail));
	}

	
	@Test
	public void testFindCinemaRoomDetail() throws Exception{
		CinemaRoomDetail cnmRoomDetail = new CinemaRoomDetail(1, 5, new Date(), "So Nice");
		assertEquals(cnmRoomDetail.toString(), cnmRoomDetailDao.findCinemaRoomDetailById(1).toString());
	}
	
}
