package ch08_recursion_and_dynamic_programming.q5_reqursive_multiply;

public class ReqursiveMultiply {

	public static void main(String[] args) {
		System.out.println(multiply(5, 4));
	}

	public static int multiply(int num1, int num2) {
		int smallNum = Math.min(num1, num2);
		int bigNum = Math.max(num1, num2);
		return addRecursive(smallNum, bigNum, 0);
	}

	private static int addRecursive(int smallNum, int bigNum, int result) {
		if (smallNum == 0)
			return result;
		else if(smallNum == 1)
			return bigNum + result;
		else if(smallNum == 2)
			return result += bigNum << 1;
		
		return addRecursive(smallNum - 3, bigNum, result + bigNum + (bigNum << 1));
	}
}
