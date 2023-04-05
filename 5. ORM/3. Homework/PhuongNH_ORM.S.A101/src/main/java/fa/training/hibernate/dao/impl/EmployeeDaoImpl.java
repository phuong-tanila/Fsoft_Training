package fa.training.hibernate.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.hibernate.dao.EmployeeDAO;
import fa.training.hibernate.model.Employee;
import fa.training.hibernate.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDAO {
	public boolean save(Employee emp) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Serializable result = session.save(emp);
			transaction.commit();
			return (result != null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Employee findEmployeeById(Integer empId) {
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Employee empl = (Employee) session.get(Employee.class, empId);
			return empl;
		} finally {
			if (session != null) {
			}
		}
	}

	public int updateFisrtName(Integer empId, String firstName) {
		Session session = null;
		Transaction transaction = null;

		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		String hql = "UPDATE Employee set First_Name = :First_Name WHERE ID = :ID";

		Query query = session.createQuery(hql);
		query.setParameter("ID", empId);
		query.setParameter("First_Name", firstName);
		query.executeUpdate();

		int result = query.executeUpdate();

		System.out.println(result + " Record(s) Updated.");
		transaction.commit();

		session.clear();
		session.close();

		System.out.println("Transaction Completed !");
		return result;
	}

	public boolean deleteEmployee(Integer empId) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "DELETE FROM Employee WHERE ID = :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", empId);

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
