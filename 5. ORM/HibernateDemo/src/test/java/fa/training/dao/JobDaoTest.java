package fa.training.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fa.training.entities.Jobs;

public class JobDaoTest {
static JobDao jobDao;
    
    @Before
    public  void setUpBeforeClass() throws Exception {
        jobDao = new JobDaoImpl();
    }
    
    @Test
    public void testSave1() throws Exception {
        Jobs job = new Jobs("J01", "Java Dev1", 1000, 2000);
        assertEquals(true, jobDao.save(job));
    }
    @Test
    public void testSave2() throws Exception {
        Jobs job = new Jobs("J02", "Java Dev2", 1200, 2200);
        assertEquals(true, jobDao.save(job));
    }
}
