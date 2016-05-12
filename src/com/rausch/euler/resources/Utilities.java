package com.rausch.euler.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

		if (number == 1) {
			return false;
		} else if (number == 2) {
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
	 * This method will determine if a given string is a palindrome.
	 * 
	 * @param word
	 *            The word that you want to test for palindromeness.
	 * @return If the word is a palindrome.
	 */
	public static Boolean isPalindrome(String word) {

		boolean isPally = true;
		char[] temp = word.toCharArray();

		if (temp.length == 0) {
			isPally = false;
		} else {
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

	public static long getSummationOfSet(Set<Long> set) {
		long summation = 0;
		for (long i : set) {
			summation += i;
		}
		return summation;
	}

	/**
	 * This method will tell you if a string is pandigital to specific set of
	 * numbers.
	 * 
	 * @param pandigitalValues
	 *            The values that the set must be pandigital for, Ex.) "12345".
	 * @param tentativePandigital
	 *            The string that you are checking for pandigitalness.
	 * @return Whether or not the given string is pandigital to the set of
	 *         letters.
	 */
	public static boolean isPandigital(String pandigitalValues,
			String tentativePandigital) {

		char[] valueArray = pandigitalValues.toCharArray();
		char[] tentativeArray = tentativePandigital.toCharArray();

		Arrays.sort(valueArray);
		Arrays.sort(tentativeArray);

		return Arrays.equals(valueArray, tentativeArray);
	}
}
