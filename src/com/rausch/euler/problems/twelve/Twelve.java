package com.rausch.euler.problems.twelve;

import com.rausch.euler.resources.Utilities;

/**
 * Project Euler Problem 12 http://projecteuler.net/problem=12
 * 
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * 
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first
 * ten terms would be:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * Let us list the factors of the first seven triangle numbers:
 * 
 * 1: 1
 * 
 * 3: 1,3
 * 
 * 6: 1,2,3,6
 * 
 * 10: 1,2,5,10
 * 
 * 15: 1,3,5,15
 * 
 * 21: 1,3,7,21
 * 
 * 28:1,2,4,7,14,28
 * 
 * We can see that 28 is the first triangle number to have over five divisors.
 * 
 * What is the value of the first triangle number to have over five hundred
 * divisors?
 * 
 * @author Leo Rausch
 * 
 */
public class Twelve {

	/**
	 * This method will find the first triangle number that has the number of
	 * divisors desired.
	 * 
	 * @param numberOfDivisors
	 *            The number of divisors the triangle number must have.
	 * @return The first triangle number which has a given amount of divisors.
	 */
	public static int getFirstTriangleNumberWithNthDivisors(int numberOfDivisors) {
		int triangleNumber = 0;
		int count = 0;
		while (!(Utilities.findNumberOfFactors(triangleNumber) > numberOfDivisors)) {
			count++;
			triangleNumber += count;
		}
		return triangleNumber;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int numberOfDivisors = 500;

		System.out.println("The first triangle number with " + numberOfDivisors
				+ " divisors is "
				+ getFirstTriangleNumberWithNthDivisors(numberOfDivisors));

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");

	}
}
