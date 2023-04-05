package fa.training.dao;

import java.util.ArrayList;

public interface DaoInterface<T> {
	public Boolean insert(T t);

	public Boolean update(T t);

	public Boolean delete(int id);

	public ArrayList<T> getAll();

	public T getById(int id);

}
