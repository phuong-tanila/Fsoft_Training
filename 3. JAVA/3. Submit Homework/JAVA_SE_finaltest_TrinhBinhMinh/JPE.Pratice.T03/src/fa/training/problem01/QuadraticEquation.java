package fa.training.problem01;

public class QuadraticEquation {

	public static int NumberOfRootQuadraticEquation(int a, int b, int c) {
		double x, x1, x2;

		int delta = (b * b) - 4 * a * c;

		if (a == 0 && b == 0 && c == 0) {
			System.out.println("Số a, b, c không hợp lệ");
			return 3;
		} else if (a == 0) {
			if (b == 0) {
				System.out.println("Phương trình vô nghiệm (a = 0, b = 0)");
			} else {
				System.out.println("Phương trình có một nghiệm: x = " + (-c / b));
				return 1;
			}
			return 0;
		} else if (delta > 0) {
			x1 = (-b + Math.sqrt(delta) / (2 * a));
			x2 = (-b - Math.sqrt(delta) / (2 * a));
			System.out.println("Phương trình có nghiệm phân biệt x1: " + x1 + ", x2: " + x2);
			return 2;
		} else if (delta == 0) {
			x = (-b) / (2 * a);
			System.out.println("Phương trình có nghiệm kép x: " + x);
			return 1;
		}
		System.out.println("Phương trình vô nghiệm (Delta < 0)");
		return 0;
	}
}
