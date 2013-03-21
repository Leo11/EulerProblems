package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Project Euler Problem 22 http://projecteuler.net/problem=22
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it longo
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 * 
 * For example, when the list is sorted longo alphabetical order, COLIN, which
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * @author Leo Rausch
 * 
 */
public class TwentyTwo {

	public static Map<String, Integer> createAlphaMap() {
		Map<String, Integer> alphaMap = new HashMap<String, Integer>();

		alphaMap.put("A", 1);
		alphaMap.put("B", 2);
		alphaMap.put("C", 3);
		alphaMap.put("D", 4);
		alphaMap.put("E", 5);
		alphaMap.put("F", 6);
		alphaMap.put("G", 7);
		alphaMap.put("H", 8);
		alphaMap.put("I", 9);
		alphaMap.put("J", 10);
		alphaMap.put("K", 11);
		alphaMap.put("L", 12);
		alphaMap.put("M", 13);
		alphaMap.put("N", 14);
		alphaMap.put("O", 15);
		alphaMap.put("P", 16);
		alphaMap.put("Q", 17);
		alphaMap.put("R", 18);
		alphaMap.put("S", 19);
		alphaMap.put("T", 20);
		alphaMap.put("U", 21);
		alphaMap.put("V", 22);
		alphaMap.put("W", 23);
		alphaMap.put("X", 24);
		alphaMap.put("Y", 25);
		alphaMap.put("Z", 26);

		return alphaMap;
	}

	public static List<String> loadList(String path) {
		List<String> list = new ArrayList<String>();
		Scanner input = null;
		try {
			input = new Scanner(new File(path));
			while (input.hasNextLine()) {
				String temp = input.nextLine();
				String[] tempList = temp.split(",");
				for (int i = 0; i < tempList.length; i++) {
					list.add(tempList[i]);
				}
			}
			

		} catch (FileNotFoundException e1) {
			System.out
					.println("Could not find the specified file for the Sensitive Data list");
		} finally{
			input.close();
		}
		return list;
	}

	public static List<String> stripQuotes(List<String> list) {
		List<String> result = new ArrayList<String>();
		for (String s : list) {
			result.add(s.substring(1, s.length() - 1));
		}
		return result;
	}

	public static long addNameValues(Map<Integer, String> nameMap) {

		Map<String, Integer> alphaMap = createAlphaMap();

		long result = 0;
		for (int i = 1; i <= nameMap.size(); i++) {

			String nthName = nameMap.get(i);

			int score = 0;
			for (int j = 0; j < nthName.length(); j++) {
				score += alphaMap.get(nthName.charAt(j) + "");
			}
			result += score * i;
		}
		return result;

	}

	public static void main(String[] args) {

		String path = "src/Problem22_names.txt";

		List<String> names = loadList(path);
		names = stripQuotes(names);

		Set<String> orderedNames = new TreeSet<String>(names);

		Map<Integer, String> mapWithIndexes = new HashMap<Integer, String>();

		int count = 1;
		for (String s : orderedNames) {
			mapWithIndexes.put(count, s);
			count++;
		}

		System.out.println(addNameValues(mapWithIndexes));
	}
}
