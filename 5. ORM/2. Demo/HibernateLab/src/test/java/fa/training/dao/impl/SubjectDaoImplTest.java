package fa.training.dao.impl;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import fa.training.entity.Subject;

public class SubjectDaoImplTest {
	private SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();

	@Test
	public void save_success() {
		Subject subject = new Subject();
		subject.setName("Hibernate");
		subject.setDescription("ORM topic");
		subject.setCreatedOn(LocalDate.of(2020, 1, 1));
		boolean actual = subjectDaoImpl.save(subject);
		assertTrue(actual);
	}

	@Test(expected = ConstraintViolationException.class)
	public void save_failed() {
		Subject subject = new Subject();
		subject.setName(null);
		subject.setDescription("WEB topic");
		subjectDaoImpl.save(subject);
	}
}
