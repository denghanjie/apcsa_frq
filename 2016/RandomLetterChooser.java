package frq2016;

public class RandomLetterChooser extends RandomStringChooser{

	/** 
	 * Constructs a random letter chooser using the given string str. 
	 * Precondition: str contains only letters.
	 */
	public RandomLetterChooser(String str) {
		super(getSingleLetters(str));
	}

	/**
	 * Returns an array of single-letter strings.
	 * Each of these strings consists of a single letter from str. Element k
	 * of the returned array contains the single letter at position k of str.
	 * For example, getSingleLetters("cat") returns the
	 * array { "c", "a", "t" }.
	 */
	public static String[] getSingleLetters(String str) {
		int length = str.length();
		String[] letters = new String[length];
		for(int i = 0; i < length; i++) {
			letters[i] = str.substring(i,i+1);
		}
		return letters;
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		RandomLetterChooser letterChooser = new RandomLetterChooser("cat");
		for (int k = 0; k < 4; k++) {
			System.out.print(letterChooser.getNext());
		}
	}
}
