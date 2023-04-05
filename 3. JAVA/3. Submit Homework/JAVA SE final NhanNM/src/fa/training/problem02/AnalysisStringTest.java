package fa.training.problem02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AnalysisStringTest {
    private AnalysisString analysisString;
    @BeforeEach
    public void setup() {
        analysisString = new AnalysisString();
    }
    @Test
    public void test01() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(8);
        String rs = analysisString.sort(list);
        Assertions.assertEquals(rs,"[1, 3, 5, 8, 6, 2]" );
    }

    @Test
    public void test02() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(9);
        list.add(7);
        list.add(1);
        list.add(8);
        String rs = analysisString.sort(list);
        Assertions.assertEquals(rs,"[1, 3, 5, 7, 9, 8]" );
    }

    @Test
    public void test03() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(6);
        list.add(1);
        list.add(9);
        String rs = analysisString.sort(list);
        Assertions.assertEquals(rs,"[1, 9, 8, 6, 4, 2]" );
    }

    @Test
    public void test04() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(9);
        String rs = analysisString.sort(list);
        Assertions.assertEquals(rs,"[1, 3, 5, 9, 4, 2]" );
    }

    @Test
    public void test05() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(20);
        list.add(100);
        String rs = analysisString.sort(list);
        Assertions.assertEquals(rs,"[100, 20, 8, 6, 4, 2]" );
    }
}
