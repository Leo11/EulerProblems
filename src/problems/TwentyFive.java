package problems;

import java.util.Map;

import resources.FibonacciLarge;
import resources.MapMath;

/**
 * http://projecteuler.net/problem=25
 * 
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * @author Leo Rausch
 * 
 */
public class TwentyFive {

	public static void main(String[] args) {

		FibonacciLarge fib = new FibonacciLarge();
		int count = 0;
		boolean found = false;
		while (!found) {
			count++;
			Map<Integer, Integer> map = fib.findNthFib(count);
			if (map.size() == 1000) {
				System.out.println(MapMath.printAsNumber(map));
				System.out.println(count);
				found = true;
			}
		}
	}
}
