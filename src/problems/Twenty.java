package problems;

import resources.ArbitraryNum;

/**
 * Project Euler Problem 20 http://projecteuler.net/problem=20
 * 
 * n! means n*(n-1)* ...*3*2*1
 * 
 * For example, 10! = 10*9*...*3*2*1 = 3628800, and the sum of the digits in the
 * number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @author Leo Rausch
 * 
 */
public class Twenty {

	public static ArbitraryNum solveFactorials(int number) {

		ArbitraryNum map = new ArbitraryNum("1");

		for (int i = 2; i <= number; i++) {
			map = resources.ArbitraryNum.multiplyMap(map, i);
		}
		return map;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int factorial = 100;

		long summation = solveFactorials(factorial).summationOfDigits();

		System.out.println("The sum of the digits of " + factorial + "! is "
				+ summation);

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");
	}
}
