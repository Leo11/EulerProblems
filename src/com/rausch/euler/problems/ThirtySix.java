package com.rausch.euler.problems;

import com.rausch.euler.resources.Utilities;

/**
 * Project Euler Problem 36 http://projecteuler.net/problem=36
 * 
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * 
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 * 
 * @author Leo Rausch
 * 
 */
public class ThirtySix {

	/**
	 * Finds the sum of all numbers, less than the limit which are palindromic
	 * in base 10 and base 2.
	 * 
	 * @param limit
	 *            The max number that you want to search for dual base
	 *            palidromicness.
	 * @return The sum of all numbers, less than the limit which are plaindromic
	 *         in base 10 and base 2.
	 */
	public static long findPalindromicDualBase(int limit) {

		long sum = 0;
		for (int i = 0; i < limit; i++) {
			if (Utilities.isPalindrome(i + "")
					&& Utilities.isPalindrome(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(findPalindromicDualBase(100000));
	}
}
