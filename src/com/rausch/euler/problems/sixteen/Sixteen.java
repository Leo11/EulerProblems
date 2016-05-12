package com.rausch.euler.problems.sixteen;

import com.rausch.euler.resources.ArbitraryNum;

/**
 * Project Euler Problem 16 http://projecteuler.net/problem=16
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author Leo Rausch
 * 
 */
public class Sixteen {

	/**
	 * This method does some funky manipulation of numbers to express values
	 * greater than what can fit in doubles and ints and such. This method will
	 * return a map in which each key in the map represents the value at that
	 * decimal place. This method is specifically created to represent values
	 * raised to very large powers.
	 * 
	 * Ex.) 1,1; 2,3; = 13
	 * 
	 * @param power
	 *            The power to raise the value to.
	 * @param base
	 *            The base that will be raised to a certain power.
	 * @return A map containing all the values that would be at each decimal
	 *         place of a number.
	 */
	public static ArbitraryNum getMapOfNumber(int power, int base) {

		/**
		 * Map of ints, first int is the decimal place of the number, second int
		 * is the value of that decimal place int. Ex.) 1,1; 2,3; = 13
		 */
		ArbitraryNum num = new ArbitraryNum("2");

		for (int i = 2; i <= power; i++) {
			num = com.rausch.euler.resources.ArbitraryNum.multiply(num, base);
		}
		return num;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int power = 1000;
		int base = 2;

		ArbitraryNum num = getMapOfNumber(power, base);

		System.out.println(num.summationOfDigits());

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");
	}
}
