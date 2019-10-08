package ch01_arrays_and_strings.q8_zero_matrix;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {
	private static int[][] matrix = {{0,1,1,1,1},{1,1,0,1,0},{1,1,1,1,1},{1,1,0,1,1}, {1,1,1,1,1}};

	public static void main(String[] args) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ,");
			}
			System.out.println();
		}
		System.out.println();
		
		setZeros(matrix);
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ,");
			}
			System.out.println();
		}
	}

	//O(M.N)
	//O(2c) c is the total count of zeros in the matrix 
	private static void setZeros(int[][] m) {
		List<Integer> zeroRows = new ArrayList<>();
		List<Integer> zeroCols = new ArrayList<>();
		
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				if(m[i][j] == 0) {
					zeroCols.add(j);
					zeroRows.add(i);
				}
			}
		}
		
		for(int rowNum : zeroRows) {
			for(int j=0; j<matrix[rowNum].length; j++) {
				matrix[rowNum][j] = 0;
			}
		}
		
		for(int colNum : zeroCols) {
			for(int i=0; i<matrix.length; i++) {
				matrix[i][colNum] = 0;
			}
		}
	}
}
