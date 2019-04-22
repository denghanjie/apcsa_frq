package frq2016;

public class Square {

	/*instance variables*/
	private boolean isBlack;
	private int num;
	
	/**
	 * Constructs one square of a crossword puzzle grid.
	 * Postcondition:
	 * 	- The square is black if and only if isBlack is true.
	 * 	- The square has number num.
	 */
	public Square(boolean isBlack, int num) {
		this.isBlack = isBlack;
		this.num = num;
	}
	

	/**
	 * Return a String representation of a Square
	 */
	public String toString() {
		if(isBlack) return String.format("%-2s", "B");
		else return String.format("%-2d", num);
	}
}
