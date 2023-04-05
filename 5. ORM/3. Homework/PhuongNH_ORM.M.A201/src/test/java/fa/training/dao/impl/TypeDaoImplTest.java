package fa.training.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import fa.training.entities.Type;


public class TypeDaoImplTest {
	public TypeDaoImpl typeImpl;

	@Before
	public void setUp() throws Exception {
		typeImpl = new TypeDaoImpl();
	}

	@Test
	public void testInsert() throws Exception {
		typeImpl = new TypeDaoImpl();
		Type type = new Type();

		type.setTypeName("Horror");
		type.setTypeDescription("5 stars");
		boolean actual = typeImpl.insert(type);
		assertTrue(actual);
	}

	@Test
	public void testInsert2() throws Exception {
		typeImpl = new TypeDaoImpl();
		Type type = new Type();

		type.setTypeName("Action");
		type.setTypeDescription("4.5 stars");
		boolean actual = typeImpl.insert(type);
		assertTrue(actual);
	}

	@Test
	public void testInsert3() throws Exception {
		typeImpl = new TypeDaoImpl();
		Type type = new Type();

		type.setTypeName("Action");
		type.setTypeDescription("5 stars");
		boolean actual = typeImpl.insert(type);
		assertTrue(actual);
	}

	@Test
	public void testUpdate() throws Exception {
		typeImpl = new TypeDaoImpl();
		Type type = new Type();
		type.setTypeId(1);
		type.setTypeName("Love");
		assertEquals(true, typeImpl.update(type));
	}

	@Test
	public void testDelete() throws Exception {
		typeImpl = new TypeDaoImpl();
		Type type = new Type();
		type.setTypeId(3);
	}

	@Test
	public void testGetAll() throws Exception {
		typeImpl = new TypeDaoImpl();
		assertEquals(true, (typeImpl.getAll() != null));
	}

	@Test
	public void testGetById() throws Exception {
		typeImpl = new TypeDaoImpl();
		Type type = new Type();
		type.setTypeId(2);
		assertEquals(true, (typeImpl.getByPk(type) != null));
	}
}
