package fa.training.main;

import fa.training.dao.JobDaoImpl;
import fa.training.entities.Jobs;

public class Main {
	public static void main(String[] arg) {
		JobDaoImpl jobDaoImpl = new JobDaoImpl();
		
		Jobs job = new Jobs("J04", "Java Dev1", 1000.0d, 2000.0d);
		
		jobDaoImpl.update(job, 12);
	}
}
