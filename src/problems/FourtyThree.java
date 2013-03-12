package problems;

import java.util.List;

import resources.Permutation;

public class FourtyThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Permutation permute = new Permutation();
		permute.permute("1234567890");
		List<String> pandigitals = permute.results;

		long sum = 0;
		
		for(String s : pandigitals){
			boolean result = true;
			//int i = Integer.parseInt(s.substring(1,4));
			if(!(Integer.parseInt(s.substring(1, 4)) % 2 == 0)){
				result = false;
			}
			else if(!(Integer.parseInt(s.substring(2, 5)) % 3 == 0)){
				result = false;
			}
			else if(!(Integer.parseInt(s.substring(3, 6)) % 5 == 0)){
				result = false;
			}
			else if(!(Integer.parseInt(s.substring(4, 7)) % 7 == 0)){
				result = false;
			}
			else if(!(Integer.parseInt(s.substring(5, 8)) % 11 == 0)){
				result = false;
			}
			else if(!(Integer.parseInt(s.substring(6, 9)) % 13 == 0)){
				result = false;
			}
			else if(!(Integer.parseInt(s.substring(7, 10)) % 17 == 0)){
				result = false;
			}
			if(result){
				System.out.println(s);
				sum += Long.parseLong(s);
			}
		}
		System.out.println(sum);
	}

}
