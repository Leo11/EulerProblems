package resources;

import java.util.ArrayList;
import java.util.List;

public class Rotation {

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
