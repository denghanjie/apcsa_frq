package frq2017;

public class Successors {

	/** 
	 * Returns the position of num in intArr;
	 * returns null if no such element exists in intArr. 
	 * Precondition: intArr contains at least one row. 
	 */
	 public static Position findPosition(int num, int[][] intArr) {
		 for(int r = 0; r < intArr.length; r++) {
			 for(int c = 0; c < intArr[0].length; c++) {
				 if(intArr[r][c] == num) {
					 return new Position(r, c);
				 }
			 }
		 }
		 
		 return null;
	 }
	 
	 /** 
	  * Returns a 2D successor array as described in part (b) constructed from intArr.
	  * Precondition: intArr contains at least one row and contains consecutive values.
	  * Each of these integers may be in any position in the 2D array.
	  */
	  public static Position[][] getSuccessorArray(int[][] intArr){
		  Position[][] successorArray = new Position[intArr.length][intArr[0].length];
		  for(int r = 0; r < intArr.length; r++) {
			  for(int c = 0; c < intArr[0].length; c++) {
				  successorArray[r][c] = findPosition(intArr[r][c]+1, intArr);
			  }
		  }
		  return successorArray;
	  }
	  
	  /**
	   * Print a 2D Position array.
	   */
	  public static void printPositionArray(Position[][] arr) {
		  for(int r = 0; r < arr.length; r++) {
			  for(int c = 0; c < arr[0].length; c++) {
				  System.out.printf("%8s", arr[r][c]);
			  }
			  System.out.println();
		  }
	  }
	  
	  /**
	   * For testing use
	   */
	  public static void main(String[] args) {
		  int[][] arr = {
				  		 {15, 5, 9, 10},
				  		 {12, 16, 11, 6},
				  		 {14, 8, 13, 7},
				  		};
		  Position[][] succArr = getSuccessorArray(arr);
		  printPositionArray(succArr);
	  }
}
