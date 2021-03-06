package com.rausch.euler.resources;

import java.util.HashMap;
import java.util.Map;

/**
 * This class aids in doing math functions on large numbers. For instance,
 * numbers that would not usually fit into a int or long.
 * 
 * The basis of this class is the idea of storing variables as maps where the
 * key is the decimal place of the number stored in the value. For example the
 * number 12 would be stored as 1=2; 2=1.
 * 
 * @author Leo Rausch
 * 
 */
public class ArbitraryNum {

	private Map<Integer, Integer> values;

	/**
	 * Basic constructor for creating a blank number.
	 */
	public ArbitraryNum() {
		super();
		this.values = new HashMap<Integer, Integer>();
	}

	/**
	 * Constructor for turning an existing string into a ArbitraryNum.
	 * 
	 * @param value
	 *            The String value that you want to make an ArbitraryNum out of.
	 */
	public ArbitraryNum(String value) {
		super();
		ArbitraryNum temp = convertNumberString(value);
		this.values = temp.values;
	}

	/**
	 * Construct an arbitrary num out of an existing ArbitraryNum.
	 * 
	 * @param num
	 *            The existing arbitrary num that you want to copy.
	 */
	public ArbitraryNum(ArbitraryNum num) {
		super();
		Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>(num.values);
		this.values = tempMap;
	}

	/**
	 * Add two ArbitraryNums together.
	 * 
	 * @param numOne
	 *            ArbitraryNum containing the first number.
	 * @param numTwo
	 *            ArbitraryNum containing the second number.
	 * @return a third ArbitraryNum containing the two input ArbitraryNums added
	 *         together.
	 */
	public static ArbitraryNum add(ArbitraryNum numOne, ArbitraryNum numTwo) {
		ArbitraryNum numThree = new ArbitraryNum();
		int size = numOne.values.size();
		if (numTwo.values.size() > size) {
			size = numTwo.values.size();
		}

		for (int i = 1; i <= size; i++) {
			int one = 0, two = 0, three = 0;

			if (numOne.values.containsKey(i)) {
				one = numOne.values.get(i);
			}
			if (numTwo.values.containsKey(i)) {
				two = numTwo.values.get(i);
			}
			if (numThree.values.containsKey(i)) {
				three = numThree.values.get(i);
			}
			numThree.values.put(i, one + two + three);
			fixMap(numThree);
		}
		return numThree;
	}

	/**
	 * Add two numbers together. This will add the given num to the existing
	 * value of the ArbitraryNum. This is not a utility function.
	 * 
	 * @param num
	 *            The ArbitraryNum that you would like to add to the existing
	 *            ArbitraryNum.
	 * @return a third map containing the two input maps added together.
	 */
	public void add(ArbitraryNum num) {
		ArbitraryNum numThree = new ArbitraryNum();
		int size = values.size();
		if (num.values.size() > size) {
			size = num.values.size();
		}

		for (int i = 1; i <= size; i++) {
			int one = 0, two = 0, three = 0;

			if (values.containsKey(i)) {
				one = values.get(i);
			}
			if (num.values.containsKey(i)) {
				two = num.values.get(i);
			}
			if (numThree.values.containsKey(i)) {
				three = numThree.values.get(i);
			}
			numThree.values.put(i, one + two + three);
			fixMap(numThree);
		}
		values = numThree.values;
	}

	/**
	 * Multiple an ArbitraryNum by a number. This class is only useful is the
	 * value of the multiplyer will fit into an integer.
	 * 
	 * @param num
	 *            The ArbitraryNum you would like to multiply by something.
	 * @param multiplyer
	 *            The value you want to multiply by.
	 * @return A new ArbitraryNum containing the value of a the old map
	 *         multiplied by a given multiplier.
	 */
	public static ArbitraryNum multiply(ArbitraryNum num, int multiplyer) {

		for (int j = 1; j <= num.values.keySet().size(); j++) {
			num.values.put(j, num.values.get(j) * multiplyer);
		}
		num = fixMap(num);
		return num;
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
	 * @param num
	 *            The map that you would like to fix up.
	 * @return A gorgeous map with single digits in all indexes.
	 */
	private static ArbitraryNum fixMap(ArbitraryNum num) {

		for (int k = 1; k <= num.values.keySet().size(); k++) {

			int temp = num.values.get(k);
			if (temp > 9) {
				int remainder = temp % 10;
				int temp2 = (temp - (temp % 10)) / 10;
				num.values.put(k, remainder);

				if (num.values.keySet().contains(k + 1)) {
					int temp3 = num.values.get(k + 1);
					num.values.put(k + 1, temp2 + temp3);
				} else {
					num.values.put(k + 1, temp2);
				}
			}
		}
		return num;
	}

	/**
	 * The following method will take a string such as "1234" and convert it
	 * into a ArbitraryNum to be used in the ArbitraryNum functions. For
	 * instance "1234" will become {1=4,2=3,3=2,4=1}
	 * 
	 * @param number
	 *            The string representation of a number.
	 * @return The ArbitraryNum representation of the inputed number.
	 */
	public static ArbitraryNum convertNumberString(String number) {
		ArbitraryNum numberMap = new ArbitraryNum();

		char[] individualNumbers = number.toCharArray();

		int count = 1;
		for (int i = individualNumbers.length; i > 0; i--) {
			numberMap.values.put(count, (int) individualNumbers[i - 1] - 48);
			count++;
		}
		return numberMap;
	}

	/**
	 * This method will sum the digits the ArbitraryNum.
	 * 
	 * @return The summation of the digits of the ArbitraryNum.
	 */
	public long summationOfDigits() {
		long summation = 0;

		for (Integer i : values.keySet()) {
			summation += values.get(i);
		}
		return summation;
	}

	/**
	 * This method will give the length of the ArbiraryNum.
	 * 
	 * @return The length of the ArbitraryNum.
	 */
	public int length() {
		return values.size();
	}

	/**
	 * Does Eclipse generated object checking. If both of the object are
	 * ArbitraryNums then it does a String comparison on the toString of the
	 * ArbitraryNum.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArbitraryNum other = (ArbitraryNum) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.toString().equals(other.values.toString()))
			return false;
		return true;
	}

	/**
	 * Prints the ArbitraryNum in a readable string format.
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = values.size(); i > 0; i--) {
			buffer.append(values.get(i));
		}
		return buffer.toString();
	}
}
