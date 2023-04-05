package fa.training.dao;

import fa.training.entities.Seat;

public interface SeatDAO {
	public boolean save(Seat seat);
	
	public Seat findSeatById(Integer seatId);

	public int updateStatus(Integer seatId, String status);
	
	public boolean deleteSeat(Integer seatId);
}
