package frq2015;

public class DiverseArray {

	/** Returns the sum of the entries in the one-dimensional array arr. */
	public static int arraySum(int[] arr) {
		int sum = 0;
		for(int val : arr) {
			sum += val;
		}
		return sum;
	}
	
	/** Returns a one-dimensional array in which the entry at index k is the sum of 
	 ** the entries of row k of the two-dimensional array arr2D.
	*/
	public static int[] rowSums(int[][] arr2D) {
		int[] rows = new int[arr2D.length];
		
		int index = 0;
		for(int[] row : arr2D) {
			rows[index] = arraySum(row);
			index++;
		}
		
		return rows;
	}
	
	/** Returns true if all rows in arr2D have different row sums; 
	 ** false otherwise.
	*/
	public static boolean isDiverse(int[][] arr2D) {
		int[] rows = rowSums(arr2D);
		
		for(int i = 0; i < rows.length; i++) {
			for(int j = i + 1; j < rows.length; j++) {
				if(rows[i] == rows[j])
					return false;
			}
		}
		
		return true;
	}
	
	/* Testing Method */
	public static void main(String[] args) {
		int[][] mat1 = {{1, 3, 2, 7, 3},
						{10, 10, 4, 6 ,2},
						{5, 3, 5, 9, 6},
						{7, 6, 4, 2, 1}};
		
		int[][] mat2 = {{1, 1, 5, 3, 4},
				        {12, 7, 6, 1, 9},
				        {8, 11, 10, 2, 5},
				        {3, 2, 3, 0, 6}};
		
		System.out.println("Is mat1 a diverse array? " + isDiverse(mat1));
		System.out.println("Is mat2 a diverse array? " + isDiverse(mat2));
	}
}
