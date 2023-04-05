package fa.training.problem02;

import java.util.ArrayList;
import java.util.Collections;

public class SpecialSort {
	public String sort(ArrayList<Integer> arr) {
		Collections.sort(arr, new AnalysisString());
		return arr.toString();
	}
}
