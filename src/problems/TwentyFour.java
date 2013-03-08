package problems;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Project Euler Problem 24
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
 * @author Leo
 * 
 */
public class TwentyFour {

	public static void main(String[] args) {
		resources.Permutation permutationGenerator = new resources.Permutation();
		permutationGenerator.permute("0123456789");
		List<String> permutations = permutationGenerator.results;
		Set<String> treeSet = new TreeSet<String>(permutations);

		int count = 1;
		for (String s : treeSet) {
			if (count == 1000000) {
				System.out.println(s);
			}
			count++;
		}
	}
}
