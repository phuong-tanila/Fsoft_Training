package fa.training.problem01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuadraticEquationTest {
    private QuadraticEquation quadraticEquation;
    @BeforeEach
    public void setUp() {
        quadraticEquation = new QuadraticEquation();
    }
    @Test
    public void textCace1() {
        int rs = quadraticEquation.numberOfRootOfQuadraticEquation(0, 0, 2);
        Assertions.assertEquals(rs, 0 );
    }

    @Test
    public void textCace2() {
        int rs = quadraticEquation.numberOfRootOfQuadraticEquation(0, 0, 0);
        Assertions.assertEquals(rs, 3 );
    }

    @Test
    public void textCace3() {
        int rs = quadraticEquation.numberOfRootOfQuadraticEquation(0, 4, 2);
        Assertions.assertEquals(rs, 1 );
    }
    @Test
    public void textCace4() {
        int rs = quadraticEquation.numberOfRootOfQuadraticEquation(2, 4, 2);
        Assertions.assertEquals(rs, 1 );
    }

    @Test
    public void textCace5() {
        int rs = quadraticEquation.numberOfRootOfQuadraticEquation(3, 8, 3);
        Assertions.assertEquals(rs, 2 );
    }

    @Test
    public void textCace6() {
        int rs = quadraticEquation.numberOfRootOfQuadraticEquation(2, 3, 4);
        Assertions.assertEquals(rs, 0 );
    }
}
