package fa.training.dao.impl;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.constants.RoomType;
import fa.training.dao.RoomDao;
import fa.training.entities.Customer;
import fa.training.entities.Room;
import fa.training.util.HibernateUtil;

public class RoomDaoImpl implements RoomDao {

	@Override
	public boolean save(Room room) {
		if (room == null) {
			return false;
		}
		room.setStartDate(LocalDate.now());
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(room);
			transaction.commit();
			return true;
		}
	}
	

	@Override
	public boolean delete(long roomId) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "DELETE FROM Room WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", roomId);

			int result = query.executeUpdate();

			System.out.println(result + " Record(s) Deleted.");
			transaction.commit();
			return true;
		} finally {
			if (session != null) {
				session.clear();
				session.close();
				System.out.println("Transaction Completed !");
			}
		}
	}

	@Override
	public Room checkout(long roomId) throws HibernateException {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Room room = session.get(Room.class, roomId);
			if (room == null) {
				return null;
			}
			// remove in cache
			session.evict(room);
			room.setEndDate(LocalDate.now());
			session.update(room);
			transaction.commit();
			return room;
		}
	}
}
