package excercise;

import java.util.Scanner;

public class Excercise3 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lần muốn dịch trái: ");
		int k = sc.nextInt();
		
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				int tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
			}
		}
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		
	}
}
