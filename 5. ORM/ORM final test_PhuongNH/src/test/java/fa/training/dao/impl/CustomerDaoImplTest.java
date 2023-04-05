package fa.training.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import fa.training.constants.CustomerType;
import fa.training.constants.Sex;
import fa.training.entities.Customer;

public class CustomerDaoImplTest {
	private CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

	@Before
	public void initialize() {
		customerDaoImpl = new CustomerDaoImpl();
		Customer customer;
		// mock Customer
		customer = new Customer();
		customer.setIdCardNumber("12345678");
		customer.setFullName("Hoai Phuong");
		customer.setEmail("phuongnh@gmail.com");
		customer.setPhoneNumber("0797575794");
		customer.setAddress("Ho Chi Minh");
		customer.setSex(Sex.MALE);
		customer.setBirthday("2001-05-11");
		customer.setType(CustomerType.SUPERVIP);
		customerDaoImpl.save(customer);
	}
	
	@Test
	public void save_success() {
		Customer customer = new Customer();
		customer = new Customer();
		customer.setIdCardNumber("12349999");
		customer.setFullName("Quoc Minh");
		customer.setEmail("minhquoc@gmail.com");
		customer.setPhoneNumber("0985551234");
		customer.setAddress("Da Nang");
		customer.setSex(Sex.MALE);
		customer.setBirthday("1998-12-10");
		customer.setType(CustomerType.VIP);
		boolean actual = customerDaoImpl.save(customer);
		assertTrue(actual);
	}

	@Test
	public void updateAddress() {
		int actual = customerDaoImpl.updateAddress(1, "Dong Nai Update");
		assertNotNull(actual);
	}
	
	@Test
	public void findCustomerById() {
		Customer actual = customerDaoImpl.findCustomerById(1);
		assertNotNull(actual);
	}
	
	@Test
	public void findListOfCustomerByType() {
		List<Customer> list = customerDaoImpl.listOfCustomerByType(CustomerType.SUPERVIP);
		assertNotNull(list);
	}
	
	@Test
	public void getTotalCustomerByBirthdayAndSex() {
		long list = customerDaoImpl.getTotalCustomerBySexAndBirthday();
		assertNotNull(list);
	}

}
