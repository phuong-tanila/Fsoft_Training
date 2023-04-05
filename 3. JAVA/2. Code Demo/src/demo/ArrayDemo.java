package demo;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayDemo {
	public int a = 6;
	public int b = 7;
	
	public int sum() {
		return a + b;
	}

	public void mul(int a, int b) {
		System.out.println("Tích a * b = " + (a * b));
	}


	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		for(int i = a.length - 1; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
	
	
		for (int i : a) {
		System.out.print(i + " ");
		}
	
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("phuong");
		arr.add("tam");
		arr.add("sinh");
		
		for (String s : arr) {
			System.out.println(s);
		}
	}
}
	
	
