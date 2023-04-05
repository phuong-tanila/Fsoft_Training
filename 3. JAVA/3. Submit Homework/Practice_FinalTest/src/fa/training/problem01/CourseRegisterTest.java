package fa.training.problem01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CourseRegisterTest {
	
	private CourseRegister cou;
	
	@Test
	public void test_countStudent() throws FileNotFoundException, IOException {
		Map<String, Integer> result = cou.countStudent(System.getProperty("user.dir") + "\\src\\fa\\training\\problem01\\course_register.txt");
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result.get("Java"), 2);
		Assertions.assertEquals(result.get("C++"), 1);
		Assertions.assertEquals(result.get("FrontEnd"), 2);
		Assertions.assertEquals(result.get("NET"), 1);
		Assertions.assertEquals(result.size(), 4);
	}
}
