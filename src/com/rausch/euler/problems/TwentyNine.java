package com.rausch.euler.problems;

import java.util.HashSet;
import java.util.Set;

import com.rausch.euler.resources.ArbitraryNum;

/**
 * 
 * @author Leo Rausch
 *
 */
public class TwentyNine {

	public static Set<ArbitraryNum> distinctPowers(int maxA, int maxB) {

		Set<ArbitraryNum> set = new HashSet<ArbitraryNum>();

		for (int a = 2; a <= maxA; a++) {

			ArbitraryNum tempNumber = new ArbitraryNum(a + "");

			for (int b = 2; b <= maxB; b++) {
				tempNumber = new ArbitraryNum(ArbitraryNum.multiply(tempNumber, a));
				set.add(tempNumber);
			}
		}

		return set;
	}

	public static void main(String[] args) {
		Set<ArbitraryNum> result = distinctPowers(100, 100);
		System.out.println("Size of result = " + result.size());	
	}
}
