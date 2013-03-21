package problems;

import java.util.ArrayList;
import java.util.List;

import resources.Utilities;

/**
 * Project Euler Problem 23 http://projecteuler.net/problem=23
 * 
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 * 
 * @author Leo Rausch
 * 
 */
public class TwentyThree {

	/*
	 * Greatest number that cannot be expressed as the sum of two abundant
	 * numbers is less than this number.
	 */
	public static int limit = 28123;

	/**
	 * This method will find abundant numbers below a limit. An abundant number
	 * is a number where the sum of its divisors is greater than the original
	 * number. Ex.) 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16.
	 * 
	 * @param limit The upper limit for finding abundant numbers.
	 * @return A list containing abundant numbers below a certain limit. 
	 */
	public static List<Long> abundantNumbers(int limit) {
		List<Long> abundants = new ArrayList<Long>();
		for (long i = 0; i <= limit; i++) {
			if (Utilities.getSummationOfList(Utilities.findFactors(i)) > i) {
				abundants.add(i);
			}
		}
		return abundants;
	}

	
	public static List<Long> findNonAbundantsSums() {
		List<Long> nonAbundants = new ArrayList<Long>();
		List<Long> abundants = abundantNumbers(limit);

		for (Long i = (long) 0; i < limit; i++) {
			boolean abundantSum = false;
			for (Long j = (long) 0; j < abundants.size(); j++) {
				for (Long k = (long) 0; k < abundants.size(); k++) {
					if ((j + k == i)) {

						abundantSum = true;
					}
				}
			}
			if (!abundantSum) {
				nonAbundants.add(i);
			}
		}
		return nonAbundants;
	}

	public static void main(String[] args) {
		findNonAbundantsSums();
	}
}
