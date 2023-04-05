package fa.training.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import fa.training.entities.Candidate;


public interface CandidateDao {
	public Boolean insert(Candidate candidate) throws HibernateException;

	public Boolean update(Candidate candidate) throws HibernateException;

	public Boolean delete(Integer id) throws HibernateException;

	public ArrayList<Candidate> getAll() throws HibernateException;

	public Candidate getById(Integer candidateId) throws HibernateException;

	public List<Candidate> fillAllCandidateWithSkillLevel(String skillImport, Integer levelImport) throws HibernateException;

	public List<Candidate> fillAllCandidateWithSkillForeignLanguage(String skillImport,String foreignLanguageImport) throws HibernateException;

	public List<Object[]> fillAllCandidateWithSkillEntryTestResultDate(String skill, String result,LocalDate date) throws HibernateException;

	public List<Candidate> fillAllCandidateWithInterviewDate() throws HibernateException;

	public Boolean updateRemarkCandidateDoNotHaveEitherPhoneEmailCv() throws HibernateException;

	public List<Candidate> search(Integer pageNumber, Integer pageSize) throws HibernateException;
}
