package cen4802;

public class Assignment2 {

	/**
	 * This method will run the code for determining the Fibonacci sequence and finding the
	 * number at the designated position based on the position originally set.
	 * 
	 * @author Joshua
	 * @param input is the variable sent by the main method to determine what
	 *              position in the Fibonacci sequence should be found and have that
	 *              number in that position returned.
	 * @return Will return either the input sent to the method if less than or equal
	 *         to 1, or continue running the Fibonacci sequence method until the
	 *         correct number using input is found.
	 * 
	 */
	public static int fibonacci(int input) {

		if (input <= 1) {
			return input;
		}

		return fibonacci(input - 1) + fibonacci(input - 2);

	}

	public static void main(String[] args) {
		int input = 10;
		System.out.println("The " + input + "th term of the Fibonacci sequence is " + fibonacci(input) + ".");

	}

}
