package problems;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Project Euler Problem 24 http://projecteuler.net/problem=24
 * 
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 * 
 * @author Leo Rausch
 * 
 */
public class TwentyFour {

	
	public static String findNthLexicographicPermutation(String digits, int n) {

		resources.Permutation permutationGenerator = new resources.Permutation();
		permutationGenerator.permute(digits);
		List<String> permutations = permutationGenerator.results;
		Set<String> treeSet = new TreeSet<String>(permutations);

		int count = 1;
		String result = "";
		for (String s : treeSet) {
			if (count == n) {
				result = s;
			}
			count++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findNthLexicographicPermutation("0123456789",
				1000000));
	}
}
