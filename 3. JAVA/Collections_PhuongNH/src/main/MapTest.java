package main;

import java.util.*;

public class MapTest {
	public static void main(String args[]) {
		HashMap<Integer, String> m1 = new HashMap<Integer, String>();

		// Câu 1
		m1.put(1, "Phương");
		m1.put(2, "Tâm");
		m1.put(3, "Thanh");

		for (Map.Entry<Integer, String> o : m1.entrySet()) {
			System.out.println(o.getKey() + "-" + o.getValue());
		}

		// Câu 2
		System.out.println("\nNumber of key-value in HashMap: " + m1.size());

		// Câu 3
		HashMap<Integer, String> m2 = new HashMap<Integer, String>();
		m2.put(4, "Bình");
		m2.put(5, "An");
		m2.put(6, "Cường");

		m2.putAll(m1);
		System.out.println("\nElements in second map: ");
		for (Map.Entry<Integer, String> o : m2.entrySet()) {
			System.out.println(o.getKey() + "-" + o.getValue());
		}

		// Câu 4
		m2.clear();
		System.out.println("\nElements in second map after clear: " + m2);

		// Câu 5
		if (m1.isEmpty()) {
			System.err.println("\nNothing in First Map");
		} else {
			System.out.println("\nNumber of element in first map: " + m1.size());
		}

		// Câu 6
		Map<Integer, String> map_clone = new HashMap<Integer, String>();
		map_clone = (HashMap) m1.clone();
		System.out.println("\nElements in cloned map: ");
		for (Map.Entry<Integer, String> o : map_clone.entrySet()) {
			System.out.println(o.getKey() + "-" + o.getValue());
		}

		// Câu 7 - check key
		if (m1.containsKey(3)) {
			System.out.println("\n" + m1.get(3) + " is in first map");
		} else {
			System.out.println("\nNot in the first map");
		}

		// Câu 8 - check value
		if (m1.containsValue("Thanh")) {
			System.out.println("\nIn fisrt map");
		} else {
			System.out.println("\nNot in the first map");
		}

		// Câu 9
		Set set = m1.entrySet();
		System.out.println("\nElements in set:");
		for (Object o : set) {
			System.out.println(o);
		}

		// Câu 10
		String value = (String) m1.get(3);
		System.out.println("\nValue for key 3 is: " + value);

		// Câu 11
		Set keyset = m1.keySet();
		System.out.println("\nKey set values are: " + keyset);
		
		// Câu 12
		System.out.println("\nThe values contained in first map: "+ m1.values());
	}
}
