package fa.training.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.dao.MovieTypeDao;
import fa.training.entities.MovieType;
import fa.training.util.HibernateUtil;

public class MovieTypeDaoImpl implements MovieTypeDao<MovieType> {
	public boolean insert(MovieType movieType) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(movieType);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean update(MovieType movieType) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String querryString = "UPDATE MOVIE_TYPE mt SET mt.Description= :Description WHERE TypeId= :TypeId";
			Query query = session.createQuery(querryString);

			query.setParameter("TypeId", movieType.getType());
			query.setParameter("Description", movieType.getMyDescription());
			query.executeUpdate();
			int count = query.executeUpdate();

			System.out.println(count + " Record(s) Updated.");
			transaction.commit();
			session.clear();
			session.close();
			System.out.println("Transaction Conplete!");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(MovieType movieType) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String querryString = "DELETE FROM MOVIE_TYE mt WHERE mt.TypeId= :TypeId";
			Query query = session.createQuery(querryString);

			query.setParameter("TypeId", movieType.getType());
			query.executeUpdate();
			int count = query.executeUpdate();

			System.out.println(count + " Record(s) Delete");
			transaction.commit();
			session.clear();
			session.close();
			System.out.println("Transaction Complete!");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<MovieType> getAllCustomer() {
		Session session = null;
		Transaction transaction = null;
		ArrayList<MovieType> result = new ArrayList<MovieType>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String HQL = "FROM MOVIE_TYPE";
			result = (ArrayList<MovieType>) session.createQuery(HQL, MovieType.class).list();

			transaction.commit();
			session.clear();
			session.close();
			return result;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	public MovieType getByPk(MovieType movieType) {
		Session session = null;
		Transaction transaction = null;
		MovieType result = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();

			String querryString = "FROM MOVIE_TYPE mt WHERE mt.TypeId= :TypeId";
			Query query = session.createQuery(querryString);
			result = (MovieType) ((org.hibernate.query.Query) query.setParameter("Type", movieType.getType())).uniqueResult();

			session.clear();
			session.close();
			System.out.println("Transaction Complete!");
			return result;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
}
