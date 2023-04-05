package fa.training.problem01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CourseRegister {
	public static Map<String, Integer> countStudent(String filePath) throws FileNotFoundException, IOException {
		Map<String, Integer> result = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String row = null;
			String data[];
			int number;
			
			while ((row = reader.readLine()) != null) {

				number = 0;

				data = row.split("_");
				if (result.get(data[2]) != null) {
					number = result.get(data[2]);
				}

				result.put(data[2], ++number);
			}

		}
		return result;
	}

	public static void main(String[] args) {
		try {
			Map<String, Integer> result = countStudent(System.getProperty("user.dir") + "\\src\\fa\\training\\problem01\\course_register.txt");
			// System.out.println(System.getProperty("user.dir"));
			// The keySet() method is used to get a Set view of the keys contained in
			// this map.
			Set<String> keys = result.keySet();

			for (String key : keys) {
				System.out.println(String.format("%-10s%d", key, result.get(key)));
			}

			// The entrySet() method is used to get a Set view of the mappings
			// contained in this map.

//	      Set<Entry<String, Integer>> reEntry = result.entrySet();
//	      for (Entry<String, Integer> entry : reEntry) {
//	        System.out.println(
//	            String.format("%-10s%d", entry.getKey(), entry.getValue()));
//	      }

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
