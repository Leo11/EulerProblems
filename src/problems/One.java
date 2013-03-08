package problems;

/**
 * Project Euler Problem 1 http://projecteuler.net/problem=1
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author Leo Rausch
 * 
 */
public class One {

	/**
	 * Finds the sum of all the multiples of the first number or the second
	 * number below the limit.
	 * 
	 * @param first
	 *            The first number.
	 * @param second
	 *            The second number.
	 * @param limit
	 *            The max number, i.e when the program will stop.
	 * @return The sum of all the multiples of the first number or the second
	 *         number below the limit.
	 */
	public static int sum(int first, int second, int limit) {

		int sum = 0;

		/**
		 * For each number below the limit, if the number divides equally into
		 * the first or second number then it is a multiple and add it to the
		 * sum.
		 */
		for (int i = 0; i < limit; i++) {
			if (i % first == 0 || i % second == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String args[]) {

		long startTime = System.currentTimeMillis();

		int firstNumber = 3;
		int secondNumber = 5;
		int limit = 1000;

		System.out.println("The sum of the multiples of " + firstNumber
				+ " or " + secondNumber + " below " + limit + " = "
				+ sum(firstNumber, secondNumber, limit));

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");

	}

}
