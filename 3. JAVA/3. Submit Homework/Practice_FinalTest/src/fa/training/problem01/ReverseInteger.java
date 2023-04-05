package fa.training.problem01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseInteger {
	public int reverse(Integer number) {
		String convert = number.toString();
		String[] arr = convert.split("");

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < arr.length; i++) {
			list.add((String) arr[i]);
		}
		Collections.reverse(list);

		StringBuilder result = new StringBuilder();
		list.forEach(x -> result.append(x));

		return Integer.valueOf(result.toString());
	}

	public static void main(String[] args) {
		ReverseInteger rv = new ReverseInteger();
		System.out.println(rv.reverse(987654321));
	}
}
