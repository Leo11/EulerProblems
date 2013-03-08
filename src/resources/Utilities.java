package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utilities {

	/**
	 * Find all the factors of a number.
	 * 
	 * @param number
	 *            The number you want to find the factors of
	 * @return A list containing all factors of a given number
	 */
	public static ArrayList<Long> findFactors(Long number) {
		ArrayList<Long> factors = new ArrayList<Long>(0);
		Long counter = new Long(1);

		while (counter < number) {
			if (number % counter == 0) {
				factors.add(counter);
			}
			counter += 1;
		}
		return factors;
	}

	/**
	 * Find all the factors of a number.
	 * 
	 * @param number
	 *            The number you want to find the factors of
	 * @return A list containing all factors of a given number
	 */
	public static ArrayList<Long> findFactors(int number) {
		return findFactors((long) number);
	}

	public static long findNumberOfFactors(long number) {
		long root = (long) Math.sqrt(number);
		return (findFactors(number, root).size()) * 2;
	}

	/**
	 * Find all the factors of a number. This is useful for finding the factors
	 * of a number under a certain max. Such as if you were finding the factors
	 * of a number only up to the square root of the number.
	 * 
	 * @param number
	 *            The number you want to find the factors of
	 * @param maxNumber
	 *            The max number that you want the factors to be under.
	 * @return A list containing all factors of a given number
	 */
	public static ArrayList<Long> findFactors(Long number, Long maxNumber) {
		ArrayList<Long> factors = new ArrayList<Long>(0);
		Long counter = new Long(1);

		while (counter < maxNumber) {
			if (number % counter == 0) {
				factors.add(counter);
			}
			counter += 1;
		}
		return factors;
	}

	/**
	 * Determine if a given number is prime, this is a new, more efficient
	 * algorithm.
	 * 
	 * @param number
	 *            The number you wish to check prime status.
	 * @return if the number is prime.
	 */
	public static boolean isPrime(Long number) {

		if (number == 2) {
			return true;
		} else if (number % 2 == 0) {
			return false;
		} else {
			for (int i = 3; i < number; i += 2) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Determine if a given number is prime, this is a new, more efficient
	 * algorithm.
	 * 
	 * @param number
	 *            The number you wish to check prime status.
	 * @return if the number is prime.
	 */
	public static boolean isPrime(int number) {
		return isPrime((long) number);
	}

	/**
	 * This method will determine if a given string is a pallindrome.
	 * 
	 * @param word
	 *            The word that you want to test for pallindromeness.
	 * @return If the word is a pallindrome.
	 */
	public static Boolean isPalindrome(String word) {
		boolean isPally = true;

		char[] temp = word.toCharArray();

		if (temp.length % 2 == 0) {
			for (int i = 0; i < temp.length / 2; i++) {
				if (!(temp[i] == temp[temp.length - i - 1])) {
					isPally = false;
				}
			}
		}
		return isPally;
	}

	/**
	 * This method takes in a map and adds up all of the values inside of it.
	 * 
	 * @param map
	 *            The map which you want to add all the values inside it.
	 * @return The summation of all the values inside of the given map.
	 */
	public static long getSummationOfMap(Map<Integer, Integer> map) {
		long summation = 0;

		for (Integer i : map.keySet()) {
			summation += map.get(i);
		}
		return summation;
	}

	public static long getSummationOfList(List<Long> list) {
		long summation = 0;
		for (long i : list) {
			summation += i;
		}
		return summation;
	}

	/**
	 * This method will do the following to a map of integers. Say you have a
	 * map of Integer, Integer where the first integer is the integer place
	 * value of the second Integer. For instance 1,1; 2,2 = 12. This can be
	 * useful for massive numbers such as 2^1000000. So what does this method
	 * do? Say you just multiplied the number 8586885848485834858 by 9. You can
	 * do this by multiplying each value in the map by 9. But then you get these
	 * pesky double or triple digit numbers in some of the map indexes. This is
	 * where this method comes in; it will go through and carry all the digits
	 * through the map and reform the map with a single digit in each index.
	 * 
	 * @param map
	 *            The map that you would like to fix up.
	 * @return A gorgeous map with single digits in all indexes.
	 */
	public static Map<Integer, Integer> fixMap(Map<Integer, Integer> map) {

		for (int k = 1; k <= map.keySet().size(); k++) {

			int temp = map.get(k);
			if (temp > 9) {
				int remainder = temp % 10;
				int temp2 = (temp - (temp % 10)) / 10;
				map.put(k, remainder);

				if (map.keySet().contains(k + 1)) {
					int temp3 = map.get(k + 1);
					map.put(k + 1, temp2 + temp3);
				} else {
					map.put(k + 1, temp2);
				}
			}
		}
		return map;
	}

}
