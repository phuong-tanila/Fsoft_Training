package fa.training.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.dao.MovieDao;
import fa.training.entities.Movie;
import fa.training.util.HibernateUtil;

public class MovieDaoImpl implements MovieDao<Movie> {
	public boolean insert(Movie movie) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(movie);
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

	public boolean update(Movie movie) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String querryString = "UPDATE MOVIE m SET m.Actor= :Actor WHERE MovieId= :MovieId";
			Query query = session.createQuery(querryString);

			query.setParameter("MovieId", movie.getMovieId());
			query.setParameter("Actor", movie.getActor());
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

	public boolean delete(Movie movie) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String querryString = "DELETE FROM Movie m WHERE m.MovieId= :MovieId";
			Query query = session.createQuery(querryString);

			query.setParameter("MovieId", movie.getMovieId());
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

	public ArrayList<Movie> getAllCustomer() {
		Session session = null;
		Transaction transaction = null;
		ArrayList<Movie> result = new ArrayList<Movie>();

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String HQL = "FROM Movie";
			result = (ArrayList<Movie>) session.createQuery(HQL, Movie.class).list();

			transaction.commit();
			session.clear();
			session.close();
			return result;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Movie getByPk(Movie movie) {
		Session session = null;
		Transaction transaction = null;
		Movie result = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();

			String querryString = "FROM Movie m WHERE m.MovieId= :MovieId";
			Query query = session.createQuery(querryString);
			result = (Movie) ((org.hibernate.query.Query) query.setParameter("MovieId", movie.getMovieId())).uniqueResult();

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
