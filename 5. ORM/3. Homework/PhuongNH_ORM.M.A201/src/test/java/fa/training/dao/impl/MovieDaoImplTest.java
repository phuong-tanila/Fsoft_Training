package fa.training.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import fa.training.entities.Movie;


public class MovieDaoImplTest {
	public MovieDaoImpl movieImpl;
	
	@Before
	public void srtUp() throws Exception {
		movieImpl = new MovieDaoImpl();
	}
	
	@Test
	public void testInsert() throws Exception {
		movieImpl = new MovieDaoImpl();
		Movie movie = new Movie();
		movie.setMovieId("1");
		movie.setActor("Actor1");
		movie.setContent("Action");
		movie.setDirector("Director1");
		movie.setDuration(120.00);
		movie.setFromDate(LocalDate.of(2021, 11, 16));
		movie.setToDate(LocalDate.of(2022, 01, 01));
		movie.setMovieProductionCompany("CNN");
		movie.setVersion("V.01");
		movie.setMovieNameEng("Warrior");
		movie.setMovieNameVn("Chiến Binh");
		movie.setLargeImage("warrior.png");
		movie.setSmallImage("small_warrior.png");
		boolean actual = movieImpl.insert(movie);
		assertTrue(actual);
	}
	
	@Test
	public void testInsert2() throws Exception {
		movieImpl = new MovieDaoImpl();
		Movie movie = new Movie();
		movie.setMovieId("2");
		movie.setActor("Actor2");
		movie.setContent("Comedy");
		movie.setDirector("Director2");
		movie.setDuration(125.00);
		movie.setFromDate(LocalDate.of(2021, 8, 25));
		movie.setToDate(LocalDate.of(2022, 01, 01));
		movie.setMovieProductionCompany("CNN");
		movie.setVersion("V.01");
		movie.setMovieNameEng("Comedy King");
		movie.setMovieNameVn("Vua Hài Kịch");
		movie.setLargeImage("comedy.png");
		movie.setSmallImage("small_comedy");
		boolean actual = movieImpl.insert(movie);
		assertTrue(actual);
	}
	
	@Test
	public void testUpdate() throws Exception {
		movieImpl = new MovieDaoImpl();
		Movie movie = new Movie();
		movie.setMovieId("1");
		movie.setActor("Jason Statham");
		assertEquals(true, movieImpl.update(movie));
	}
	
	@Test
	public void testDelete() throws Exception {
		movieImpl = new MovieDaoImpl();
		Movie movie = new Movie();
		movie.setMovieId("2");
	}
	
	@Test
	public void testGetAll() throws Exception {
		movieImpl = new MovieDaoImpl();
		Movie movie = new Movie();
		movie.setMovieId("1");
		assertEquals(true, (movieImpl.getByPk(movie) != null));
	}
}
