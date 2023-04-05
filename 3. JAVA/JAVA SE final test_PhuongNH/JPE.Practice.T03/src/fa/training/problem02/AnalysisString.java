package fa.training.problem02;

import java.util.Comparator;

public class AnalysisString implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 % 2 != 0 && o2 % 2 == 0) {
			return -1;
		} else if (o1 % 2 == 0 && o2 % 2 != 0) {
			return 1;
		} else if (o1 % 2 != 0 && o2 % 2 != 0) {
			return o1.compareTo(o2);
		} else if (o1 % 2 == 0 && o2 % 2 == 0) {
			return o2.compareTo(o1);
		}
		return 0;
	}
}
