package cen4802;

public class Assignment2 {

	public static int fibonacci(int input) {
		
		if (input <= 1) {
			return input;
		}
		
		return fibonacci(input-1) + fibonacci(input -2);

	}

	public static void main(String[] args) {
		int input = 10;
		System.out.println("The " + input + "th term of the Fibonacci sequence is " + fibonacci(input) + ".");

	}

}
