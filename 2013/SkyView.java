package frq2013;

public class SkyView {

	/** A rectangular array that holds the data 
	 *  representing a rectangular area of the sky. 
	 */ 
	private double[][] view;
	
	/**
	 * Constructs a SkyView object from a 1-dimensional array of scan data.
	 * @param numRows the number of rows represented in the view
	 * 		  Precondition: numRows > 0
	 * @param numCols the number of columns represented in the view
	 * 		  Precondition: numCols > 0
	 * @param scanned the scan data received from the telescope, stored in telescope order
	 * 		  Precondition: scanned.length == numRows * numCols
	 * 
	 * Postcondition: view has been created as a rectangular 2-dimensional array
	 * with numRows rows and numCols columns and the values in scanned have been
	 * copied to view and are ordered as in the original rectangular area of sky.
	 */
	public SkyView(int numRows, int numCols, double[] scanned){
		view = new double[numRows][numCols];
		int i = 0;
		for(int row = 0; row < numRows; row++) {
			if(row%2 == 0) {
				for(int col = 0; col < numCols; col++) {
					view[row][col] = scanned[i];
					i++;
				}
			}else {
				for(int col = numCols-1; col >= 0; col--) {
					view[row][col] = scanned[i];
					i++;
				}
			}
		}
	}
	
	/**
	 * Returns the average of the values in a rectangular section of view.
	 * @param startRow the first row index of the section
	 * @param endRow the last row index of the section
	 * @param startCol the first column index of the section
	 * @param endCol the last column index of the section
	 * Precondition: 0 <= startRow <= endRow < view.length
	 * Precondition: 0 <= startCol <= endCol < view[0].length
	 * @return the average of the values in the specified section of view
	 */
	public double getAverage(int startRow, int endRow,
            					 int startCol, int endCol) {
		double sum = 0.0;
		int count = 0;
		for(int r = startRow; r <= endRow; r++) {
			for(int c = startCol; c <= endCol; c++) {
				sum += view[r][c];
				count++;
			}
		}
		return sum/count;
	}
	
	/**
	 * 2D representation of this SkyView
	 */
	public String toString() {
		if(view == null) return "[[]]";
		
		StringBuilder res = new StringBuilder();
		for(int r = 0; r < view.length; r++) {
			res.append("[");
			for(int c = 0; c < view[r].length-1; c++) {
				res.append(view[r][c] + ", ");
			}
			res.append(view[r][view[r].length-1] + "]\n");
		}
		return res.toString();
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		double[] scanned1 = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9};
		SkyView view1 = new SkyView(4, 3, scanned1);
		System.out.println(view1);
		System.out.println(view1.getAverage(1, 2, 0, 1));
		
//		double[] scanned2 = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1};
//		SkyView view2 = new SkyView(3, 2, scanned2);
//		System.out.println(view2);
	}
}
