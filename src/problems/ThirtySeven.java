package problems;

import resources.Utilities;

/**
 * Project Euler Problem http://projecteuler.net/problem=37 The number 3797 has
 * an interesting property. Being prime itself, it is possible to continuously
 * remove digits from left to right, and remain prime at each stage: 3797, 797,
 * 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 * @author Leo Rausch
 * 
 */
public class ThirtySeven {

	/**
	 * This method will remove the left most digit from an integer. For
	 * instance, if you have the number 1234. This method will return 234.
	 * 
	 * @param number
	 *            The number you wish to remove the left-most digit from.
	 * @return A number which consists of the original number with the left most
	 *         digit removed. Ex.) 1234 = 234;
	 */
	public static int removeLeftDigit(int number) {
		return (int) (number % Math.pow(10, (number + "").length() - 1));
	}

	/**
	 * This method will rmeove the right most digit from an integer. For
	 * instance, if you have the number 1234. This moethod will return 123.
	 * 
	 * @param number
	 *            The number you wish to remove the right-most digit from.
	 * @return A number which consists of the original number with the right
	 *         most digit removed. Ex.) 1234 = 123;
	 */
	public static int removeRightDigit(int number) {
		return (number - (number % 10)) / 10;
	}

	public static int findSumLeftRightTruncatablePrimes() {

		int count = 0;
		int sum = 0;
		int counter = 11;
		int left = counter;
		int right = counter;
		boolean prime = true;

		/*
		 * Only find the first 11 dual truncatable primes, this "magic number"
		 * is because of the given problem.
		 */
		while (count < 11) {

			left = counter;
			right = counter;
			prime = true;

			/*
			 * Figure out if the number is left prime truncatable.
			 */
			for (int i = (counter + "").length(); i > 0; i--) {

				if (!Utilities.isPrime(left)) {
					prime = false;
				} else {
					left = removeLeftDigit(left);
				}

				if (!Utilities.isPrime(right)) {
					prime = false;
				} else {
					right = removeRightDigit(right);
				}
			}
			if (prime) {
				sum += counter;
				count++;
			}

			/*
			 * Add 2 because an even number will not be prime.
			 */
			counter += 2;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(findSumLeftRightTruncatablePrimes());
	}
}
