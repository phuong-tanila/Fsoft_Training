package fa.training.dao;

import fa.training.entities.CinemaRoom;

public interface CinemaRoomDAO {
	public boolean save(CinemaRoom cnmRoom);
	
	public CinemaRoom findCinemaRoomById(Integer cnmRoomId);

	public int updateNameCinemaRoomById(Integer cnmRoomId, String name);
	
	public boolean deleteCinemaRoomById(Integer cnmRoomId);
}
