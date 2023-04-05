package fa.training.dao.impl;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import fa.training.entities.Candidate;
import fa.training.entities.Interview;

public class InterviewDaoTest {
	private CandidateDaoImpl candiDao = new CandidateDaoImpl();
	private InterviewDaoImpl interDao = new InterviewDaoImpl();

	@Before
	public void setUpBeforeClass() {
		candiDao = new CandidateDaoImpl();
		interDao = new InterviewDaoImpl();
		Candidate candidate = new Candidate("Hoang Son", LocalDate.of(2020, 11, 1), 0, LocalDate.of(2020, 12, 1),
				"0123456789", "SonH@gmail.com", "Angluar", "Englich", 1, "Cv basic", 1, "Nice");
		candiDao.insert(candidate);

		Interview interview = new Interview("2020-11-11", LocalDate.of(2020, 11, 15), "HaCC", "Nice", "pass", "Nice");
		Set<Interview> interviewList = new HashSet<Interview>();
		interviewList.add(interview);
		candidate.setInterview(interviewList);
		interview.setCandidate(candidate);
		interDao.insert(interview);
	}

	@Test
	public void testInsert() throws Exception {
		Candidate candidate = candiDao.getById(7);
		Interview interview = new Interview("2020-11-11", LocalDate.of(2020, 11, 15), "HaCC", "Nice", "pass", "Nice");
		Set<Interview> interviewList = new HashSet<Interview>();
		interviewList.add(interview);
		candidate.setInterview(interviewList);
		interview.setCandidate(candidate);
		assertEquals(true, interDao.insert(interview));
	}

	@Test
	public void testUpdate() throws Exception {
		Interview interview = interDao.getById(15);
		interview.setTime("TimUpdate");
		;
		assertEquals(true, interDao.update(interview));
	}

	@Test
	public void testDelete() throws Exception {
		assertEquals(true, interDao.delete(7));
	}

	@Test
	public void testGetAll() throws Exception {
		ArrayList<Interview> list = interDao.getAll();
		assertEquals(true, list != null && !list.isEmpty());
	}

	@Test
	public void testGetById() throws Exception {
		assertEquals(true, interDao.getById(7) != null);
	}
}
