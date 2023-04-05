package fa.training.problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
	private FizzBuzz fizzbuzz;

	@BeforeEach
	public void setUp() {
		fizzbuzz = new FizzBuzz();
	}
	
	@Test
	public void test_Fizz() {
		String result = fizzbuzz.fizzBuzz(6);
		Assertions.assertEquals(result, "Fizz");
	}
	
	@Test
	public void test_Buzz() {
		String result = fizzbuzz.fizzBuzz(10);
		Assertions.assertEquals(result, "Buzz");
	}
	
	@Test
	public void test_FizzBuzz() {
		String result = fizzbuzz.fizzBuzz(15);
		Assertions.assertEquals(result, "FizzBuzz");
	}
	
	@Test
	public void test_InputValue() {
		String result = fizzbuzz.fizzBuzz(2);
		Assertions.assertEquals(result, "2");
	}
}
	