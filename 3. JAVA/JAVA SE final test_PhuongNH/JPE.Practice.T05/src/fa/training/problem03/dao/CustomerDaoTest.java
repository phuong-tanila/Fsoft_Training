package fa.training.problem03.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fa.training.problem03.models.Customer;

public class CustomerDaoTest {
	private CustomerDao cDao;
	private Customer c;

	@BeforeEach
	public void setUpClass() {
		cDao = new CustomerDao();
		c = new Customer();
	}

	@Test
	public void testSave1() throws SQLException {
		Customer c = new Customer();
		c.setId(1001);
		c.setFullName("Nguyen Van A");
		c.setAddress("District 1");
		c.setPhone("090123456");
		c.setAge(20);
		String actual = cDao.save(c);
		Assertions.assertEquals(actual, "Success");
	}

	@Test
	public void testSave2() throws SQLException {
		Customer c = new Customer();
		c.setId(1002);
		c.setFullName("Nguyen Van B");
		c.setAddress("District 2");
		c.setPhone("0707333666");
		c.setAge(30);
		String actual = cDao.save(c);
		Assertions.assertEquals(actual, "Success");
	}

	@Test
	public void testSave3() throws SQLException {
		Customer c = new Customer();
		c.setId(1003);
		c.setFullName("Nguyen Van C");
		c.setAddress("District 3");
		c.setPhone("0505444555");
		c.setAge(25);
		String actual = cDao.save(c);
		Assertions.assertEquals(actual, "Success");
	}

	@Test
	public void testSave4() throws SQLException {
		Customer c = new Customer();
		c.setId(1004);
		c.setFullName("Nguyen Van D");
		c.setAddress("District 4");
		c.setPhone("060622333");
		c.setAge(33);
		String actual = cDao.save(c);
		Assertions.assertEquals(actual, "Success");
	}

	@Test
	public void testSave5() throws SQLException {
		Customer c = new Customer();
		c.setId(1005);
		c.setFullName("Nguyen Van E");
		c.setAddress("District 1");
		c.setPhone("0101444666");
		c.setAge(42);
		String actual = cDao.save(c);
		Assertions.assertEquals(actual, "Success");
	}

	@Test
	public void testUpdate() throws SQLException {
		Customer c = cDao.find(1003);
		String actual = cDao.update(c);
		Assertions.assertEquals(actual, "Success");
	}
}
