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
public class MapMath {

	/**
	 * Add two numbers together.
	 * 
	 * @param mapOne
	 *            Map containing the first number.
	 * @param mapTwo
	 *            Map containing the second number.
	 * @return a third map containing the two input maps added together.
	 */
	public static Map<Integer, Integer> addMaps(Map<Integer, Integer> mapOne,
			Map<Integer, Integer> mapTwo) {
		Map<Integer, Integer> mapThree = new HashMap<Integer, Integer>();
		int size = mapOne.size();
		if (mapTwo.size() > size) {
			size = mapTwo.size();
		}

		for (int i = 1; i <= size; i++) {
			int one = 0, two = 0, three = 0;

			if (mapOne.containsKey(i)) {
				one = mapOne.get(i);
			}
			if (mapTwo.containsKey(i)) {
				two = mapTwo.get(i);
			}
			if (mapThree.containsKey(i)) {
				three = mapThree.get(i);
			}
			mapThree.put(i, one + two + three);
			Utilities.fixMap(mapThree);
		}
		return mapThree;
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
	public static Map<Integer, Integer> multiplyMap(Map<Integer, Integer> map,
			int multiplyer) {

		for (int j = 1; j <= map.keySet().size(); j++) {
			map.put(j, map.get(j) * multiplyer);
		}
		map = Utilities.fixMap(map);
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
	public static String printAsNumber(Map<Integer, Integer> map) {
		StringBuffer buffer = new StringBuffer();
		for (int i = map.size(); i > 0; i--) {
			buffer.append(map.get(i));
		}
		return buffer.toString();
	}

	/**
	 * Basic equals function for the Mapmath class
	 * @param map1 First map
	 * @param map2 Second map
	 * @return Whether or not the two maps are equal
	 */
	public static boolean equals(Map<Integer, Integer> map1,
			Map<Integer, Integer> map2) {
		boolean result = true;

		if (!(map1.size() == map2.size())) {
			result = false;
		} else {
			for (Integer i : map1.keySet()) {
				if (!(map1.get(i) == map2.get(i))) {
					result = false;
				}
			}
		}
		return result;
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
	public static Map<Integer, Integer> convertNumberString(String number) {
		Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();

		char[] individualNumbers = number.toCharArray();

		int count = 1;
		for (int i = individualNumbers.length; i > 0; i--) {
			numberMap.put(count, (int) individualNumbers[i - 1] - 48);
			count++;
		}
		return numberMap;
	}
}
