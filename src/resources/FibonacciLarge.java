package resources;

import java.util.HashMap;
import java.util.Map;

/**
 * This class should be used to find a fibonacci number of any size.
 * 
 * @author Leo Rausch
 * 
 */
public class FibonacciLarge {

	/**
	 * Lookup table for fibonacci numbers that have already been found. There's
	 * no point in computing the same value two times.
	 */
	private Map<Integer, Map<Integer, Integer>> lookup;

	public FibonacciLarge() {
		lookup = new HashMap<Integer, Map<Integer, Integer>>();
	}

	/**
	 * Find the nth fibonacci number.
	 * 
	 * @param number
	 *            The number fibonacci you would like to find.
	 * @return The nth fibonacci number.
	 */
	public Map<Integer, Integer> findNthFib(int number) {

		if (lookup.containsKey(number)) {
			return lookup.get(number);
		}
		if (number < 2) {
			Map<Integer, Integer> result = new HashMap<Integer, Integer>();
			result.put(number, number);
			return result;
		} else {
			Map<Integer, Integer> fib = MapMath.addMaps(findNthFib(number - 2),
					findNthFib(number - 1));
			lookup.put(number, fib);
			return fib;
		}
	}
}
