package problems;

import java.util.HashSet;
import java.util.Set;

import resources.ArbitraryNum;

/**
 * 
 * @author Leo Rausch
 *
 */
public class TwentyNine {

	public static Set<String> distinctPowers(int maxA, int maxB) {

		Set<String> set = new HashSet<String>();

		for (int a = 2; a <= maxA; a++) {

			ArbitraryNum tempNumber = new ArbitraryNum(a + "");

			for (int b = 2; b <= maxB; b++) {
				tempNumber = ArbitraryNum.multiply(tempNumber, a);
				set.add(tempNumber.toString());
			}
		}

		return set;
	}

	public static void main(String[] args) {
		Set<String> result = distinctPowers(100, 100);
		for (String s : result) {
			System.out.println(s);
		}
		System.out.println("Size of result = " + result.size());
	}

}
