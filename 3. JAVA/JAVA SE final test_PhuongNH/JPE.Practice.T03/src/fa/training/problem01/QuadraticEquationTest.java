package fa.training.problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuadraticEquationTest {
	
	private QuadraticEquation quad;

	@BeforeEach
	public void setup() {
		quad = new QuadraticEquation();
	}
	
	@Test
	public void testCase1() {
		int actual = quad.numberOfRootQuadraticEquation(0, 0, 2);
		Assertions.assertEquals(actual, 0);
	}

	@Test
	public void testCase2() {
		int actual = quad.numberOfRootQuadraticEquation(0, 0, 0);
		Assertions.assertEquals(actual, 3);
	}

	@Test
	public void testCase3() {
		int actual = quad.numberOfRootQuadraticEquation(0, 4, 2);
		Assertions.assertEquals(actual, 1);
	}

	@Test
	public void testCase4() {
		int actual = quad.numberOfRootQuadraticEquation(2, 4, 2);
		Assertions.assertEquals(actual, 1);
	}

	@Test
	public void testCase5() {
		int actual = quad.numberOfRootQuadraticEquation(3, 8, 3);
		Assertions.assertEquals(actual, 2);
	}

	@Test
	public void testCase6() {
		int actual = quad.numberOfRootQuadraticEquation(2, 3, 4);
		Assertions.assertEquals(actual, 0);
	}
}
