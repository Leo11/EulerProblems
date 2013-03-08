package problems;

import resources.Utilities;

/**
 * Project Euler Problem 10 http://projecteuler.net/problem=10
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author Leo Rausch
 * 
 */
public class Ten {

	/**
	 * Attempted to use a seive method to find primes. Does not work yet.
	 * 
	 * @param limit
	 * @return
	 */
	public static long sumOfPrimesI(int limit) {

		long crossLimit = (long) Math.sqrt(limit);

		boolean[] seive = new boolean[limit];

		for (int n = 6; n < limit; n += 2) {
			seive[n] = true;
		}
		for (int n = 5; n <= crossLimit; n += 2) {
			if (!seive[n]) {
				for (int m = n * n; n <= limit; n += 2) {
					seive[m] = true;
				}
			}
		}
		long sum = 0;
		for (int n = 4; n < limit; n++) {
			if (!seive[n]) {
				sum += n;
			}
		}
		return sum;
	}

	/**
	 * This method will find the sum of primes below a certain number.
	 * 
	 * @param number
	 *            The max number the prime can be.
	 * @return The sum of the primes below the given number
	 */
	public static long sumOfPrimes(int number) {

		// Start the sum at 2 so that we can skip all even numbers and not worry
		// about missing 2.
		long sum = 2;
		for (int i = 3; i <= number; i += 2) {
			if (Utilities.isPrime(i)) {
				sum += i;
				System.out.println(i);
				System.out.println(sum);
			}
		}
		return sum;
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int number = 2000000;
		System.out.println("The sum of all the primes below " + number + " = "
				+ sumOfPrimes(number));

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to complete = " + (endTime - startTime)
				+ "ms");

	}

}
