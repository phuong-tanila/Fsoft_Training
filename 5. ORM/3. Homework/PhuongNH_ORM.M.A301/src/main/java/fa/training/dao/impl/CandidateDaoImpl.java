package fa.training.dao.impl;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.CandidateDao;
import fa.training.entities.Candidate;
import fa.training.entities.Interview;
import fa.training.util.HibernateUtil;

public class CandidateDaoImpl implements CandidateDao {
	public Boolean insert(Candidate candidate) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(candidate);
			transaction.commit();
			session.clear();
			session.close();
			System.out.println("Transaction Completed !");
			return (result != null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Boolean update(Candidate candidate) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.update(candidate);
			transaction.commit();
			session.clear();
			session.close();
			System.out.println("Transaction Completed !");
			return true;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Boolean delete(Integer id) throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Candidate candidate = session.load(Candidate.class, id);
			session.delete(candidate);
			transaction.commit();
			session.clear();
			session.close();
			System.out.println("Transaction Completed !");
			return true;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public ArrayList<Candidate> getAll() throws HibernateException {
		Session session = null;
		ArrayList<Candidate> result = new ArrayList<Candidate>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			String hql = "FROM Candidate";
			result = (ArrayList<Candidate>) session.createQuery(hql, Candidate.class).list();
			for (Candidate candidate : result) {
				System.out.print("CandidateId : " + candidate.getCandidateId());
				System.out.print(" FullName : " + candidate.getFullName());
				System.out.print(" Email : " + candidate.getEmail());
				System.out.print(" ForeignLanguage : " + candidate.getForeignLanguage());
				System.out.print(" Cv : " + candidate.getCv());
				System.out.print(" Phone : " + candidate.getPhone());
				System.out.print(" Remark : " + candidate.getRemark());
				System.out.print(" Skill : " + candidate.getSkill());
				System.out.print(" AllocationStatus : " + candidate.getAllocationStatus());
				System.out.print(" Gender : " + candidate.getGender());
				System.out.print(" Level : " + candidate.getLevel());
				System.out.print(" DateOfBirth : " + candidate.getDateOfBirth());
				System.out.print(" GraduationYear : " + candidate.getGraduationYear() + "\n");

			}
			session.clear();
			session.close();
			return result;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Candidate getById(Integer candidateId) throws HibernateException {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Candidate candidate = session.get(Candidate.class, candidateId);

			System.out.print("CandidateId : " + candidate.getCandidateId());
			System.out.print(" FullName : " + candidate.getFullName());
			System.out.print(" Email : " + candidate.getEmail());
			System.out.print(" ForeignLanguage : " + candidate.getForeignLanguage());
			System.out.print(" Cv : " + candidate.getCv());
			System.out.print(" Phone : " + candidate.getPhone());
			System.out.print(" Remark : " + candidate.getRemark());
			System.out.print(" Skill : " + candidate.getSkill());
			System.out.print(" AllocationStatus : " + candidate.getAllocationStatus());
			System.out.print(" Gender : " + candidate.getGender());
			System.out.print(" Level : " + candidate.getLevel());
			System.out.print(" DateOfBirth : " + candidate.getDateOfBirth());
			System.out.print(" GraduationYear : " + candidate.getGraduationYear() + "\n");
			session.clear();
			session.close();
			return candidate;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Candidate> fillAllCandidateWithSkillLevel(String skillImport, Integer levelImport)
			throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Candidate c WHERE c.skill like (:skill) and c.level = :level";
			Query query = session.createQuery(hql);
			query.setParameter("skill", skillImport);
			query.setParameter("level", levelImport);
			List<Candidate> result = query.getResultList();
			transaction.commit();

			for (Candidate candidate : result) {
				System.out.print("CandidateId : " + candidate.getCandidateId());
				System.out.print(" FullName : " + candidate.getFullName());
				System.out.print(" Email : " + candidate.getEmail());
				System.out.print(" ForeignLanguage : " + candidate.getForeignLanguage());
				System.out.print(" Cv : " + candidate.getCv());
				System.out.print(" Phone : " + candidate.getPhone());
				System.out.print(" Remark : " + candidate.getRemark());
				System.out.print(" Skill : " + candidate.getSkill());
				System.out.print(" AllocationStatus : " + candidate.getAllocationStatus());
				System.out.print(" Gender : " + candidate.getGender());
				System.out.print(" Level : " + candidate.getLevel());
				System.out.print(" DateOfBirth : " + candidate.getDateOfBirth());
				System.out.print(" GraduationYear : " + candidate.getGraduationYear() + "\n");
			}
			session.clear();
			session.close();
			System.out.print("Transaction Completed !" + "\n");
			return result;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Candidate> fillAllCandidateWithSkillForeignLanguage(String skillImport, String foreignLanguageImport)
			throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Candidate c WHERE c.skill like (:skill) and c.foreignLanguage like (:foreignLanguage)";
			Query query = session.createQuery(hql);
			query.setParameter("skill", skillImport);
			query.setParameter("foreignLanguage", foreignLanguageImport);
			List<Candidate> result = query.getResultList();
			transaction.commit();

			for (Candidate candidate : result) {
				System.out.print("CandidateId : " + candidate.getCandidateId());
				System.out.print(" FullName : " + candidate.getFullName());
				System.out.print(" Email : " + candidate.getEmail());
				System.out.print(" ForeignLanguage : " + candidate.getForeignLanguage());
				System.out.print(" Cv : " + candidate.getCv());
				System.out.print(" Phone : " + candidate.getPhone());
				System.out.print(" Remark : " + candidate.getRemark());
				System.out.print(" Skill : " + candidate.getSkill());
				System.out.print(" AllocationStatus : " + candidate.getAllocationStatus());
				System.out.print(" Gender : " + candidate.getGender());
				System.out.print(" Level : " + candidate.getLevel());
				System.out.print(" DateOfBirth : " + candidate.getDateOfBirth());
				System.out.print(" GraduationYear : " + candidate.getGraduationYear() + "\n");
			}
			session.clear();
			session.close();
			System.out.print("Transaction Completed !");
			return result;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Object[]> fillAllCandidateWithSkillEntryTestResultDate(String skill, String result, LocalDate date)
			throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "FROM Candidate c INNER JOIN c.entryTest e WHERE c.skill like (:skill) and e.result like (:result) and e.date = :date ";
			Query query = session.createQuery(hql);
			query.setParameter("date", date);
			query.setParameter("result", result);
			query.setParameter("skill", skill);
			List<Object[]> candidateList = query.getResultList();
			transaction.commit();
			for (Object[] objects : candidateList) {
				System.out.println(objects[0] + " ");
				System.out.println(objects[1] + " ");
			}
			session.clear();
			session.close();
			System.out.print("Transaction Completed !");
			return candidateList;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Candidate> fillAllCandidateWithInterviewDate() throws HibernateException {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Candidate> criteria = builder.createQuery(Candidate.class);
			Root<Interview> interviewRoot = criteria.from(Interview.class);
			Root<Candidate> candidateRoot = criteria.from(Candidate.class);
			criteria.select(candidateRoot);
			criteria.where(builder.and(builder.equal(interviewRoot.get("candidate"), candidateRoot.get("candidateId")),
					builder.equal(candidateRoot.get("skill"), "Angluar"),
					builder.equal(interviewRoot.get("interviewResult"), "pass"),
					builder.equal(interviewRoot.get("date"), LocalDate.of(2020, 11, 15))));

			Query query = session.createQuery(criteria);
			List<Candidate> list = query.getResultList();
			for (Candidate candidate : list) {
				System.out.print("CandidateId : " + candidate.getCandidateId());
				System.out.print(" FullName : " + candidate.getFullName());
				System.out.print(" Email : " + candidate.getEmail());
				System.out.print(" ForeignLanguage : " + candidate.getForeignLanguage());
				System.out.print(" Cv : " + candidate.getCv());
				System.out.print(" Phone : " + candidate.getPhone());
				System.out.print(" Remark : " + candidate.getRemark());
				System.out.print(" Skill : " + candidate.getSkill());
				System.out.print(" AllocationStatus : " + candidate.getAllocationStatus());
				System.out.print(" Gender : " + candidate.getGender());
				System.out.print(" Level : " + candidate.getLevel());
				System.out.print(" DateOfBirth : " + candidate.getDateOfBirth());
				System.out.print(" GraduationYear : " + candidate.getGraduationYear() + "\n");
			}
			session.clear();
			session.close();
			return list;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Boolean updateRemarkCandidateDoNotHaveEitherPhoneEmailCv() throws HibernateException {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			transaction = session.beginTransaction();
			CriteriaUpdate<Candidate> criteriaUpdate = builder.createCriteriaUpdate(Candidate.class);

			Root<Candidate> candidateRoot = criteriaUpdate.from(Candidate.class);
			Path<String> remark = candidateRoot.get("remark");
			criteriaUpdate.set(remark, "inactive");
			criteriaUpdate.where(builder.or(builder.equal(candidateRoot.get("cv"), ""),
					builder.equal(candidateRoot.get("email"), ""), builder.equal(candidateRoot.get("phone"), "")));
			Query query = session.createQuery(criteriaUpdate);
			Integer list = query.executeUpdate();
			transaction.commit();
			session.clear();
			session.close();
			return list != null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Candidate> search(Integer pageNumber, Integer pageSize) throws HibernateException {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Candidate> criteria = builder.createQuery(Candidate.class);
			Root<Candidate> candidateRoot = criteria.from(Candidate.class);
			criteria.select(candidateRoot);
			Query query = session.createQuery(criteria);
			query.setFirstResult(pageNumber);
			query.setMaxResults(pageSize);
			List<Candidate> list = query.getResultList();

			for (Candidate candidate : list) {
				System.out.print("CandidateId : " + candidate.getCandidateId());
				System.out.print(" FullName : " + candidate.getFullName());
				System.out.print(" Email : " + candidate.getEmail());
				System.out.print(" ForeignLanguage : " + candidate.getForeignLanguage());
				System.out.print(" Cv : " + candidate.getCv());
				System.out.print(" Phone : " + candidate.getPhone());
				System.out.print(" Remark : " + candidate.getRemark());
				System.out.print(" Skill : " + candidate.getSkill());
				System.out.print(" AllocationStatus : " + candidate.getAllocationStatus());
				System.out.print(" Gender : " + candidate.getGender());
				System.out.print(" Level : " + candidate.getLevel());
				System.out.print(" DateOfBirth : " + candidate.getDateOfBirth());
				System.out.print(" GraduationYear : " + candidate.getGraduationYear() + "\n");
			}
			session.clear();
			session.close();
			return list;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
