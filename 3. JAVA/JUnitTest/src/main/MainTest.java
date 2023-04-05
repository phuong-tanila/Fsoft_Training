package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculator.Fibonacci;

public class MainTest {
	private Fibonacci fibonacci;

	@BeforeEach
	public void setUp() {
		fibonacci = new Fibonacci();
	}

//	@Test
//	public void testFibonacciGivenWrongExpected() {
//		Assertions.assertEquals(3, fibonacci.getFactorial(3));
//	}

//	@Test
//	public void testFibonacciGivenrightExpected() {
//		Assertions.assertEquals(6, fibonacci.getFactorial(3));
//	}

	@Test()
	public void testFibonaccilGivenWrongArgumentThrowsException() {
		Assertions.assertEquals(IllegalArgumentException.class,fibonacci.getFactorial(-5));
	}
}
