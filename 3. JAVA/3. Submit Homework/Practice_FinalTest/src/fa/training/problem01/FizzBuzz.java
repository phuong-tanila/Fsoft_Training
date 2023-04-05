package fa.training.problem01;

public class FizzBuzz {
	public String fizzBuzz(Integer inputValue) {
		if (inputValue % 3 == 0 && inputValue % 5 == 0) {
			return "FizzBuzz";
		} else if (inputValue % 5 == 0) {
			return "Buzz";
		} else if (inputValue % 3 == 0) {
			return "Fizz";
		} else {
			return inputValue.toString();
		}
	}
}
