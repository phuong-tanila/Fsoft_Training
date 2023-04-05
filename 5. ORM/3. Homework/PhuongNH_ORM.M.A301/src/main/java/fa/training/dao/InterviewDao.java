package fa.training.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import fa.training.entities.Interview;


public interface InterviewDao {
	public Boolean insert(Interview interview) throws HibernateException;

	public Boolean update(Interview interview) throws HibernateException;

	public Boolean delete(int id) throws HibernateException;

	public ArrayList<Interview> getAll() throws HibernateException;

	public Interview getById(int id) throws HibernateException;
}
