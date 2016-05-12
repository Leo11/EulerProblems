package com.rausch.euler.problems.fourtynine;

import java.util.ArrayList;
import java.util.List;

import com.rausch.euler.resources.Permutation;
import com.rausch.euler.resources.Utilities;

/**
 * Project Euler Problem 49 http://projecteuler.net/problem=49
 * 
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
 * increases by 3330, is unusual in two ways: (i) each of the three terms are
 * prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this
 * sequence?
 * 
 * @author Leo Rausch
 * 
 */
public class FourtyNine {

	public static List<String> findArithmeticSequence() {

		StringBuffer buff = new StringBuffer();
		List<String> results = new ArrayList<String>();

		for (int i = 1487; i <= 9999; i++) {

			Permutation permutations = new Permutation();
			permutations.permute(i + "");
			int temp = i;

			for (int n = 1; n <= 3; n++) {

				if (Utilities.isPrime(temp)
						&& permutations.results.contains(temp + "")) {
					buff.append(temp + "");
				} else {
					buff = new StringBuffer();
					break;
				}
				temp += 3330;
			}

			if (buff.length() > 0) {
				results.add(buff.toString());
			}
		}
		return results;
	}

	public static void main(String[] args) {
		System.out.println(findArithmeticSequence());
	}
}
