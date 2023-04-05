package fa.training.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.InterviewDao;
import fa.training.entities.Interview;
import fa.training.util.HibernateUtil;

public class InterviewDaoImpl implements InterviewDao{
	public Boolean insert(Interview interview) throws HibernateException{
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(interview);
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

	public Boolean update(Interview interview) throws HibernateException{
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.update(interview);
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

	public Boolean delete(int id) throws HibernateException{
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Interview interview = session.load(Interview.class, id);
			session.delete(interview);
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

	public ArrayList<Interview> getAll() throws HibernateException{
		Session session = null;
		ArrayList<Interview> result = new ArrayList<Interview>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			String hql = "FROM Interview";
			result = (ArrayList<Interview>) session.createQuery(hql, Interview.class).list();
			for (Interview interview : result) {
				System.out.print("EntryId : " + interview.getInterviewId());
				System.out.print(" Time : " + interview.getTime());
				System.out.print(" Email : " + interview.getComments());
				System.out.print(" ForeignLanguage : " + interview.getInterviewer());
				System.out.print(" Cv : " + interview.getInterviewResult());
				System.out.print(" Phone : " + interview.getRemark());
				System.out.print(" Remark : " + interview.getDate());
				System.out.print(" Skill : " + interview.getCandidate().getCandidateId()+"\n");
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

	public Interview getById(int id) throws HibernateException{
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Interview interview = session.get(Interview.class, id);

			System.out.print("EntryId : " + interview.getInterviewId());
			System.out.print(" Time : " + interview.getTime());
			System.out.print(" Email : " + interview.getComments());
			System.out.print(" ForeignLanguage : " + interview.getInterviewer());
			System.out.print(" Cv : " + interview.getInterviewResult());
			System.out.print(" Phone : " + interview.getRemark());
			System.out.print(" Remark : " + interview.getDate());
			System.out.print(" Skill : " + interview.getCandidate().getCandidateId()+"\n");
			session.clear();
			session.close();
			return interview;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
