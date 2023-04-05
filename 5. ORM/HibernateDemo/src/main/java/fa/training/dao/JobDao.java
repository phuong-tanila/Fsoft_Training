package fa.training.dao;

import fa.training.entities.Jobs;

public interface JobDao {
	public boolean save(Jobs job);
	
	public int update(Jobs job, double maxSalary);
}
