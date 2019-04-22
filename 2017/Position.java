package frq2017;

public class Position {

	private int row;
	private int col;
	
	/** Constructs a Position object with row r and column c. */ 
	public Position(int r, int c){
		row = r;
		col = c;
	}
	
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
}
