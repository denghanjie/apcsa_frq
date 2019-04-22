package frq2015;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {

	/** The number of rows and columns in the sparse array. */
	private int numRows;
	private int numCols;
	
	/** 
	 * The list of entries representing the non-zero elements of the sparse array. 
	 * Entries are stored in the list in no particular order. Each non-zero element
	 * is represented by exactly one entry in the list. 
	 */
	private List<SparseArrayEntry> entries;
	
	/** Constructs an empty SparseArray. */
	public SparseArray() {
		entries = new ArrayList<>();
	}
	
	/** Constructs a SparseArray from a 2-D array. */
	public SparseArray(int[][] arr) {
		numRows = arr.length;
		numCols = arr[0].length;
		entries = new ArrayList<>();
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[r].length; c++) {
				if(arr[r][c] != 0) {
					SparseArrayEntry entry = new SparseArrayEntry(r, c, arr[r][c]);
					entries.add(entry);
				}
			}
		}
	}
	
	/** Returns the number of rows in the sparse array. */
	public int getNumRows() {
		return numRows;
	}
	
	/** Returns the number of columns in the sparse array. */
	public int getNumCols() {
		return numCols;
	}
	
	/** 
	 * Returns the value of the element at row index row and column index col in the sparse array. 
	 * If there is no entry in entries corresponding to the specified row and column, 0 is returned.
	 * Precondition:0 ≤ row < getNumRows()
	 *              0 ≤ col < getNumCols()
	 */
	public int getValueAt(int row, int col) {
		for(SparseArrayEntry entry : entries) {
			if(entry.getRow() == row && entry.getCol() == col)
				return entry.getValue();
		}
		return 0;
	}
	
	/** Removes the column col from the sparse array. 
	 *  Precondition: 0 ≤ col < getNumCols() 
	 */
	public void removeColumn(int col) {
		// remove entries with col
		for(int i = entries.size()-1; i >= 0; i--) {
			SparseArrayEntry entry = entries.get(i);
			if(entry.getCol() == col)
				entries.remove(i);
		}
		
		// decrement numCols
		numCols--;
		
		// update entries with column number greater than col
		for(int i = 0; i < entries.size(); i++) {
			SparseArrayEntry entry = entries.get(i);
			if(entry.getCol() > col) {
				SparseArrayEntry newEntry = new SparseArrayEntry(entry.getRow(), 
																 entry.getCol()-1, 
																 entry.getValue());
				entries.set(i, newEntry);
			}
		}
	}
	
	public String toString() {
		return "numRows: " + numRows + "\n"
			+  "numCols: " + numCols + "\n"
			+  "entries: " + entries.toString();
	}
	
	/* Testing Method */
	public static void main(String[] args) {
		int[][] arr = {{0, 0, 0, 0, 0},
					   {0, 5, 0, 0, 4},
					   {1, 0, 0, 0, 0},
					   {0, -9, 0, 0, 0},
					   {0, 0, 0, 0, 0},
					   {0, 0, 0, 0, 0}};
		
		SparseArray sa = new SparseArray(arr);
		System.out.println(sa);
		
		sa.removeColumn(1);
		System.out.println(sa);
	}
}
