package fa.training.dao;

import fa.training.entities.CinemaRoomDetail;

public interface CinemaRoomDetailDAO {
	public boolean save(CinemaRoomDetail cnmRoomDetail);

	public CinemaRoomDetail findCinemaRoomDetailById(Integer cnmRoomDetailId);

	public int updateDescription(Integer cnmRoomDetail, String description);

	public boolean deleteCinemaRoomDetailById(Integer cnmRoomDetailId);
}
