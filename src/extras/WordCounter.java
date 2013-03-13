package extras;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Java Developer Challenge Create a Java class that will count the number of
 * words in a text file and output only the top 10 most frequently used words to
 * the system console.
 * 
 * Restrictions:
 * 
 * -Do not use any 3rd party libraries or open source projects
 * 
 * -Pathname to the file will be passed in via the command line
 * 
 * -Assume European languages, but any language should be supported including
 * Asian character sets
 * 
 * @author Leo Rausch
 * 
 */
public class WordCounter {

	/**
	 * This method will create a map where the key is a word and the value is
	 * the amount of times that word was used in a text file. Input will
	 * currently be stripped down to only the characters a-z and it is assumed
	 * that english is used as the sanitization filter for now.
	 * 
	 * @param filePath
	 *            The file path of the text file.
	 * @return A map where the key is a word and the value is how many times it
	 *         is used in the given file. Ex.) {this=15, is=5}
	 */
	public static Map<String, Integer> countWords(final String filePath) {

		Map<String, Integer> wordStats = new HashMap<String, Integer>();
		Scanner input = null;

		try {
			input = new Scanner(new File(filePath));

			while (input.hasNextLine()) {

				String temp = input.nextLine();
				for (String s : temp.split(" ")) {

					// Sanitize input to lowercase english alphabet.
					// TODO Implement sanitization based on parameter of
					// language.
					s = sanitizeEnglish(s);

					if (s.length() > 0) {

						// If the word is already in the map, increment the
						// usage value. Otherwise add it to the map.
						if (wordStats.containsKey(s)) {
							wordStats.put(s, wordStats.get(s) + 1);
						} else {
							wordStats.put(s, 1);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Count not find the specified file.");
		} finally {
			input.close();
		}

		return wordStats;
	}

	/**
	 * Takes in a string and sanitizes the formatting. This method will remove
	 * any character that is not lowercase a-z.
	 * 
	 * @param word
	 *            The word that you would like to sanitize
	 * @return A sanitized version of the word stripped of all characters but
	 *         a-z.
	 */
	public static String sanitizeEnglish(final String word) {

		String lowercaseWord = word.toLowerCase();
		char[] array = lowercaseWord.toCharArray();
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < array.length; i++) {
			if ((int) array[i] > 96 && (int) array[i] < 123) {
				buffer.append(array[i]);
			}
		}

		return buffer.toString();
	}

	/**
	 * This method will print out the top n values of the map.
	 * 
	 * @param countWords
	 *            A map containing <String, Integer> where the string is a word
	 *            and the integer is how many times is has been used.
	 * @param topN
	 *            The top n values that you would like to print out. Ex.) 10
	 *            will print out the words with the top 10 usage.
	 */
	public static void prettyPrintTopN(final Map<String, Integer> countWords,
			final int topN) {

		Set<Integer> topSet = new TreeSet<Integer>(Collections.reverseOrder());
		topSet.addAll(countWords.values());

		int limit = Math.min(topN, topSet.size());
		int count = 1;

		for (Integer i : topSet) {
			if (count <= limit) {
				System.out.println("The following words were used " + i
						+ " times.");
				for (String s : countWords.keySet()) {
					if (countWords.get(s) == i) {
						System.out.println(s);
					}
				}
			} else {
				break;
			}
			count++;
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		prettyPrintTopN(countWords(args[0]), 10);
	}
}
