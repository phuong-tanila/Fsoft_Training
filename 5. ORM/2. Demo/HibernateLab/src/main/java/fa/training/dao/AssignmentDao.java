package fa.training.dao;

import java.util.List;

import org.hibernate.HibernateException;

import fa.training.constants.Status;
import fa.training.constants.Type;
import fa.training.entity.Assignment;
import fa.training.entity.SubjectAssigment;

public interface AssignmentDao {
	boolean save(Assignment assignment);

	boolean delete(final String assignmentId) throws HibernateException;

	Assignment release(final String assignmentId) throws HibernateException;
	
	List<Assignment>listOfAssignmentByType(Type type);
	
	List<Object[]> assignmentTableByTypeAndStatus(Type type, Status status);
}
