package demo;

public class CheckNum {
	
	public static void main(String[] args) {
		CheckNum c = new CheckNum();
	
		if(c.check(num) == 0) {
			System.out.println("Chia hết");
		}else {
			System.out.println("Không chia hết");
		}
	}
	
	
	public static int num = 30;
	
	public int check(int num) {
		if(num % 2 == 0 && num % 5 == 0) {
			return 0;
		}else {
			return 1;
		}
	}
}
