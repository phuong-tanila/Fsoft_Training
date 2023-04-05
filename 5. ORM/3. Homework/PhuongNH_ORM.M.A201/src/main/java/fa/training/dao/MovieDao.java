package fa.training.dao;

import java.util.ArrayList;

public interface MovieDao<Obj> {
	public boolean insert(Obj obj);
	public boolean update(Obj obj);
	public boolean delete(Obj obj);
	public ArrayList<Obj> getAllCustomer();
	public Obj getByPk(Obj obj);
}
