package problems;

/**
 * Project Euler Problem 6 http://projecteuler.net/problem=6
 * 
 * See website for description
 * 
 * @author Leo Rausch
 * 
 */

public class Six {

	/**
	 * This method will compute the sum of squares from numberOne to numberTwo.
	 * 
	 * @param numberOne
	 *            The lower bound of the numbers you want to square.
	 * @param numberTwo
	 *            The upper bound of the numbers you want to square.
	 * @return The sum of the squares from numberOne to numberTwo.
	 */
	public static int sumOfSquares(int numberOne, int numberTwo) {

		int answer = 0;
		for (int i = numberOne; i <= numberTwo; i++) {
			answer += i * i;
		}
		return answer;
	}

	/**
	 * This method will compute the square of the sums of the number from
	 * numberOne to numberTwo.
	 * 
	 * @param numberOne
	 *            The lower bound of the numbers you want to square.
	 * @param numberTwo
	 *            The upper bound of the numbers you want to square.
	 * @return The square of the sums from numberOne to numberTwo.
	 */
	public static int squareOfSum(int numberOne, int numberTwo) {

		int answer = 0;
		for (int i = numberOne; i <= numberTwo; i++) {
			answer += i;
		}
		return answer * answer;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int numberOne = 1;
		int numberTwo = 100;
		int difference = squareOfSum(numberOne, numberTwo)
				- sumOfSquares(numberOne, numberTwo);

		System.out
				.println("The difference between the sum of the squares of the numbers from "
						+ numberOne
						+ " to number "
						+ numberTwo
						+ " = "
						+ difference);

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");

	}
}
