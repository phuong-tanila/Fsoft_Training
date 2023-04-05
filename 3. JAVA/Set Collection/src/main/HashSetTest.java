package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add(null);
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("three"); //duplicate
		set.add("four");
		set.add("five");
		
		Iterator<String> i = set.iterator(); //Iterator này được coi như là 1 cái phễu
											 //Có thể đổ cả ArrayList, LinkedList, Set,...
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		for (String o : set) {
			System.out.printf(o + " ");
		}
	}
}
