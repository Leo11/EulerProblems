package com.rausch.euler.problems;

import java.util.List;

import com.rausch.euler.resources.Permutation;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up
 * of each of the digits 0 to 9 in some order, but it also has a rather
 * interesting sub-string divisibility property.
 * 
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note
 * the following:
 * 
 * d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible by 3 d4d5d6=635 is
 * divisible by 5 d5d6d7=357 is divisible by 7 d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13 d8d9d10=289 is divisible by 17
 * 
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 * 
 * @author Leo Rausch
 * 
 */
public class FourtyThree {

	public static Long fourtyThree() {

		Permutation permute = new Permutation();
		permute.permute("1234567890");
		List<String> pandigitals = permute.results;

		Long sum = new Long(0);

		for (String s : pandigitals) {
			boolean result = true;

			if (!(Integer.parseInt(s.substring(1, 4)) % 2 == 0)) {
				result = false;
			} else if (!(Integer.parseInt(s.substring(2, 5)) % 3 == 0)) {
				result = false;
			} else if (!(Integer.parseInt(s.substring(3, 6)) % 5 == 0)) {
				result = false;
			} else if (!(Integer.parseInt(s.substring(4, 7)) % 7 == 0)) {
				result = false;
			} else if (!(Integer.parseInt(s.substring(5, 8)) % 11 == 0)) {
				result = false;
			} else if (!(Integer.parseInt(s.substring(6, 9)) % 13 == 0)) {
				result = false;
			} else if (!(Integer.parseInt(s.substring(7, 10)) % 17 == 0)) {
				result = false;
			}
			if (result) {
				sum += Long.parseLong(s);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(fourtyThree());
	}
}
