package problems;

import resources.Utilities;

/**
 * Project Euler Problem 7 By http://projecteuler.net/problem=7
 * 
 * listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that
 * the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * @author Leo Rausch
 * 
 */
public class Seven {

	/**
	 * This method will tell you what the nthPrime number is.
	 * 
	 * @param number
	 *            The nth prime number you want to calculate.
	 * @return The nth prime number.
	 */
	public static int nthPrime(int number) {

		// number of primes we have found;
		int primeCounter = 0;

		// current integer we are checking for primality
		int counter = 0;
		while (primeCounter <= number) {
			counter++;
			if (Utilities.isPrime(counter)) {
				primeCounter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int nthPrime = 10001;
		System.out.println("The " + nthPrime + " prime number is "
				+ nthPrime(nthPrime));

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");

	}

}
