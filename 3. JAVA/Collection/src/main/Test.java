package main;

public class Test{
	public static void main(String[] args) {
		One one = new One();
		Two two = (Two)one;
		System.out.println( two.getInt() );
	}
}