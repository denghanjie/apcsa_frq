package frq2018;

public class ArrayTester {
	
	/**
	 * Returns an array containing the elements of column c of arr2D in the same
	 * order as they appear in arr2D. 
	 * Precondition: c is a valid column index in arr2D. 
	 * Postcondition: arr2D is unchanged.
	 */
	public static int[] getColumn(int[][] arr2D, int c) {
		int[] col = new int[arr2D.length];
		for(int r = 0; r < arr2D.length; r++) {
			col[r] = arr2D[r][c];
		}
		return col;
	}

	/**
	 * Returns true if and only if every value in arr1 appears in arr2.
	 * Precondition: arr1 and arr2 have the same length. 
	 * Postcondition: arr1 and arr2 are unchanged.
	 */
	public static boolean hasAllValues(int[] arr1, int[] arr2) {
		for(int v1 : arr1) {
			if(!hasValue(arr2, v1))
				return false;
		}
		return true;
	}
	
	/**
	 * Test if arrary arr contains value val.
	 */
	private static boolean hasValue(int[] arr, int val) {
		for(int v : arr) {
			if(v == val)
				return true;
		}
		return false;
	}

	/**
	 * Returns true if arr contains any duplicate values; false otherwise.
	 */
	public static boolean containsDuplicates(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] == arr[j])
					return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if square is a Latin square as described in part (b); 
	 * false otherwise. 
	 * 
	 * Precondition: square has an equal number of rows and columns.
	 * 				 square has at least one row.
	 */
	public static boolean isLatin(int[][] square) {
		// The first row has no duplicate values.
		if(containsDuplicates(square[0])) return false;
		
		// All values in the first row of the square appear in each row of the square.
		for(int r = 1; r < square.length; r++) {
			if(!hasAllValues(square[0], square[r]))
				return false;
		}
		
		// All values in the first row of the square appear in each column of the square.
		for(int c = 0; c < square[0].length; c++) {
			if(!hasAllValues(square[0], getColumn(square, c)))
				return false;
		}
		
		return true;
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		int[][] square1 = {
				{1, 2, 3},
				{2, 3, 1},
				{3, 1, 2}
		};
		
		int[][] square2 = {
				{10, 30, 20, 0},
				{0, 20, 30, 10},
				{30, 0, 10, 20},
				{20, 10, 0, 30}
		};
		
		int[][] square3 = {
				{1, 2, 1},
				{2, 1, 1},
				{1, 1, 2}
		};
		
		int[][] square4 = {
				{1, 2, 3},
				{3, 1, 2},
				{7, 8, 9}
		};
		
		int[][] square5 = {
				{1, 2},
				{1, 2}
		};
		
		System.out.println("Square1 : " + isLatin(square1));
		System.out.println("Square2 : " + isLatin(square2));
		System.out.println("Square3 : " + isLatin(square3));
		System.out.println("Square4 : " + isLatin(square4));
		System.out.println("Square5 : " + isLatin(square5));
	}
}
