package ch05_bit_manipulation.q1_insertion;

public class Insertion {

	public static void main(String[] args) {
		int N = 1040;
		int M = 19;
		int i = 2;
		int j = 6;

		int clearerLeft = -1 << (j);	//111111100000000... j zeros
		int clearerRight = (1 << i) - 1;	//0000001111... i ones
		int clearer = clearerLeft | clearerRight;
		N = N & clearer;
		M = M << i;

		System.out.println(N | M);
	}

}
