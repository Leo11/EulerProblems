package resources;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will output the permutations of a given String.
 * 
 * Original Source, I made some modifications.
 * http://www.programmerinterview.com/index.php/recursion/permutations-of-a
 * -string/
 * 
 * @author Leo Rausch
 * 
 */
public class Permutation {

	/**
	 * List of all the permutations of the given input string.
	 */
	public List<String> results;

	/**
	 * Construct it!
	 */
	public Permutation() {
		results = new ArrayList<String>();
	}

	/**
	 * Find all the permutations of the given input string.
	 * 
	 * @param input
	 *            The string containing all the characters that you want to
	 *            permutate.
	 */
	public void permute(String input) {
		int inputLength = input.length();
		boolean[] used = new boolean[inputLength];
		StringBuffer outputString = new StringBuffer();
		char[] in = input.toCharArray();

		doPermute(in, outputString, used, inputLength, 0);

	}

	private void doPermute(char[] in, StringBuffer outputString,
			boolean[] used, int inputLength, int level) {
		if (level == inputLength) {
			results.add(outputString.toString());
		}

		for (int i = 0; i < inputLength; ++i) {

			if (!used[i]) {
				outputString.append(in[i]);
				used[i] = true;
				doPermute(in, outputString, used, inputLength, level + 1);
				used[i] = false;
				outputString.setLength(outputString.length() - 1);
			}
		}
	}
}
