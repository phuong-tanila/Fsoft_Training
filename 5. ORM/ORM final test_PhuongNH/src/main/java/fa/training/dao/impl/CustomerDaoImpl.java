package fa.training.dao.impl;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.*;

import org.hibernate.*;

import fa.training.constants.CustomerType;
import fa.training.constants.Sex;
import fa.training.dao.CustomerDao;
import fa.training.entities.Customer;
import fa.training.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	public boolean save(Customer customer) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(customer);
			transaction.commit();
			return (result != null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean delete(long customerId) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "DELETE FROM Customer WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", customerId);

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

	public int updateAddress(long customerId, String address) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		String hql = "UPDATE Customer set address = :address WHERE id = :id";

		Query query = session.createQuery(hql);
		query.setParameter("id", customerId);
		query.setParameter("address", address);
		query.executeUpdate();

		int result = query.executeUpdate();

		System.out.println(result + " Record(s) Updated.");
		transaction.commit();

		session.clear();
		session.close();

		System.out.println("Transaction Completed !");
		return result;
	}

	public Customer findCustomerById(long customerId) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Customer empl = (Customer) session.get(Customer.class, customerId);
			return empl;
		} finally {
			if (session != null) {
			}
		}
	}

	@Override
	public List<Customer> listOfCustomerByType(CustomerType type) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Customer a WHERE a.type = :type";
			Query q = session.createQuery(hql);
			q.setParameter("type", type);

			List<Customer> results = q.list();

			transaction.commit();

			for (Customer assignment : results) {
				System.out.println(assignment + "\n");
			}

			return results;
		} finally {
			if (session != null) {
				session.clear();
				session.close();
				System.out.println("Transaction Completed !");
			}
		}
	}
	
	public Long getTotalCustomerBySexAndBirthday() throws HibernateException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
			Root<Customer> root = criteriaQuery.from(Customer.class);
			Path<LocalDate> birthDate = root.get("birthday");
			Path<Sex> sex = root.get("sex");

			criteriaQuery.select(builder.count(root));
			criteriaQuery.where(builder.equal(birthDate, LocalDate.of(2001,05,11)));
			criteriaQuery.where(builder.equal(sex, Sex.MALE));
			Query query = session.createQuery(criteriaQuery);
			Long total = (Long) query.getSingleResult();
			System.out.println("Total = " + total);
			return total;
		} finally {
			if (session != null) {
				session.clear();
				session.close();
				System.out.println("Transaction Completed !");
			}
		}
	}
}
