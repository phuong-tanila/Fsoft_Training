package fa.training.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.dao.TypeDao;
import fa.training.entities.Type;
import fa.training.util.HibernateUtil;

public class TypeDaoImpl implements TypeDao<Type> {

	public boolean insert(Type type) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(type);
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

	public boolean update(Type type) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String querryString = "UPDATE TYPE t SET t.typeName= :typeName WHERE typeId= :typeId";
			Query query = session.createQuery(querryString);

			query.setParameter("typeId", type.getTypeId());
			query.setParameter("typeName", type.getTypeName());
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

	public boolean delete(Type type) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String querryString = "DELETE FROM TYPE t WHERE t.TypeId= :TypeId";
			Query query = session.createQuery(querryString);

			query.setParameter("TypeId", type.getTypeId());
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

	public ArrayList<Type> getAll() {
		Session session = null;
		Transaction transaction = null;
		ArrayList<Type> result = new ArrayList<Type>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String HQL = "FROM TYPE";
			result = (ArrayList<Type>) session.createQuery(HQL, Type.class).list();
			
			transaction.commit();
			session.clear();
			session.close();
			
			return result;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Type getByPk(Type type) {
		Session session = null;
		Transaction transaction = null;
		Type result = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			String querryString = "FROM TYPE t WHERE r.TypeId= :TypeId";
			Query query = session.createQuery(querryString);
			result = (Type) ((org.hibernate.query.Query) query.setParameter("TypeId", type.getTypeId())).uniqueResult();
			
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
