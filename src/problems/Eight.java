package problems;

/**
 * Project Euler Problem 8
 * 
 * Find the greatest product of five consecutive digits in the 1000-digit
 * number.
 * 
 * @author Leo Rausch
 * 
 */
public class Eight {

	/**
	 * @param args
	 */

	public static String info = "7316717653133062491922511967442657474235534"
			+ "9194934969835203127745063262395783180169848018694788518438586156"
			+ "0789112949495459501737958331952853208805511125406987471585238630"
			+ "5071569329096329522744304355766896648950445244523161731856403098"
			+ "7111217223831136222989342338030813533627661428280644448664523874"
			+ "9303589072962904915604407723907138105158593079608667017242712188"
			+ "3998797908792274921901699720888093776657273330010533678812202354"
			+ "2180975125454059475224352584907711670556013604839586446706324415"
			+ "7221553975369781797784617406495514929086256932197846862248283972"
			+ "2413756570560574902614079729686524145351004748216637048440319989"
			+ "0008895243450658541227588666881164271714799244429282308634656748"
			+ "1391912316282458617866458359124566529476545682848912883142607690"
			+ "0422421902267105562632111110937054421750694165896040807198403850"
			+ "9624554443629812309878799272442849091888458015616609791913387549"
			+ "9200524063689912560717606058861164671094050775410022569831552000"
			+ "5593572972571636269561882670428252483600823257530420752963450";
	public static char[] infoChar = info.toCharArray();

	public static int[] charArrayToIntArray(char[] charArray) {
		int[] intArray = new int[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			intArray[i] = charArray[i] - 48;
		}
		return intArray;
	}

	/**
	 * Finds the greatest product of n consecutive digits in an array of int.
	 * 
	 * @param infoChars
	 *            The array of ints that you would like to find the largest
	 *            product of n consecutive digits in.
	 * @param size
	 *            The amount of consecutive digits.
	 * @return The greatest product of n consecutive digits.
	 */
	public static int biggest(int[] infoChars, int size) {

		int biggest = 0;
		for (int i = 0; i < infoChars.length - (size - 1); i++) {
			int mult = 1;
			for (int j = 0; j < size; j++) {
				mult *= infoChars[i + j];
			}
			if (mult > biggest) {
				biggest = mult;
			}
		}
		return biggest;
	}

	public static void main(String[] args) {

		int digits = 5;
		int largest = biggest(charArrayToIntArray(infoChar), digits);
		System.out.println("The greatest product of " + digits
				+ " consecutive digits in the number is " + largest);

	}

}
