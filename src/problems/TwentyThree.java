package problems;

import java.util.ArrayList;
import java.util.List;

import resources.Utilities;

public class TwentyThree {

	public static int limit = 28123;

	public static List<Long> abundantNumbers() {
		List<Long> abundants = new ArrayList<Long>();
		for (long i = 0; i <= limit; i++) {
			if (Utilities.getSummationOfList(Utilities.findFactors(i)) > i) {
				abundants.add(i);
			}
		}
		return abundants;
	}

	public static List<Long> findNonAbundantsSums() {
		List<Long> nonAbundants = new ArrayList<Long>();
		List<Long> abundants = abundantNumbers();

		for (Long i = (long) 0; i < limit; i++) {
			boolean abundantSum = false;
			for (Long j = (long) 0; j < abundants.size(); j++) {
				for (Long k = (long) 0; k < abundants.size(); k++) {
					if ((j + k == i)) {

						abundantSum = true;
					}
				}
			}
			if (!abundantSum) {
				nonAbundants.add(i);
			}
		}
		System.out.println(nonAbundants);
		return nonAbundants;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findNonAbundantsSums();

	}

}
