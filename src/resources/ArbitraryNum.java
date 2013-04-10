package resources;

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

	public ArbitraryNum(Map<Integer, Integer> values) {
		super();
		this.values = values;
	}

	public ArbitraryNum() {
		super();
		this.values = new HashMap<Integer, Integer>();
	}

	public ArbitraryNum(String value) {
		super();
		ArbitraryNum temp = convertNumberString(value);
		this.values = temp.values;
	}

	public ArbitraryNum(ArbitraryNum n) {
		super();
		this.values = n.values;
	}

	/**
	 * Add two numbers together.
	 * 
	 * @param mapOne
	 *            Map containing the first number.
	 * @param mapTwo
	 *            Map containing the second number.
	 * @return a third map containing the two input maps added together.
	 */
	public static ArbitraryNum addMaps(ArbitraryNum mapOne, ArbitraryNum mapTwo) {
		ArbitraryNum mapThree = new ArbitraryNum();
		int size = mapOne.values.size();
		if (mapTwo.values.size() > size) {
			size = mapTwo.values.size();
		}

		for (int i = 1; i <= size; i++) {
			int one = 0, two = 0, three = 0;

			if (mapOne.values.containsKey(i)) {
				one = mapOne.values.get(i);
			}
			if (mapTwo.values.containsKey(i)) {
				two = mapTwo.values.get(i);
			}
			if (mapThree.values.containsKey(i)) {
				three = mapThree.values.get(i);
			}
			mapThree.values.put(i, one + two + three);
			fixMap(mapThree);
		}
		return mapThree;
	}

	/**
	 * Add two numbers together.
	 * 
	 * @param mapOne
	 *            Map containing the first number.
	 * @param mapTwo
	 *            Map containing the second number.
	 * @return a third map containing the two input maps added together.
	 */
	public void add(ArbitraryNum map) {
		ArbitraryNum mapThree = new ArbitraryNum();
		int size = values.size();
		if (map.values.size() > size) {
			size = map.values.size();
		}

		for (int i = 1; i <= size; i++) {
			int one = 0, two = 0, three = 0;

			if (values.containsKey(i)) {
				one = values.get(i);
			}
			if (map.values.containsKey(i)) {
				two = map.values.get(i);
			}
			if (mapThree.values.containsKey(i)) {
				three = mapThree.values.get(i);
			}
			mapThree.values.put(i, one + two + three);
			fixMap(mapThree);
		}
		values = mapThree.values;
	}

	/**
	 * Multiple a map by a number. This class is only useful is the value of the
	 * multiplyer will fit into an integer.
	 * 
	 * @param map
	 *            The map you would like to multiply by something.
	 * @param multiplyer
	 *            The value you want to multiply by.
	 * @return A new map containing the value of a the old map multiplied by a
	 *         new map.
	 */
	public static ArbitraryNum multiplyMap(ArbitraryNum map, int multiplyer) {

		for (int j = 1; j <= map.values.keySet().size(); j++) {
			map.values.put(j, map.values.get(j) * multiplyer);
		}
		map = fixMap(map);
		return map;
	}

	/**
	 * This method will simply take in a map and print it out like the numerical
	 * value it actually represents. A toString() essentially for these math
	 * maps.
	 * 
	 * @param map
	 *            The map you would like to print out.
	 * @return A String containing the value stored in the map.
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = values.size(); i > 0; i--) {
			buffer.append(values.get(i));
		}
		return buffer.toString();
	}

	@Override
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
	public static ArbitraryNum fixMap(ArbitraryNum map) {

		for (int k = 1; k <= map.values.keySet().size(); k++) {

			int temp = map.values.get(k);
			if (temp > 9) {
				int remainder = temp % 10;
				int temp2 = (temp - (temp % 10)) / 10;
				map.values.put(k, remainder);

				if (map.values.keySet().contains(k + 1)) {
					int temp3 = map.values.get(k + 1);
					map.values.put(k + 1, temp2 + temp3);
				} else {
					map.values.put(k + 1, temp2);
				}
			}
		}
		return map;
	}

	/**
	 * The following method will take a string such as "1234" and convert it
	 * into a map to be used in the mapMath funcitons. For instance "1234" will
	 * become {1=4,2=3,3=2,4=1}
	 * 
	 * @param number
	 *            The string representation of a number.
	 * @return The map representation of the inputed number.
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

	public long summationOfDigits() {
		long summation = 0;

		for (Integer i : values.keySet()) {
			summation += values.get(i);
		}
		return summation;
	}

	public int length() {
		return values.size();
	}
}
