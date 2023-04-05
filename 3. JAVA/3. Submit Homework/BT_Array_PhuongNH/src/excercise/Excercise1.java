package excercise;

import java.util.Iterator;

public class Excercise1 {
	public static void main(String[] args) {
		
		int[] arr = new int[100];
 		
		for(int i = 0; i <= 99; i++) {
			arr[i] = i + 1;
		}
		
		//Câu 1
		System.out.printf("Tổng phần tử đầu tiên và cuối cùng: %d + %d = %d\n\n", arr[0], arr[99], (arr[0] + arr[99]));
		
		//Câu 2
		System.out.println("Số trong mảng chia hết cho cả 3 và 10 là: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 3 == 0 && arr[i] % 10 == 0) {
				System.out.println(arr[i]);
			}
		}
		
		//Câu 3
		System.out.println("Các số nguyên tố trong mảng là: ");	
		for (int j = 0; j < arr.length; j++) {
			int count = 0;
			if ( j > 1) {
				for (int i = j / 2; i > 1; i--) {
					if (j % i == 0) {
						count++;
					}
					if(count == 1) {
						break;
					}
				}
				if (count == 0) {
					System.out.println(j);
				}
			}
		}
		
		//Câu 4
		System.out.println("Tổng 100 phần tử là: ");
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		
		//Câu 5
		int[] arrcopy = new int[10];
		System.arraycopy(arr, 10, arrcopy, 0, 10);
		
		System.out.println("Mảng copy: ");
		for (int i = 0; i < arrcopy.length; i++) {
			System.out.print(arrcopy[i] + " ");
		}
	}
}
