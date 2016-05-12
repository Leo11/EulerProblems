package com.rausch.euler.resources;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is to be used when finding fibonacci numbers under the following
 * values.
 * 
 * Integer.MAX_VALUE, 2^31 or 2147483648.
 * 
 * If a large number needs to be found then use FibonacciLarge.java for
 * arbitrary size numbers.
 * 
 * @author Leo Rausch
 * 
 */
public class Fibonacci {

	private Map<Integer, Integer> lookup;

	public Fibonacci() {
		lookup = new HashMap<Integer, Integer>();
	}

	/**
	 * Returns the nth place fibonacci number starting at
	 * 
	 * 0 = 0, 1 = 1, 2 = 1, 3 = 2, etc...
	 * 
	 * @param number
	 *            The place of the fibonacci number you want to find.
	 * @return The fibonacci number
	 */
	public int fibonacci(int number) {

		if (lookup.containsKey(number)) {
			return lookup.get(number);
		}
		if (number < 2) {
			return number;
		} else {
			int fib = fibonacci(number - 2) + fibonacci(number - 1);
			lookup.put(number, fib);
			return fib;
		}

	}

}
