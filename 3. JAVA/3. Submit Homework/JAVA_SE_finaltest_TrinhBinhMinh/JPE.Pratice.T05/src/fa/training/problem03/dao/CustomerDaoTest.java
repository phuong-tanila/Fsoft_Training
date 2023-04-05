package fa.training.problem03.dao;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fa.training.problem03.Customer;

class CustomerDaoTest {
	private CustomerDao customerDao;
	private Customer customer;

	@BeforeEach
	public void setUpClass() {
		customerDao = new CustomerDao();
		customer = new Customer();
	}

	@Test
	public void testSave1() throws SQLException {
		Customer cus = new Customer();
		cus.setId(1001);
		cus.setFullName("Nguyen Van A");
		cus.setAddress("District 1");
		cus.setPhone("090123456");
		cus.setAge(20);
		String rs = customerDao.save(cus);
		Assertions.assertEquals(rs, "Success");
	}

	@Test
	public void testSave2() throws SQLException {
		Customer cus = new Customer();
		cus.setId(1002);
		cus.setFullName("Nguyen Van B");
		cus.setAddress("District 2");
		cus.setPhone("0707333666");
		cus.setAge(30);
		String rs = customerDao.save(cus);
		Assertions.assertEquals(rs, "Success");
	}

	@Test
	public void testSave3() throws SQLException {
		Customer cus = new Customer();
		cus.setId(1003);
		cus.setFullName("Nguyen Van C");
		cus.setAddress("District 3");
		cus.setPhone("0505444555");
		cus.setAge(25);
		String rs = customerDao.save(cus);
		Assertions.assertEquals(rs, "Success");
	}

	@Test
	public void testSave4() throws SQLException {
		Customer cus = new Customer();
		cus.setId(1004);
		cus.setFullName("Nguyen Van D");
		cus.setAddress("District 4");
		cus.setPhone("060622333");
		cus.setAge(33);
		String rs = customerDao.save(cus);
		Assertions.assertEquals(rs, "Success");
	}

	@Test
	public void testSave5() throws SQLException {
		Customer cus = new Customer();
		cus.setId(1005);
		cus.setFullName("Nguyen Van E");
		cus.setAddress("District 1");
		cus.setPhone("0101444666");
		cus.setAge(42);
		String rs = customerDao.save(cus);
		Assertions.assertEquals(rs, "Success");
	}

	@Test
	public void testUpdate() throws SQLException {
		String rs = customerDao.update();
		Assertions.assertEquals(rs, "Success");
	}
}
