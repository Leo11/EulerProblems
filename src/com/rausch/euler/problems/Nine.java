package com.rausch.euler.problems;

/**
 * Project Euler Problem 9 http://projecteuler.net/problem=9
 * 
 * A Pythagorean triplet is a set of three natural numbers, a b c, for which,
 * 
 * a^2 + b^2 = c^2 For example, 32 + 42 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 * 
 * @author Leo Rausch
 * 
 */
public class Nine {

	/**
	 * This method finds the product of Pythagorean Triplet of which a + b + c =
	 * n
	 * 
	 * @param number
	 * @return
	 */
	public static int pythagoreanTripletProduct(int number) {
		int value = 0;
		for (int a = 1; a <= number / 3; a++) {
			for (int b = 2; b <= number / 2; b++) {
				int c = number - a - b;
				if ((a * a) + (b * b) == (c * c)) {
					value = a * b * c;
				}
			}
		}
		return value;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int number = 1000;
		System.out.println("The Pythagorean triplet for which a + b + c = "
				+ number + " is " + pythagoreanTripletProduct(number));

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");

	}

}
