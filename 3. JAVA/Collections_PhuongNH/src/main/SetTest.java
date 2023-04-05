package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		HashSet<String> s = new HashSet<String>();

		// Câu 1
		s.add("An");
		s.add("Bình");
		s.add("Cường");
		s.add("Hòa");
		s.add("Phúc");
		System.out.println("Hash Set: " + s);

		// Câu 2
		Iterator<String> i = s.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		// Câu 3
		System.out.println("Number of element in HashSet: " + s.size());

		// Câu 4
//		s.removeAll(s);
//		System.out.println("Number of element in HashSet after remove all: " + s.size());

		// Câu 5
		if (s.isEmpty()) {
			System.out.println("Nothing in HashSet");
		} else {
			System.out.println("Hash Set: " + s);
		}

		// Câu 6
		HashSet<String> s_clone = new HashSet<String>();
		s_clone = ((HashSet<String>) s.clone());
		System.out.println("Cloned Hash Set: " + s_clone);

		// Câu 7
		String[] arr = new String[s.size()];
		s.toArray(arr);

		System.out.print("Array: ");
		for (String o : arr) {
			System.out.print(o + " ");
		}

		System.out.println();
		// Câu 8
		Set<String> t = new TreeSet<String>(s);

		System.out.print("TreeSet: ");
		for (String x : t) {
			System.out.print(x + " ");
		}

		System.out.println();
		// Câu 9
		List<String> list = new ArrayList<String>(s);
		System.out.println("ArrayList: " + list);

		// Câu 10
		HashSet<String> s1 = new HashSet<String>();

		s1.add("An");
		s1.add("Bình");
		s1.add("Cường");
		s1.add("Hòa");
		s1.add("Phương");

		System.out.println("Hash Set: " + s1);

		System.out.println("\nComparing two hash set");
		for (String e : s) {
			System.out.println(s1.contains(e) ? "Equal" : "Not equal");
		}

		// Câu 11
		s.retainAll(s1);
		System.out.println("\nHashSet content:");
		System.out.println(s);

		// Câu 12
		s.clear();
		System.out.println("\nHashSet after clear: " + s);
	}
}
