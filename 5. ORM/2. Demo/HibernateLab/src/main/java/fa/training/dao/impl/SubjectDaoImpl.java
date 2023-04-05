package fa.training.dao.impl;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.SubjectDao;
import fa.training.entity.Assignment;
import fa.training.entity.Subject;
import fa.training.util.HibernateUtil;

public class SubjectDaoImpl implements SubjectDao {

	public boolean save(Subject subject) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(subject);

			transaction.commit();

			return (result != null);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Object[]> findAllSubjectHasAssignment() throws HibernateException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

			Root<Assignment> assignmentRoot = criteria.from(Assignment.class);
			Root<Subject> subjectRoot = criteria.from(Subject.class);

			criteria.multiselect(subjectRoot.get("name"), subjectRoot.get("description"), assignmentRoot);
			criteria.where(builder.equal(assignmentRoot.get("subject"), subjectRoot.get("id")));
			Query query = session.createQuery(criteria);
			List<Object[]> list = query.getResultList();

			for (Object[] o : list) {
				System.out.println(o + "\n");
			}

			transaction.commit();
			return list;
		} finally {
			if (session != null) {
				session.clear();
				session.close();
				System.out.println("Transaction Completed !");
			}
		}
	}

	public Long getTotalSubjectHasGreaterThanCreated() throws HibernateException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
			Root<Subject> root = criteriaQuery.from(Subject.class);
			Path<LocalDate> createDate = root.get("createdOn");

			criteriaQuery.select(builder.count(root));
			criteriaQuery.where(builder.greaterThanOrEqualTo(createDate, LocalDate.of(2020,01,01)));
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

	public static void main(String[] args) {
		SubjectDao dao = new SubjectDaoImpl();

//		List<Subject> list = dao.getSubjectsByCreateOn(LocalDate.of(2022, 12, 20));
//		for (Subject o : list) {
//			System.out.println(o + "\n");
//		}

//		List<Object[]> list = dao.findAllSubjectHasAssignment();
		
		dao.getTotalSubjectHasGreaterThanCreated();

	}
}
