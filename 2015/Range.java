package frq2015;

public class Range implements NumberGroup{

	/*instance variables*/
	private int min;
	private int max;
	
	/** constructs a Range object. */
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	/** check whether an integer is in the range. */
	public boolean contains(int num) {
		return num >= min && num <= max;
	}
}
