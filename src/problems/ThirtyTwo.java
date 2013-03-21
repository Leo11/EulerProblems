package problems;

import java.util.HashSet;
import java.util.Set;

import resources.Utilities;

/**
 * Project Euler Problem 32 http://projecteuler.net/problem=32
 * 
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1
 * through 5 pandigital.
 * 
 * The product 7254 is unusual, as the identity, 39 186 = 7254, containing
 * multiplicand, multiplier, and product is 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 * 
 * HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 * 
 * @author Leo Rausch
 * 
 */
public class ThirtyTwo {

	
	 public static Set<Long> sumOfProblemThirtyTwo(){
		 
		 Set<Long> result = new HashSet<Long>();
		 
		 for(int i = 0; i < 10000; i++){
			 for(int j = 0; j<10000; j++){
				 int tempSum = i * j;
				 String tempString = i + "" + j + "" + tempSum;
				 if(Utilities.isPandigital("123456789", tempString)){
					 result.add((long) tempSum);
				 }
			 }
		 }
		 return result;
	 }
	
	public static void main(String[] args) {
		System.out.println(Utilities.getSummationOfSet(sumOfProblemThirtyTwo()));
	}
}
