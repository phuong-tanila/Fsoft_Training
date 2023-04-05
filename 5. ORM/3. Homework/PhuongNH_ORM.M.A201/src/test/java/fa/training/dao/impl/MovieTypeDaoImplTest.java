package fa.training.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fa.training.entities.MovieType;
import fa.training.entities.Type;


public class MovieTypeDaoImplTest {
	public MovieTypeDaoImpl movieTypeImpl;
	
	private Type type = new Type();
	
	@Before 
	public void setUp() throws Exception{
		movieTypeImpl = new MovieTypeDaoImpl();
	}
	
	@Test 
	public void testInsert() throws Exception {
		movieTypeImpl = new MovieTypeDaoImpl();
		MovieType movieType = new MovieType();
		
		movieType.setMyDescription("Good");
		boolean actual = movieTypeImpl.insert(movieType);
		assertTrue(actual);
	}
	
	public void testInsert2() throws Exception {
		movieTypeImpl = new MovieTypeDaoImpl();
		MovieType movieType = new MovieType();
		
		movieType.setMyDescription("Great");
		boolean actual = movieTypeImpl.insert(movieType);
		assertTrue(actual);
	}
	
	@Test
	public void testUpdate() throws Exception {
		movieTypeImpl = new MovieTypeDaoImpl();
		MovieType movieType = new MovieType();
		
		movieType.setType(type);
		movieType.setMyDescription("Nice");
		assertEquals(true, movieTypeImpl.update(movieType));
	}
	
	@Test
	public void testDelete() throws Exception {
		movieTypeImpl = new MovieTypeDaoImpl();
		MovieType movieType = new MovieType();
		movieType.setType(type);
	}
	
	@Test
	public void testGetAll() throws Exception {
		movieTypeImpl = new MovieTypeDaoImpl();
		assertEquals(true, (movieTypeImpl.getAllCustomer() != null));
	}
	
	@Test
	public void testGetById() throws Exception {
		movieTypeImpl = new  MovieTypeDaoImpl();
		MovieType movieType = new MovieType();
		movieType.setType(type);
		assertEquals(true, (movieTypeImpl.getByPk(movieType) != null));
	}
}
