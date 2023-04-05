package fa.training.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.EntryTestDao;
import fa.training.entities.EntryTest;
import fa.training.util.HibernateUtil;

public class EntryTestDaoImpl implements EntryTestDao {
	public Boolean insert(EntryTest entryTest) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(entryTest);
			transaction.commit();
			session.clear();
			session.close();
			System.out.println("Transaction Completed !");
			return (result != null);
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Boolean update(EntryTest entryTest) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.update(entryTest);
			transaction.commit();
			session.clear();
			session.close();
			System.out.println("Transaction Completed !");
			return true;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Boolean delete(int id) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			EntryTest entryTest = session.load(EntryTest.class, id);
			session.delete(entryTest);
			transaction.commit();
			session.clear();
			session.close();
			System.out.println("Transaction Completed !");
			return true;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public ArrayList<EntryTest> getAll() throws HibernateException {
		Session session = null;
		ArrayList<EntryTest> result = new ArrayList<EntryTest>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			String hql = "FROM EntryTest";
			result = (ArrayList<EntryTest>) session.createQuery(hql, EntryTest.class).list();
			for (EntryTest entryTest : result) {
				System.out.print("EntryId : " + entryTest.getTestId());
				System.out.print(" Time : " + entryTest.getTime());
				System.out.print(" EntryTestSkill : " + entryTest.getEntryTestSkill());
				System.out.print(" LanguageValuator : " + entryTest.getLanguageValuator());
				System.out.print(" Remark : " + entryTest.getRemark());
				System.out.print(" Result : " + entryTest.getResult());
				System.out.print(" TechnicalValuator : " + entryTest.getTechnicalValuator());
				System.out.print(" Date : " + entryTest.getDate());
				System.out.print(" LanguageResult : " + entryTest.getLanguageResult());
				System.out.print(" TechnicalResult : " + entryTest.getTechnicalResult());
				System.out.print(" CandidateId : " + entryTest.getCandidate().getCandidateId() + "\n");
			}
			session.clear();
			session.close();
			return result;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public EntryTest getById(int id) throws HibernateException {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			EntryTest entryTest = session.get(EntryTest.class, id);

			System.out.print("EntryId : " + entryTest.getTestId());
			System.out.print(" Time : " + entryTest.getTime());
			System.out.print(" EntryTestSkill : " + entryTest.getEntryTestSkill());
			System.out.print(" LanguageValuator : " + entryTest.getLanguageValuator());
			System.out.print(" Remark : " + entryTest.getRemark());
			System.out.print(" Result : " + entryTest.getResult());
			System.out.print(" TechnicalValuator : " + entryTest.getTechnicalValuator());
			System.out.print(" Date : " + entryTest.getDate());
			System.out.print(" LanguageResult : " + entryTest.getLanguageResult());
			System.out.print(" TechnicalResult : " + entryTest.getTechnicalResult());
			System.out.print(" CandidateId : " + entryTest.getCandidate().getCandidateId() + "\n");
			session.clear();
			session.close();
			return entryTest;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
