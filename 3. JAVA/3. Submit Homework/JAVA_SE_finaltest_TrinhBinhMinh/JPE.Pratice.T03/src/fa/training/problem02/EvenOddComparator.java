package fa.training.problem02;
import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer>
{
    final int BEFORE = -1;
    final int EQUAL = 0;
    final int AFTER = 1;

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 2 != 0 && o2 % 2 == 0) {
            return BEFORE;
        } else if (o1 % 2 == 0 && o2 % 2 != 0) {
            return AFTER;
        } else if (o1 % 2 != 0 && o2 % 2 != 0) {
            return o1.compareTo(o2);
        } else if (o1 % 2 == 0 && o2 % 2 == 0) {
            return o2.compareTo(o1);
        }
        return EQUAL;
    }
}
