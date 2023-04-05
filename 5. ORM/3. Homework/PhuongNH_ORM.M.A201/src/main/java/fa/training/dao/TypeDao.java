package fa.training.dao;

import java.util.ArrayList;

public interface TypeDao <Obj>{
	public boolean insert(Obj obj);
	public boolean update(Obj obj);
	public boolean delete(Obj obj);
	public ArrayList<Obj> getAll();
	public Obj getByPk(Obj obj);
}