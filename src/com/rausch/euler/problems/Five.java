package com.rausch.euler.problems;

/**
 * Project Euler Problem 5 http://projecteuler.net/problem=5
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * @author Leo Rausch
 * 
 */
public class Five {

	/**
	 * This method will find the smallest positive number that is evenly
	 * divisible by all of the numbers between the lowValue and highValue.
	 * 
	 * @param lowValue
	 *            The low range of values.
	 * @param highValue
	 *            The high range of values.
	 * @return The number that is evenly divisible by all of the numbers between
	 *         the lowValue and the highValue.
	 */
	public static int smallestEventlyDivisibleNumber(int lowValue, int highValue) {

		boolean possible = true;
		boolean running = true;
		int count = 0;

		while (running) {

			count++;
			possible = true;

			for (int i = lowValue; i <= highValue; i++) {
				if (count % i != 0) {
					possible = false;
				}
			}
			if (possible) {
				running = false;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int lowValue = 1;
		int highValue = 20;

		System.out
				.println("The smallest positive number that is evenly divisible by all of the numbers from "
						+ lowValue
						+ " to "
						+ highValue
						+ " = "
						+ smallestEventlyDivisibleNumber(lowValue, highValue));

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");

	}

}
