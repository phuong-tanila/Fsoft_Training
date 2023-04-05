package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise {
//	public static void main(String[] args) {
//		double side;
//		Scanner scnr = new Scanner(System.in);
//		System.out.println("Square Processing");
//		System.out.print("Enter Side: ");
//
//		try {
//			side = scnr.nextDouble();
//			System.out.println("\nSquare Characteristics");
//			System.out.printf("Side: %.2f\n", side);
//			System.out.printf("Perimeter: %.2f\n", side * 4);
//		} catch (InputMismatchException ex) {
//			System.out.println(ex.getMessage());
//
//		}

//	public static void main(String[] args) {
//		int x = 0, z = 5;
//		int j = 3;
//		int[] ar = new int[j];
//		try {
//			int y = z / x;
//			ar[j] = 5;
//
//			BufferedReader input = new BufferedReader(new FileReader("a.txt"));
//		} catch (Exception ex) {
//			ex.getStackTrace();
//			// Exception Method Call Stack Trace
//		}
//	}

	public static void main(String[] args) {

		try {
			int a[] = new int[5];
			a[5] = 30 / 0;
			System.out.println(a[10]);

		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception occurs");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds Exception occurs");
		} catch (Exception e) {
			System.out.println("Parent Exception occurs");
		}
		System.out.println("rest of the code");
	}
}
