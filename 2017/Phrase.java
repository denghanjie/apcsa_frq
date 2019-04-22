package frq2017;

public class Phrase {
	private String currentPhrase;

	/** Constructs a new Phrase object. */
	public Phrase(String p) {
		currentPhrase = p;
	}

	/**
	 * Returns the index of the nth occurrence of str in the current phrase; returns
	 * -1 if the nth occurrence does not exist. 
	 * Precondition: str.length() > 0 and n> 0 
	 * Postcondition: the current phrase is not modified.
	 */
	public int findNthOccurrence(String str, int n) {
		int index = currentPhrase.indexOf(str);
		for(int i = 1; i < n && index >= 0; i++) {
			index = currentPhrase.indexOf(str, index+1);
		}
		return index;
	}

	/**
	 * Modifies the current phrase by replacing the nth occurrence of str with repl.
	 * If the nth occurrence does not exist, the current phrase is unchanged.
	 * Precondition: str.length() > 0 and n > 0
	 */
	public void replaceNthOccurrence(String str, int n, String repl) {
		int nthIndex = findNthOccurrence(str, n);
		if(nthIndex < 0) return;
		
		currentPhrase = currentPhrase.substring(0, nthIndex) 
						+ repl 
						+ currentPhrase.substring(nthIndex + str.length());
	}

	/**
	 * Returns the index of the last occurrence of str in the current phrase;
	 * returns -1 if str is not found. 
	 * Precondition: str.length() > 0 
	 * Postcondition: the current phrase is not modified.
	 */
	public int findLastOccurrence(String str) {
		int step = 1;
		int preIndex = -1;
		int index = findNthOccurrence(str, step);
		
		while(index >= 0) {
			step++;
			preIndex = index;
			index = findNthOccurrence(str, step);
		}
		
		return preIndex;
	}

	/** Returns a string containing the current phrase. */
	public String toString() {
		return currentPhrase;
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		
		testFindNthOccurrence();
		testReplaceNthOccurrence();
		testFindLastOccurrence();
		
	}
	
	private static void testFindNthOccurrence() {
		Phrase phrase1 = new Phrase("A cat ate late.");
		System.out.println("phrase1.findNthOccurrence(\"at\", 1): " + phrase1.findNthOccurrence("at", 1));
		
		Phrase phrase2 = new Phrase("A cat ate late.");
		System.out.println("phrase2.findNthOccurrence(\"at\", 6): " + phrase2.findNthOccurrence("at", 6));
	
		Phrase phrase3 = new Phrase("A cat ate late.");
		System.out.println("phrase3.findNthOccurrence(\"bat\", 2): " + phrase3.findNthOccurrence("bat", 2));
		
		Phrase phrase4 = new Phrase("aaaa");
		System.out.println("phrase4.findNthOccurrence(\"aa\", 1): " + phrase4.findNthOccurrence("aa", 1));

		Phrase phrase5 = new Phrase("aaaa");
		System.out.println("phrase5.findNthOccurrence(\"aa\", 2): " + phrase5.findNthOccurrence("aa", 2));
	}
	
	private static void testReplaceNthOccurrence() {
		Phrase phrase1 = new Phrase("A cat ate late.");
		phrase1.replaceNthOccurrence("at", 1, "rane");
		System.out.println(phrase1);
		
		Phrase phrase2 = new Phrase("A cat ate late.");
		phrase2.replaceNthOccurrence("at", 6, "xx");
		System.out.println(phrase2);
		
		Phrase phrase3 = new Phrase("A cat ate late.");
		phrase3.replaceNthOccurrence("bat", 2, "xx");
		System.out.println(phrase3);
		
		Phrase phrase4 = new Phrase("aaaa");
		phrase4.replaceNthOccurrence("aa", 1, "xx");
		System.out.println(phrase4);
		
		Phrase phrase5 = new Phrase("aaaa");
		phrase5.replaceNthOccurrence("aa", 2, "bbb");
		System.out.println(phrase5);
	}
	
	private static void testFindLastOccurrence() {
		Phrase phrase1 = new Phrase("A cat ate late.");
		System.out.println("phrase1.findLastOccurrence(\"at\"): " + phrase1.findLastOccurrence("at"));
		System.out.println("phrase1.findLastOccurrence(\"cat\"): " + phrase1.findLastOccurrence("cat"));
		System.out.println("phrase1.findLastOccurrence(\"bat\"): " + phrase1.findLastOccurrence("bat"));
	}
}
