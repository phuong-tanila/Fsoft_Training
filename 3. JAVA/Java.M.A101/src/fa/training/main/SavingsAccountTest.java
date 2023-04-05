package fa.training.main;

import fa.training.entities.SavingsAccount;

public class SavingsAccountTest {
	public static void main(String[] args) {
		
		SavingsAccount saver1 = new SavingsAccount(0.04, 2000);
		SavingsAccount saver2 = new SavingsAccount(0.04, 3000);
		
		System.out.printf("_____Lãi suất hàng năm là 4%%_____\n\n");
		
		System.out.println("\t*** SAVER1 ***");
		System.out.printf("Số tiền gửi tiết kiệm: %4.2f", saver1.getSavBal());
		System.out.printf("\nTiền lãi hàng tháng: %4.2f", saver1.calculateMonthlyInterest());
		saver1.setSavBal(saver1.calculateMonthlyInterest() + saver1.getSavBal());
		System.out.printf("\nSố dư: %4.2f\n\n", saver1.getSavBal());
		
		System.out.println("\t*** SAVER2 ***");
		System.out.printf("Số tiền gửi tiết kiệm: %4.2f", saver2.getSavBal());
		System.out.printf("\nTiền lãi hàng tháng: %4.2f", saver2.calculateMonthlyInterest());
		saver2.setSavBal(saver2.calculateMonthlyInterest() + saver2.getSavBal());
		System.out.printf("\nSố dư: %4.2f", saver2.getSavBal());
		
		saver1.setIntRate(0.05);
		saver2.setIntRate(0.05);
		System.out.printf("\n\n-------------------------------------------\n");
		System.out.printf("\n_____Cập nhật lãi suất hàng năm lên 5%%_____\n\n");
		
		System.out.println("\t*** SAVER1 ***");
		System.out.printf("Tiền lãi hàng tháng: %4.2f", saver1.calculateMonthlyInterest());
		saver1.setSavBal(saver1.calculateMonthlyInterest() + saver1.getSavBal());
		System.out.printf("\nSố dư tháng kế của saver1: %4.2f\n\n", saver1.getSavBal());
		
		System.out.println("\t*** SAVER2 ***");
		System.out.printf("Tiền lãi hàng tháng của saver2: %4.2f", saver2.calculateMonthlyInterest());
		saver2.setSavBal(saver2.calculateMonthlyInterest() + saver2.getSavBal());
		System.out.printf("\nSố dư tháng kế của saver2: %4.2f", saver2.getSavBal());
		
		System.out.printf("\n\n---------- B Y E ----------");
	}
}
