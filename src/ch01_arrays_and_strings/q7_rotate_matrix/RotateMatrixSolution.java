package ch01_arrays_and_strings.q7_rotate_matrix;

public class RotateMatrixSolution {
	private static int[][] matrix = {{1,2,3,4,17},{5,6,7,8,18},{9,10,11,12,19},{13,14,15,16,20}, {21,22,23,24,25}};
	
	public static void main(String[] args) {
		for(int i=0; i<matrix[0].length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		
		System.out.println();
		rotate(matrix);
		
		for(int i=0; i<matrix[0].length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
		
	}

	private static boolean rotate(int[][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		
		int n = matrix.length;
		
		for(int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n-1-layer;
			
			for(int i=first; i<last; i++) {
				int offset = i-first;
				
				int top = matrix[first][i];//save top
				
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				//bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				//right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				//top -> right
				matrix[i][last] = top;
			}
		}
		
		return true;
	}
}
