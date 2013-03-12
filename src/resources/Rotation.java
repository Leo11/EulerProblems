package resources;

import java.util.ArrayList;
import java.util.List;

/**
 * The following class rotates numbers.
 * 
 * For instance if you had the number 197, the rotations would be 719 and 971
 * and 197.
 * 
 * @author Leo Rausch
 * 
 */
public class Rotation {

	/**
	 * This method rotates a number for you. For instance if you had the number
	 * 197, the rotations would be 719 and 971 and 197.
	 * 
	 * @param n
	 *            The starting number.
	 * @return A list of possible rotations of the given number.
	 */
	public static List<Integer> rotations(Integer n) {
		List<Integer> rotationList = new ArrayList<Integer>();

		int length = n.toString().length();

		for (int k = 0; k < length; k++) {

			int newRotation = (int) ((n % 10) * Math.pow(10, length - 1))
					+ ((n - (n % 10)) / 10);
			rotationList.add(newRotation);
			n = newRotation;
		}
		return rotationList;
	}

	public static void main(String[] args) {

		System.out.println(rotations(197));

	}

}
