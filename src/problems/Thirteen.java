package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import resources.ArbitraryNum;

/**
 * Project Euler Problem 13 http://projecteuler.net/problem=13
 * 
 * Work out the first ten digits of the sum of the following one-hundred
 * 50-digit numbers.
 * 
 * Found at src/Problem13_LargeSum.txt
 * 
 * @author Leo Rausch
 * 
 */
public class Thirteen {

	public static List<String> loadList(String path) {
		List<String> list = new ArrayList<String>();
		Scanner input;
		try {
			input = new Scanner(new File(path));
			while (input.hasNextLine()) {
				String temp = input.nextLine();

				list.add(temp);

			}
			input.close();

		} catch (FileNotFoundException e1) {
			System.out
					.println("Could not find the specified file for the Sensitive Data list");
		}
		return list;
	}

	public static String findSummationOfList(List<String> numbers) {
		ArbitraryNum result = new ArbitraryNum("0");
		for (String s : numbers) {
			result = ArbitraryNum.addMaps(result,
					ArbitraryNum.convertNumberString(s));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String path = "src/Problem13_LargeSum.txt";
		System.out.println(findSummationOfList(loadList(path)));
	}
}
