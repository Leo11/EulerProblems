package com.rausch.euler.problems;

import com.rausch.euler.resources.Utilities;

/**
 * Project Euler Problem 41 http://projecteuler.net/problem=41
 * 
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 * 
 * @author Leo Rausch
 * 
 */
public class FourtyOne {

	public static Long largestPandigitalPrime() {
		Long max = new Long("987654321");
		Long largestPandigitalPrime = new Long(0);

		StringBuffer current = new StringBuffer();
		for (Long i = (long) 0; i < max; i++) {
			if (current.length() < i.toString().length()) {
				current.append(i.toString().length());
			}
			if (Utilities.isPandigital(current.toString(), i.toString())
					&& Utilities.isPrime(i) && i >= largestPandigitalPrime) {
				largestPandigitalPrime = i;
				System.out.println(i);
			}
		}
		return largestPandigitalPrime;
	}

	public static void main(String[] args) {
		System.out.println(largestPandigitalPrime());
	}
}
