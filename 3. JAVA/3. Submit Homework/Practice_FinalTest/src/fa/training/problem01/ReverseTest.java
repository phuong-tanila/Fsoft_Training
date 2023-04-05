package fa.training.problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseTest {
	ReverseInteger rv;
	
	@Test
	public void test_reverse() {
//		int result = reverse.reverse(123);
		Assertions.assertEquals(rv.reverse(321), 321);
	}
}
