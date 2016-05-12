package com.rausch.euler.problems.twentyone;

import java.util.HashMap;
import java.util.Map;

import com.rausch.euler.resources.Utilities;

/**
 * Project Euler Problem 21.
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a b, then a and
 * b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author Leo Rausch
 * 
 */
public class TwentyOne {

	/**
	 * This method finds the sum of amicable numbers under a limit.
	 * 
	 * @param limit
	 *            The largest amicable number.
	 * @return The sum of the amicable numbers under the limit.
	 */
	public static long sumOfAmicableNumbers(int limit) {

		int result = 0;

		/**
		 * Create a map where the key is the number and the value is the sum of
		 * its factors.
		 */
		Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
		for (int i = 0; i <= limit; i++) {
			long sum = Utilities.getSummationOfList(Utilities.findFactors(i));
			sums.put(i, (int) sum);
		}

		/**
		 * Now find out which ones are amicable and add them to the sum if they
		 * are.
		 */
		for (int a : sums.keySet()) {
			if (sums.containsKey(a)) {

				int sumA = sums.get(a);
				int b = sumA;

				if (sums.containsKey(b)) {

					int sumB = sums.get(b);

					if (sumB == a && a != b) {
						result += a;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(sumOfAmicableNumbers(10000));
	}
}
