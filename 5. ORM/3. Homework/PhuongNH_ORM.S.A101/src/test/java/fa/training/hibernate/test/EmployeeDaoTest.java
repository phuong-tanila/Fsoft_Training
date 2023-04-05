package fa.training.hibernate.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fa.training.hibernate.dao.EmployeeDAO;
import fa.training.hibernate.dao.impl.EmployeeDaoImpl;
import fa.training.hibernate.model.Employee;

public class EmployeeDaoTest {

	static EmployeeDAO empDao;

	@Before
	public void setUpBeforeClass() throws Exception {
		empDao = new EmployeeDaoImpl();
	}
	
	@Test
	public void testSaveEmployee1() throws Exception {
		Employee emp = new Employee(1, "Lam", "Phương");
		assertEquals(true, empDao.save(emp));
	}

	@Test
	public void testSaveEmployee2() throws Exception {
		Employee emp = new Employee(2, "Nguyen", "Anh");
		assertEquals(true, empDao.save(emp));
	}
	
	@Test
	public void testFindEmployee() throws Exception{
		Employee emp = new Employee(1, "Lam", "Phuong");
		assertEquals(emp.toString(), empDao.findEmployeeById(1).toString());
	}
	
	@Test
	public void testUpdateFirstName() throws Exception{
		assertEquals(1, empDao.updateFisrtName(1, "Lam"));
	}
	
	@Test
	public void testDeleteEmployee() throws Exception{
		assertEquals(true, empDao.deleteEmployee(2));
	}
}
