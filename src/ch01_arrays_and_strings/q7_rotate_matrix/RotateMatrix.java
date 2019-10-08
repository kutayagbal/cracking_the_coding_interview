package ch01_arrays_and_strings.q7_rotate_matrix;

public class RotateMatrix {
	private static int[][] matrix = {{1,2,3,4,17},{5,6,7,8,18},{9,10,11,12,19},{13,14,15,16,20}, {21,22,23,24,25}};

	public static void main(String[] args) {
		int n = matrix[0].length;
		int levelCount = n / 2;
		
		for(int i=0; i<matrix[0].length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=1; i<levelCount+1; i++) {
			rotate(matrix, n, i);
		}
	
		for(int i=0; i<matrix[0].length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	private static void rotate(int[][] m, int n, int level) {
		int temp1,temp2;
		
		for(int i=level-1, j=n-level; i<n-level & j>level-1;  i++, j--) {
			temp1 = m[n-level][i];
			m[n-level][i] = m[i][level-1];
			temp2 = m[j][n-level];
			m[j][n-level] = temp1;
			temp1 = m[level-1][j];
			m[level-1][j] = temp2;
			m[i][level-1] = temp1;
		}
	}
}
