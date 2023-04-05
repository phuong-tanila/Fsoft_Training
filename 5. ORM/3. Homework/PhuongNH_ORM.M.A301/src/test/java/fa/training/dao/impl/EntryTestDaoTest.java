package fa.training.dao.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;

public class EntryTestDaoTest {
	private CandidateDaoImpl candiDao = new CandidateDaoImpl();
	private EntryTestDaoImpl entryDao = new EntryTestDaoImpl();

	@Before
	public void setUpBeforeClass() {
		candiDao = new CandidateDaoImpl();
		entryDao = new EntryTestDaoImpl();
		Candidate candidate = new Candidate("Ngoc Anh", LocalDate.of(2020, 11, 1), 0, LocalDate.of(2020, 12, 1),
				"0797575123", "NgocAnh@gmail.com", "Angluar", "Englich", 1, "Cv basic", 1, "Nice");
		candiDao.insert(candidate);

		EntryTest entryTest = new EntryTest("2020-11-20", LocalDate.of(2020, 11, 17), "Good job", new BigDecimal(2),
				"Good", new BigDecimal(2), "pass", "Good", "Angluar");
		Set<EntryTest> entryTestList = new HashSet<EntryTest>();
		entryTestList.add(entryTest);
		candidate.setEntryTest(entryTestList);
		entryTest.setCandidate(candidate);
		entryDao.insert(entryTest);
	}

	@Test
	public void testInsert() throws Exception {
		Candidate candidate = candiDao.getById(7);
		EntryTest entryTest = new EntryTest("Time1223", LocalDate.of(2020, 11, 1), "languageValuator",
				new BigDecimal(2), "technicalValuator", new BigDecimal(2), "pass", "remark001", "Angluar");
		Set<EntryTest> entryTestList = new HashSet<EntryTest>();
		entryTestList.add(entryTest);
		candidate.setEntryTest(entryTestList);
		entryTest.setCandidate(candidate);
		assertEquals(true, entryDao.insert(entryTest));
	}

	@Test
	public void testUpdate() throws Exception {
		EntryTest entryTest = entryDao.getById(15);
		entryTest.setEntryTestSkill("Java");
		assertEquals(true, entryDao.update(entryTest));
	}

	@Test
	public void testDelete() throws Exception {
		assertEquals(true, entryDao.delete(7));
	}

	@Test
	public void testGetAll() throws Exception {
		ArrayList<EntryTest> list = entryDao.getAll();
		assertEquals(true, list != null && !list.isEmpty());
	}

	@Test
	public void testGetById() throws Exception {
		assertEquals(true, entryDao.getById(7) != null);
	}
}
