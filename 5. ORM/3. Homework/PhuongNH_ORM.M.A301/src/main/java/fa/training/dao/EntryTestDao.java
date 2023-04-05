package fa.training.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import fa.training.entities.EntryTest;


public interface EntryTestDao {
	public Boolean insert(EntryTest entryTest) throws HibernateException;

	public Boolean update(EntryTest entryTest) throws HibernateException;

	public Boolean delete(int id) throws HibernateException;

	public ArrayList<EntryTest> getAll() throws HibernateException;

	public EntryTest getById(int id) throws HibernateException;
}