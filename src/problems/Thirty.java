package problems;

/**
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:
 * 
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 1^4 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 * 
 * 
 * @author Leo Rausch
 * 
 */
public class Thirty {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long totalSum = 0;
		for(int i = 2; i < (5 * Math.pow(9, 5)); i++){
			int tempSum = 0;
			char[] array = (i + "").toCharArray();
			for(char c : array){
				tempSum += Math.pow((int)c - 48, 5);
			}
			if(tempSum == i){
				System.out.println(i);
				totalSum += i;
			}
		}
		System.out.println(totalSum);
	}

}
