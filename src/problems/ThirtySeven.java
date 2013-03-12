package problems;

import resources.Utilities;

/**
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 * @author Leo Rausch
 * 
 */
public class ThirtySeven {

	public static int removeLeft(int n) {
		return (int) (n % Math.pow(10, (n + "").length() - 1));
	}

	public static int removeRight(int n) {
		return (n - (n % 10)) / 10;
	}

	public static void main(String[] args) {

		int count = 0;
		int sum = 0;
		int counter = 10;

		while (count < 11) {
			int n = counter;
			boolean prime = true;
			for (int i = (counter + "").length(); i > 0; i--) {

				if (!Utilities.isPrime(n)) {
					prime = false;
					break;
				} else {
					n = removeLeft(n);
				}
			}
			n = counter;
			for (int i = (counter + "").length(); i > 0; i--) {

				if (!Utilities.isPrime(n)) {
					prime = false;
					break;
				} else {
					n = removeRight(n);
				}
			}
			if (prime) {
				System.out.println(counter);
				sum += counter;
				count++;
			}
			counter++;
		}
		System.out.println(sum);
	}
}
