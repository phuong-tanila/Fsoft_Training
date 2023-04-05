package fa.training.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.SeatDAO;
import fa.training.entities.Seat;
import fa.training.utils.HibernateUtils;

public class SeatDaoImpl implements SeatDAO {

	public boolean save(Seat seat) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(seat);
			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Seat findSeatById(Integer seatId) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Seat seat = (Seat) session.get(Seat.class, seatId);
			return seat;
		} finally {
			if (session != null) {
			}
		}
	}

	public int updateStatus(Integer seatId, String status) {
		Session session = null;
		Transaction transaction = null;

		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		String hql = "UPDATE SEAT set SEAT_STATUS = :SEAT_STATUS WHERE SEAT_ID = :SEAT_ID";

		Query query = session.createQuery(hql);
		query.setParameter("SEAT_ID", seatId);
		query.setParameter("SEAT_STATUS", status);
		query.executeUpdate();

		int result = query.executeUpdate();

		System.out.println(result + " Record(s) Updated.");
		transaction.commit();

		session.clear();
		session.close();

		System.out.println("Transaction Completed !");
		return result;
	}

	public boolean deleteSeat(Integer seatId) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "DELETE FROM SEAT WHERE SEAT_ID = :SEAT_ID";
			Query query = session.createQuery(hql);
			query.setParameter("SEAT_ID", seatId);

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
}
