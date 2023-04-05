package fa.training.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;

import fa.training.constants.*;
import fa.training.entities.*;

public class RoomDaoImplTest {
	private CustomerDaoImpl customerDaoImpl;
	private RoomDaoImpl roomDaoImpl;
	private Customer customer;
	private Room room;
	private long time = new Date().getTime();

	@Before
	public void initialize() {
		customerDaoImpl = new CustomerDaoImpl();
		roomDaoImpl = new RoomDaoImpl();
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
		// mock Room
		room = new Room();
		room.setRoomCode("VIP.R." + time);
		room.setType(RoomType.SUITE);
		room.setPrice(2500.0);
		room.setServiceDescription("Wonderful");
		room.setCustomer(customer);
		roomDaoImpl.save(room);
	}

	@Test
	public void save_success() {
		Room room = new Room();
		room.setRoomCode("VIP.R." + time);
		room.setType(RoomType.DELUXE);
		room.setPrice(1500.0);
		room.setStartDate(LocalDate.of(2022, 12, 23));
		room.setServiceDescription("Great");
		room.setCustomer(customer);
		boolean actual = roomDaoImpl.save(room);
		assertTrue(actual);
		assertEquals(RoomType.DELUXE, room.getType());
	}

	@Test
	public void checkoutTest() {
		Room actual = roomDaoImpl.checkout(room.getId());
		assertNotNull(actual);
		assertEquals(LocalDate.now(), actual.getEndDate());
	}

	@Test
	public void delete_success() {
		boolean actual = roomDaoImpl.delete(room.getId());
		assertTrue(actual);
	}

}