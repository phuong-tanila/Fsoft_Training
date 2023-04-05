package fa.training.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;

import fa.training.constants.Status;
import fa.training.constants.Type;
import fa.training.entity.Assignment;
import fa.training.entity.Subject;

public class AssignmentDaoImplTest {
	private AssignmentDaoImpl assignmentDaoImpl;
	private SubjectDaoImpl subjectDaoImpl;
	private int authorId = 1;
	private Subject subject;
	private Assignment assignment;
	private long time = new Date().getTime();

	@Before
	public void initialize() {
		assignmentDaoImpl = new AssignmentDaoImpl();
		subjectDaoImpl = new SubjectDaoImpl();
		// mock Subject
		subject = new Subject();
		subject.setName("Java");
		subject.setDescription("Java basic");
		subjectDaoImpl.save(subject);
		// mock Assignment
		assignment = new Assignment();
		assignment.setCodeId("JAVA.S." + time);
		assignment.setAuthorId(authorId);
		assignment.setPathFile("JAVA.S.101.doc");
		assignment.setType(Type.SHORT);
		assignment.setSubject(subject);
		assignmentDaoImpl.save(assignment);
	}

	@Test
	public void save_success() {
		Assignment assignment = new Assignment();
		assignment.setCodeId("JAVA.L." + time);
		assignment.setAuthorId(authorId);
		assignment.setPathFile("JAVA.L.101.doc");
		assignment.setType(Type.LONG);
		assignment.setSubject(subject);
		boolean actual = assignmentDaoImpl.save(assignment);
		assertTrue(actual);
		assertEquals(Status.ACTIVE, assignment.getStatus());
	}

	@Test(expected = ConstraintViolationException.class)
	public void save_failed() {
		Assignment assignment = new Assignment();
		assignment.setCodeId("JAVA.S." + time);
		assignment.setAuthorId(authorId);
		assignment.setPathFile("JAVA.L.101.PNG");
		assignment.setType(Type.MEDIUM);
		assignment.setSubject(subject);
		assignmentDaoImpl.save(assignment);
	}
	

//	@Test
//	public void approve_success() {
//		Assignment actual = assignmentDaoImpl.release(assignment.getCodeId());
//		assertNotNull(actual);
//		assertEquals(Status.RELEASED, actual.getStatus());
//		assertEquals(LocalDate.now(), actual.getReleasedDate());
//	}

	@Test
	public void delete_success() {
		boolean actual = assignmentDaoImpl.delete(assignment.getCodeId());
		assertTrue(actual);
	}
	
//	@Test
//	public void testListOfAssignmentByType() {
//		List<Assignment> list = assignmentDaoImpl.listOfAssignmentByType(Type.LONG);
//		assertEquals(true, list!=null && !list.isEmpty());
//		
//	}
	
	@Test
	public void testAssignmentTableByTypeAndStatus() {
		List<Object[]> list = assignmentDaoImpl.assignmentTableByTypeAndStatus(Type.SHORT,Status.ACTIVE);
		assertEquals(true, list!=null && !list.isEmpty());
		
	}
}