package main;

import java.util.*;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		// Câu 1
		list.add("Phương");
		list.add("Thanh");
		list.add("Huyền");
		list.add("Đào");
		list.add("Đức");
		System.out.println("Element of arraylist: " + list);

		System.out.println();
		// Câu 2
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		// Câu 3
		list.add(0, "Linh");
		System.out.println("\nElement of arraylist after add: " + list);

		// Câu 4
		System.out.println("\n1st element: " + list.get(0));
		System.out.println("3rd element: " + list.get(2));

		// Câu 5
		list.set(0, "Linh Tiêu");
		list.set(1, "Phương Nguyễn");
		System.out.println("\nElement of arraylist after update: " + list);

		// Câu 6
		list.remove(2);
		System.out.println("\nElement of arraylist after remove 3rd element: " + list);

		// Câu 7
		if (list.contains("Đào")) {
			System.out.println("\nFound!");
		} else {
			System.out.println("\nNot found!");
		}

		// Câu 8
		Collections.sort(list);
		System.out.println("\nElement of arraylist after sort: " + list);

		// Câu 9
		List<String> list1 = new ArrayList<String>();
		list1.add("An");
		list1.add("Bình");
		list1.add("Cường");
		List<String> list2 = new ArrayList<String>();
		list1.add("Ân");
		list1.add("Bính");
		list1.add("Cương");
		Collections.copy(list1, list2);
		System.out.println("\nElement of arraylist after copy: " + list1);

		// Câu 10
		Collections.shuffle(list);
		System.out.println("\nElement of arraylist after shuffling: " + list);

		// Câu 11
		Collections.reverse(list);
		System.out.println("\nElement of arraylist after reversing: " + list);

		// Câu 12
		List<String> sub_List = list.subList(0, 4);
		System.out.println("\nList of first four elements: " + sub_List);

		// Câu 13
		System.out.println("\nComparing two arraylist");
		for (String e : list1) {
			System.out.println(list2.contains(e) ? "Equal" : "Not equal");
		}

		// Câu 14
		Collections.swap(list, 0, 2);
		System.out.print("\nArray list after swap:");
		for (String b : list) {
			System.out.print(b + " ");
		}

		// Câu 15
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(list);
		arr.addAll(list2);
		System.out.print("\n\nNew arraylist after join list and list2: ");
		for (String s : arr) {
			System.out.print(s + " ");
		}

		// Câu 16
		ArrayList<String> list_clone = (ArrayList) list.clone();
		System.out.println("\n\nCloned array list: " + list_clone);

		// Câu 17
		list.removeAll(list);
		System.out.println("\nElement of arraylist after remove all: " + list);  
		
		// Câu 18
		if(list.isEmpty()) {
			System.out.println("\nNothing in arraylist!");
		}else {
			System.out.println("\nNumber of element in arraylist: " + list.size());
		}
		
		// Câu 19
		System.out.print("\nArraylist after trimming the capacity: ");
        ((ArrayList<String>) list2).trimToSize();
        System.out.print(list2);
        
        // Câu 20
        ((ArrayList<String>) list1).ensureCapacity(6);
        list1.add("Minh");
        list1.add("Hên");
        list1.add("Lâm");
        System.out.print("\n\nArraylist after increase the size: " + list1);
        
        // Câu 21
        list1.set(1, "Bằng");
        System.out.print("\n\nArraylist after replace 2rd element: " + list1);
        
        // Câu 22
        System.out.print("\n\nPrint all the elements of a ArrayList: ");
        for (int j = 0; j < list1.size(); j++) {
			System.out.print(list1.get(j) + " ");
		}
	}
}