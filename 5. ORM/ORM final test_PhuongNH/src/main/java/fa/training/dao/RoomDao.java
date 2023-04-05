package fa.training.dao;

import org.hibernate.HibernateException;

import fa.training.entities.Room;

public interface RoomDao {
	boolean save(Room room);

	boolean delete(final long roomId) throws HibernateException;

	Room checkout(final long roomId) throws HibernateException;
}
