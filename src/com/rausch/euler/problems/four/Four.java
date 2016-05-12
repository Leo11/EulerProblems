package com.rausch.euler.problems.four;

import com.rausch.euler.resources.Utilities;

/**
 * Project Euler Problem 4 http://projecteuler.net/problem=4
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Leo Rausch
 * 
 */
public class Four {

	/**
	 * This method finds the largest palindrome that can be created with the
	 * product of 2 certain digit length number. Ex.) If digits = 3 then the
	 * largest palindrome you can create with the product of 2, 3 digit numbers
	 * is 906609.
	 * 
	 * @param digits
	 *            The number of digits you want the numbers to be.
	 * @return The largest number palindrome possible.
	 */
	public static String findLargestPalindrome(int digits) {

		/*
		 * This gives us the base number to start with and the number to endwith
		 * Ex. 3 digits = 100 so start off with 100-999
		 */
		int start = (int) Math.pow(10, digits - 1);
		int end = (int) Math.pow(10, digits);

		String largestPalindrome = "0";

		for (int i = start; i < end; i++) {
			for (int j = start; j < end; j++) {

				/*
				 * First get the string representation so we can see if its a
				 * palindrome
				 */
				String newPalindrome = "" + (i * j);
				if (Utilities.isPalindrome(newPalindrome)) {
					if (Integer.parseInt(newPalindrome) > Integer
							.parseInt(largestPalindrome)) {
						largestPalindrome = newPalindrome;
					}
				}
			}
		}

		return largestPalindrome;
	}

	public static void main(String args[]) {

		long startTime = System.currentTimeMillis();

		int digits = 3;

		System.out
				.println("The largest palindrome made from the product of two-"
						+ digits + " digit numbers is "
						+ findLargestPalindrome(digits));

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");

	}
}
