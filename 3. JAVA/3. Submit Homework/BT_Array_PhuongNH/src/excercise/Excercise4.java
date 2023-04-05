package excercise;

public class Excercise4 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
		System.out.println("Câu a:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 3) continue;
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		System.out.println("Câu b: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			break;
		}
	}
}
