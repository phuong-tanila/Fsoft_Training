package fa.training.entities;

public class SavingsAccount {
	private double intRate;
	private double savBal;
	
	public SavingsAccount() {
	}

	public SavingsAccount(double intRate, double savBal) {
		this.intRate = intRate;
		this.savBal = savBal;
	}

	public double getIntRate() {
		return intRate;
	}

	public void setIntRate(double intRate) {
		this.intRate = intRate;
	}

	public double getSavBal() {
		return savBal;
	}

	public void setSavBal(double savBal) {
		this.savBal = savBal;
	}
	
	public double calculateMonthlyInterest() {
		return savBal * (intRate / 12);
	}
	
}
