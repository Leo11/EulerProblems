package problems;

import java.util.ArrayList;
import java.util.List;
import resources.Rotation;
import resources.Utilities;

/**
 * Project Euler Problem 35 http://projecteuler.net/problem=35
 * 
 * The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
 * 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 * 
 * @author Leo Rausch
 * 
 */
public class ThirtyFive {

	/**
	 * This method will count the number of circular primes below a limit. Ex.)
	 * The number, 197, is called a circular prime because all rotations of the
	 * digits: 197, 971, and 719, are themselves prime.
	 * 
	 * @param limit
	 *            The largest number to count up to.
	 * @return The number of circular primes below the limit.
	 */
	public static int countCirculerPrimesBelowN(int limit) {

		int count = 0;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 2; i < limit; i++) {

			boolean circular = true;

			for (int n : Rotation.rotations(i)) {
				if (!Utilities.isPrime((n))) {
					circular = false;
					break;
				}
			}
			if (circular) {
				list.add(i);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countCirculerPrimesBelowN(1000000));
	}
}
