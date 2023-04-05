package fa.training.dao.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.entities.Interview;

public class CandidateDaoTest {

	private CandidateDaoImpl candiDao = new CandidateDaoImpl();
	private InterviewDaoImpl interDao = new InterviewDaoImpl();
	private EntryTestDaoImpl entryDao = new EntryTestDaoImpl();

	@Before
	public void setUpBeforeClass() {
		candiDao = new CandidateDaoImpl();
		interDao = new InterviewDaoImpl();
		entryDao = new EntryTestDaoImpl();

		Candidate candidate = new Candidate("Hoai Phuong", LocalDate.of(2020, 11, 1), 0, LocalDate.of(2020, 12, 1),
				"0797575794", "phuongnh@gmail.com", "Angluar", "Japanese", 2, "Cv intern", 1, "Good");
		candiDao.insert(candidate);

		Interview interview = new Interview("2020-11-13", LocalDate.of(2020, 11, 15), "HaCC", "Good",
				"pass", "Good");
		Set<Interview> interviewList = new HashSet<Interview>();
		interviewList.add(interview);
		candidate.setInterview(interviewList);
		interview.setCandidate(candidate);
		interDao.insert(interview);

		EntryTest entryTest = new EntryTest("2020-11-20", LocalDate.of(2020, 11, 17), "Good job",
				new BigDecimal(2), "Good", new BigDecimal(2), "pass", "Good", "Angluar");
		Set<EntryTest> entryTestList = new HashSet<EntryTest>();
		entryTestList.add(entryTest);
		candidate.setEntryTest(entryTestList);
		entryTest.setCandidate(candidate);
		entryDao.insert(entryTest);
	}

	@Test
	public void testInsert() throws Exception {
		Candidate candidate = new Candidate("fullName", LocalDate.of(2020, 11, 1), 0, LocalDate.of(2020, 12, 1),
				"phone001", "vanson@gmail.com", "Angluar", "Englich", 1, "Cv basic", 1, "remark001");
		assertEquals(true, candiDao.insert(candidate));
	}

	@Test
	public void testInsert2() throws Exception {
		Candidate candidate = new Candidate("fullName02", LocalDate.of(2020, 11, 15), 0, LocalDate.of(2020, 12, 15),
				"phone002", "vanson02@gmail.com", "Angluar", "Japanese", 2, "", 1, "remark002");
		assertEquals(true, candiDao.insert(candidate));
	}

	@Test
	public void testInsert3() throws Exception {
		Candidate candidate = new Candidate("fullName03", LocalDate.of(2020, 11, 1), 0, LocalDate.of(2020, 12, 1), "",
				"vanson03@gmail.com", "Python/ML", "Japanese", 1, "Cv basic", 1, "remark003");
		assertEquals(true, candiDao.insert(candidate));
	}

	@Test
	public void testInsert4() throws Exception {
		Candidate candidate = new Candidate("fullName04", LocalDate.of(2020, 11, 1), 0, LocalDate.of(2020, 12, 1),
				"phone004", "", "Python", "Englich", 2, "Cv basic", 1, "remark004");
		assertEquals(true, candiDao.insert(candidate));
	}

	@Test
	public void testUpdate() throws Exception {
		Candidate candidate = candiDao.getById(7);
		candidate.setFullName("FullNameUpDate");
		candidate.setCv("CV Update");
		assertEquals(true, candiDao.update(candidate));
	}

	@Test
	public void testDelete() throws Exception {
		assertEquals(true, candiDao.delete(1));
	}

	@Test
	public void testGetAll() throws Exception {
		ArrayList<Candidate> list = candiDao.getAll();
		assertEquals(true, list != null && !list.isEmpty());
	}

	@Test
	public void testGetById() throws Exception {
		assertEquals(true, candiDao.getById(1) != null);
	}

	@Test
	public void testFillAllCandidateWithSkillLevel() throws Exception {
		List<Candidate> list = candiDao.fillAllCandidateWithSkillLevel("Angluar", 2);
		assertEquals(true, list != null && !list.isEmpty());
	}

	@Test
	public void testFillAllCandidateWithSkillForeignLanguage() throws Exception {
		List<Candidate> list = candiDao.fillAllCandidateWithSkillForeignLanguage("Angluar", "Japanese");
		assertEquals(true, list != null && !list.isEmpty());
	}

	@Test
	public void testFillAllCandidateWithSkillEntryTestResultDate() throws Exception {
		List<Object[]> list = candiDao.fillAllCandidateWithSkillEntryTestResultDate("Angluar", "pass",
				LocalDate.of(2020, 11, 1));
		assertEquals(true, list != null && !list.isEmpty());
	}

	@Test
	public void testFillAllCandidateWithInterviewDate() throws Exception {
		List<Candidate> list = candiDao.fillAllCandidateWithInterviewDate();
		assertEquals(true, list != null && !list.isEmpty());
	}

	@Test
	public void testUpdateRemarkCandidateDoNotHaveEitherPhoneEmailCv() throws Exception {
		assertEquals(true, candiDao.updateRemarkCandidateDoNotHaveEitherPhoneEmailCv());
	}

	@Test
	public void testSearch() throws Exception {
		List<Candidate> list = candiDao.search(0, 3);
		assertEquals(true, list != null && !list.isEmpty());
	}
}
