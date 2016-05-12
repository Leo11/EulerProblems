package com.rausch.euler.problems;

import java.util.ArrayList;

import com.rausch.euler.resources.Utilities;

/**
 * Project Euler Problem 3 http://projecteuler.net/problem=3
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Leo Rausch
 * 
 */
public class Three {

	/**
	 * This method will give you a list of the prime factors of a number.
	 * 
	 * @param number
	 *            The number you wish to see the prime factors of.
	 * @return A list of the prime factors of a number.
	 */
	public static ArrayList<Long> primeFactors(Long number) {

		ArrayList<Long> factors = Utilities.findFactors(number,
				(long) Math.sqrt(number));
		ArrayList<Long> answer = new ArrayList<Long>(0);

		for (Long f : factors) {
			if (Utilities.isPrime(f)) {
				answer.add(f);
			}
		}
		return answer;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		Long number = new Long("600851475143");

		System.out.println("Prime Factors of " + number + " are "
				+ primeFactors(number));

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");
	}
}
