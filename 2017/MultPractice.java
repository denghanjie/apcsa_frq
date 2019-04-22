package frq2017;

public class MultPractice implements StudyPractice{

	/*instance variables*/
	private int firstInt;
	private int secondInt;
	
	/**
	 * Construct a MultPractice object
	 */
	public MultPractice(int first, int second) {
		firstInt = first;
		secondInt = second;
	}
	
	/** Returns the current practice problem. */ 
	public String getProblem() {
		return firstInt + " Times " + secondInt;
	}

	/** Changes to the next practice problem. */
	public void nextProblem() {
		secondInt++;
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		StudyPractice p1 = new MultPractice(7, 3);
		System.out.println(p1.getProblem());
		p1.nextProblem();
		System.out.println(p1.getProblem());
		p1.nextProblem();
		System.out.println(p1.getProblem());
		p1.nextProblem();
		System.out.println(p1.getProblem());
		
		StudyPractice p2 = new MultPractice(4, 12);
		p2.nextProblem();
		System.out.println(p2.getProblem());
		System.out.println(p2.getProblem());
		p2.nextProblem();
		p2.nextProblem();
		System.out.println(p2.getProblem());
		p2.nextProblem();
		System.out.println(p2.getProblem());
	}
}
