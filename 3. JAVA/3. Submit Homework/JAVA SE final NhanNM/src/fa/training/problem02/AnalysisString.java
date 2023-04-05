package fa.training.problem02;

import java.util.ArrayList;
import java.util.Collections;

public class AnalysisString {
    public String sort(ArrayList arr) {

        Collections.sort(arr, new SpecialSort());
        return arr.toString();
    }
}
