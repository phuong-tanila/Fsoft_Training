package fa.training.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.constants.Status;
import fa.training.constants.Type;
import fa.training.dao.AssignmentDao;
import fa.training.entity.Assignment;
import fa.training.entity.SubjectAssigment;
import fa.training.util.HibernateUtil;

public class AssignmentDaoImpl implements AssignmentDao {
	@Override
	public boolean save(Assignment assignment) throws HibernateException {
		if (assignment == null) {
			return false;
		}
		// set default value for estimate time based on type of Assignment.
		if (assignment.getEstimateTime() <= 0 && assignment.getType() != null) {
			assignment.setEstimateTime(assignment.getType().getEstimateTime());
		}
		// set default active status.
		assignment.setStatus(Status.ACTIVE);
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(assignment);
			transaction.commit();
			return true;
		}
	}

	@Override
	public boolean delete(String assignmentId) throws HibernateException {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Assignment assignment = session.get(Assignment.class, assignmentId);
			if (assignment == null) {
				return false;
			}
			// remove in cache
			session.evict(assignment);
			assignment.setStatus(Status.INACTIVE);
			session.update(assignment);
			transaction.commit();
			return true;
		}
	}

	@Override
	public Assignment release(String assignmentId) throws HibernateException {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Assignment assignment = session.get(Assignment.class, assignmentId);
			if (assignment == null) {
				return null;
			}
			// remove in cache
			session.evict(assignment);
			assignment.setStatus(Status.RELEASED);
			assignment.setReleasedDate(LocalDate.now());
			session.update(assignment);
			transaction.commit();
			return assignment;
		}
	}

	@Override
	public List<Assignment> listOfAssignmentByType(Type type) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Assignment a WHERE a.type = :type";
			Query q = session.createQuery(hql);
			q.setParameter("type", type);

			List<Assignment> results = q.list();

			transaction.commit();

			for (Assignment assignment : results) {
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

	@Override
	public List<Object[]> assignmentTableByTypeAndStatus(Type type, Status status) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
			Root<Assignment> rootAssignment = criteria.from(Assignment.class);

			Path<Type> typeAssignment = rootAssignment.get("type");
			Path<Status> statusAssignment = rootAssignment.get("status");
			criteria.select(builder.array(typeAssignment, statusAssignment, builder.count(rootAssignment)));
			criteria.where(builder.equal(rootAssignment.get("type"), type));
			criteria.where(builder.equal(rootAssignment.get("status"), status));
			criteria.groupBy(rootAssignment.get("type"), rootAssignment.get("status"));

			Query q = session.createQuery(criteria);

			List<Object[]> list = q.getResultList();

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

	public static void main(String[] args) {
		AssignmentDao dao = new AssignmentDaoImpl();
//		List<Assignment> list = dao.listOfAssignmentByType(Type.SHORT);

//		List<SubjectAssigment> list = dao.findAllSubjectHasAssignment();
//		for (SubjectAssigment o : list) {
//			System.out.println(o + "\n");
//		}

		dao.assignmentTableByTypeAndStatus(Type.SHORT, Status.RELEASED);
//		for (Object[] o : list) {
//			System.out.println(o + "\n");
//		}

	}

}
