package ch01_arrays_and_strings.q4_palindrome_permutation;

public class PalindromePermutationSolution {
	//This bitvector works because English alphabet has 26 characters that fits 32 bit integer.
	public static void main(String[] args) {
		System.out.println(isPermutationOfPalindrome("Tact Coa"));
	}
	
	//O(n)
	//O(1)
	private static boolean isPermutationOfPalindrome(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}

	private static boolean checkExactlyOneBitSet(int bitVector) {
		int oneNegated =  bitVector - 1;
		int result = oneNegated & bitVector;
		
		return result == 0;
	}

	private static int createBitVector(String phrase) {
		int startValue = Character.getNumericValue('a');
		int endValue = Character.getNumericValue('z');
		int vector = 0;
		
		for(int i=0; i<phrase.length(); i++) {
			int numValue = Character.getNumericValue(phrase.charAt(i));
			if (numValue > endValue || numValue < startValue) {
				continue;
			}
			
			//put 1 for the index
			int mask = 1 << numValue - startValue;
			
			//XOR corresponding same bits are 0, different bits are 1
			vector = vector ^ mask;
		}
		
		return vector;
	}

}
