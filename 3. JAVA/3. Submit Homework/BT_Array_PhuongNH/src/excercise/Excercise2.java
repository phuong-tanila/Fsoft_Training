package excercise;

public class Excercise2 {
	public static void main(String[] args) {
		String[] arr = {"Java", "C", "Python", "Go", "Go", "C", "C", "Java"};
		
		int j = 0, c = 0, p = 0, g = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == "Java") {
				j++;
			}
			if(arr[i] == "C") {
				c++;
			}
			if(arr[i] == "Python") {
				p++;
			}
			if(arr[i] == "Go") {
				g++;
			}
		}
		System.out.println("Java|" + j + " C|" + c + " Python|" + p +  " Go|" + g);
	}
}
