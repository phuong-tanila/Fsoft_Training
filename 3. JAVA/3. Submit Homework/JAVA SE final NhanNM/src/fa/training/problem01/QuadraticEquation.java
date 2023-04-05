package fa.training.problem01;

public class QuadraticEquation {
    public int numberOfRootOfQuadraticEquation(int a, int b, int c) {
        double delta = b * b - 4 * a * c;
        if (a == 0 & b == 0 & c == 0) {
            return 3;
        } else {
            if (a == 0 & b == 0 & c != 0) {
                return 0;
            } else {
                if (delta == 0 || a == 0) {
                    return 1;
                } else if (delta < 0) {
                    return 0;
                } else {
                    return 2;
                }
            }
        }
    }
}
