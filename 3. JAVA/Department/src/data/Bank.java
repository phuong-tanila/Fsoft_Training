package data;

public abstract class Bank {
	public abstract float getRateOfInterest();
	
	public static void main(String[] args) {
		Bank sbi = new SBI();
		Bank icici = new ICICI();
		
		float a = sbi.getRateOfInterest();
		float b = icici.getRateOfInterest();
		
		System.out.println(a);
		System.out.println(b);
		
		
	}
}
