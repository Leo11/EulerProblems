package problems;

import java.util.Map;

import resources.FibonacciLarge;

/**
 * Project Euler Problem 25 http://projecteuler.net/problem=25
 * 
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * @author Leo Rausch
 * 
 */
public class TwentyFive {

	public static int findFirstFibWithNDigits(int n) {
		FibonacciLarge fib = new FibonacciLarge();
		int count = 0;
		boolean found = false;
		while (!found) {
			count++;
			Map<Integer, Integer> map = fib.findNthFib(count);
			if (map.size() == 1000) {
				found = true;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findFirstFibWithNDigits(1000));
	}
}
