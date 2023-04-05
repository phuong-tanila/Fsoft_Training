package fa.training.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.CinemaRoomDAO;
import fa.training.entities.CinemaRoom;
import fa.training.utils.HibernateUtils;

public class CinemaRoomDaoImpl implements CinemaRoomDAO {

	public boolean save(CinemaRoom cnmRoom) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(cnmRoom);
			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public CinemaRoom findCinemaRoomById(Integer cnmRoomId) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			CinemaRoom cnm = (CinemaRoom) session.get(CinemaRoom.class, cnmRoomId);
			return cnm;
		} finally {
			if (session != null) {
			}
		}
	}

	public int updateNameCinemaRoomById(Integer cnmRoomId, String name) {
		Session session = null;
		Transaction transaction = null;

		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		String hql = "UPDATE CINEMA_ROOM set CINEMA_ROOM_NAME = :CINEMA_ROOM_NAME WHERE CINEMA_ROOM_ID = :CINEMA_ROOM_ID";

		Query query = session.createQuery(hql);
		query.setParameter("CINEMA_ROOM_ID", cnmRoomId);
		query.setParameter("CINEMA_ROOM_NAME", name);
		query.executeUpdate();

		int result = query.executeUpdate();

		System.out.println(result + " Record(s) Updated.");
		transaction.commit();

		session.clear();
		session.close();

		System.out.println("Transaction Completed !");
		return result;
	}

	public boolean deleteCinemaRoomById(Integer cnmRoomId) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "DELETE FROM CINEMA_ROOM WHERE CINEMA_ROOM_ID = :CINEMA_ROOM_ID";
			Query query = session.createQuery(hql);
			query.setParameter("CINEMA_ROOM_ID", cnmRoomId);

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
