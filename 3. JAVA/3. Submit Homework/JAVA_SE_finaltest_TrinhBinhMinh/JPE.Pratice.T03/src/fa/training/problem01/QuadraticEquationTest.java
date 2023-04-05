package fa.training.problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuadraticEquationTest {
	private QuadraticEquation q;
	
	@BeforeEach
	public void setup() {
		q = new QuadraticEquation();
	}
	@Test
	public void testcase1() {
		int rs1 = q.NumberOfRootQuadraticEquation(0, 0, 2);
		Assertions.assertEquals(rs1, 0);
	}
	
	@Test
	public void testcase2() {
		int rs2 = q.NumberOfRootQuadraticEquation(0, 0, 0);
		Assertions.assertEquals(rs2, 3);
	}
	@Test
	public void testcase3() {
		int rs3 = q.NumberOfRootQuadraticEquation(0, 4, 2);
		Assertions.assertEquals(rs3, 1);
	}
	@Test
	public void testcas4() {
		int rs4 = q.NumberOfRootQuadraticEquation(2, 4, 2);
		Assertions.assertEquals(rs4, 1);
	}
	@Test
	public void testcas5() {
		int rs5 = q.NumberOfRootQuadraticEquation(3, 8, 3);
		Assertions.assertEquals(rs5, 2);
	}
	@Test
	public void testcas6() {
//		int rs6 = q.NumberOfRootQuadraticEquation(2, 3, 4);
		Assertions.assertEquals(q.NumberOfRootQuadraticEquation(2, 3, 4), 0);
	}

}
