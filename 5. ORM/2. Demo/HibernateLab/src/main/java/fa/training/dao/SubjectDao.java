package fa.training.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;

import fa.training.entity.Subject;

public interface SubjectDao {
	boolean save(Subject intsubject) throws HibernateException;
	
	List<Object[]> findAllSubjectHasAssignment() throws HibernateException;
	
	Long getTotalSubjectHasGreaterThanCreated() throws HibernateException;
}