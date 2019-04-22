package frq2015;

public class HiddenWord {

	/* instance variable */
	private String hidden;
	
	/* constructor */
	public HiddenWord(String hidden) {
		this.hidden = hidden.toUpperCase();
	}
	
	/** Return a hint based on the following rules:
	 *	1. If the letter in the guess is also in the same position in the hidden word,
	 *		the corresponding character in the hint is the matching letter.
	 *	2. If the letter in the guess is also in the hidden word, but in a different position,
	 *		the corresponding character in the hint is "+".
	 *	3. If the letter in the guess is not in the hidden word, 
	 *		the corresponding character in the hint is "*".
	 */
	public String getHint(String guess) {
		String hint = "";
		
		for(int pos = 0; pos < guess.length(); pos++) {
			String letter = guess.substring(pos,pos+1);
			
			// exist and at the same position
			if(hidden.indexOf(letter) == pos)
				hint += letter;
				
			// exist but at a different position
			else if(hidden.indexOf(letter) != -1)
				hint += "+";
			
			// does not exist
			else if(hidden.indexOf(letter) == -1)
				hint += "*";
		}
		
		return hint;
	}
	
	/* Testing Method */
	public static void main(String[] args) {
		HiddenWord puzzle = new HiddenWord("HARPS");
		
		System.out.println(puzzle.getHint("AAAAA"));
		System.out.println(puzzle.getHint("HELLO"));
		System.out.println(puzzle.getHint("HEART"));
		System.out.println(puzzle.getHint("HARMS"));
		System.out.println(puzzle.getHint("HARPS"));
	}
}
