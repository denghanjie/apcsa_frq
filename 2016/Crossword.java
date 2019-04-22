package frq2016;

public class Crossword {

	/** 
	 * Each element is a Square object with a color (black or white) and a number. 
	 * puzzle[r][c] represents the square in row r, column c.
	 * There is at least one row in the puzzle.
	 */
	private Square[][] puzzle;
	
	/**
	 * Constructs a crossword puzzle grid.
	 * Precondition: There is at least one row in blackSquares
	 * Postcondition:
	 * 	- The crossword puzzle has the same dimensions as blackSquares
	 *  - The Square object at row  r, column c in the crossword puzzle grid is black
	 *  	  if and only if blackSquares[r][c] is true.
	 *  - The squares in the puzzle are labeled according to the crossword labeling rule.
	 * @param blackSquares
	 */
	public Crossword(boolean[][] blackSquares) {
		puzzle = new Square[blackSquares.length][blackSquares[0].length];
		int num = 1;
		for(int r = 0; r < blackSquares.length; r++) {
			for(int c = 0; c < blackSquares[0].length; c++) {
				if(blackSquares[r][c]) { // the Square is black
					puzzle[r][c] = new Square(true, 0); // set black square to be numbered -1
				}else { // the Square is white
					if(toBeLabeled(r, c, blackSquares)) {
						puzzle[r][c] = new Square(false, num);
						num++;
					}else {
						puzzle[r][c] = new Square(false, 0);
					}
				}
			}
		}
	}
	
	/**
	 * Returns true if the square at row r, column c should be labeled with a positive number;
	 * false otherwise.
	 * The square at row r, column c is black if and only if blackSquares[r][c] is true.
	 * Precondition: r and c are valid indexes in blackSquares.
	 */
	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
		if(blackSquares[r][c]) return false; // This is a black square.
		
		// The square does not have a white square immediately above it.
		if(r == 0 || blackSquares[r-1][c]) return true; 

		// The square does not have a white square to its left.
		if(c == 0 || blackSquares[r][c-1]) return true;
		
		return false;
	}
	
	/**
	 * A 2D representation of this puzzle.
	 */
	public String toString() {
		StringBuilder res = new StringBuilder();
		for(int r = 0; r < puzzle.length; r++) {
			for(int c = 0; c < puzzle[0].length; c++) {
				res.append(puzzle[r][c] + " ");
			}
			res.append("\n");
		}
		return res.toString();
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		boolean[][] blackSquares = {
				{true, false, false, true, true, true, false, false, false},
				{false, false, false, false, true, false, false, false, false},
				{false, false, false, false, false, false, true, true, true},
				{false, false, true, false, false, false, true, false, false},
				{true, true, true, false, false, false, false, false, false},
				{false, false, false, false, true, false, false, false, false},
				{false, false, false, true, true, true, false, false, true},
									};
		Crossword puzzle = new Crossword(blackSquares);
		System.out.println(puzzle);
	}
}
