package fa.training.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.CinemaRoomDetailDAO;
import fa.training.entities.CinemaRoomDetail;
import fa.training.utils.HibernateUtils;

public class CinemaRoomDetailDaoImpl implements CinemaRoomDetailDAO {

	public boolean save(CinemaRoomDetail cnmRoomDetail) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(cnmRoomDetail);
			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public CinemaRoomDetail findCinemaRoomDetailById(Integer cnmRoomDetailId) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			CinemaRoomDetail cnm = (CinemaRoomDetail) session.get(CinemaRoomDetail.class, cnmRoomDetailId);
			return cnm;
		} finally {
			if (session != null) {
			}
		}
	}

	public int updateDescription(Integer cnmRoomDetail, String description) {
		Session session = null;
		Transaction transaction = null;

		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		String hql = "UPDATE CINEMA_ROOM_DETAIL set ROOM_DESCRIPTION = :ROOM_DESCRIPTION"
				+ "WHERE CINEMA_ROOM_DETAIL_ID = :CINEMA_ROOM_DETAIL_ID";

		Query query = session.createQuery(hql);
		query.setParameter("CINEMA_ROOM_DETAIL_ID", cnmRoomDetail);
		query.setParameter("ROOM_DESCRIPTION", description);
		query.executeUpdate();

		int result = query.executeUpdate();

		System.out.println(result + " Record(s) Updated.");
		transaction.commit();

		session.clear();
		session.close();

		System.out.println("Transaction Completed !");
		return result;
	}

	public boolean deleteCinemaRoomDetailById(Integer cnmRoomDetailId) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "DELETE FROM CINEMA_ROOM_DETAIL WHERE CINEMA_ROOM_DETAIL_ID = :CINEMA_ROOM_DETAIL_ID";
			Query query = session.createQuery(hql);
			query.setParameter("CINEMA_ROOM_DETAIL_ID", cnmRoomDetailId);

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
