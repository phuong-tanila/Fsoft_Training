package main;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExample {
	  public static void main(String args[]) {
	    HashMap<Integer, String> map = new HashMap<Integer, String>();// Creating
	                                                                  // HashMap
	    map.put(1, "Mango"); // Put elements in Map
	    map.put(2, "Apple");
	    map.put(3, "Banana");
	    map.put(1, "Grapes"); // trying duplicate key

	    System.out.println("Iterating Hashmap...");
	    
	    for (Entry<Integer, String> m : map.entrySet()) {
	      System.out.println(m.getKey() + " " + m.getValue());
	    }
	  }
	}