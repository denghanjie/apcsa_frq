package frq2014;

import java.util.ArrayList;
import java.util.List;

public class ScrambleStrings {

	/**
	 * Scrambles a given word.
	 * @param word the word to be scrambled
	 * @return the scrambled word (possibly equal to word)
	 * Precondition: word is either an empty string or contains only uppercase letters.
	 * Postcondition: the string returned was created from word as follows:
	 * 	- the word was scrambled, beginning at the first letter and continuing from left to right.
	 *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
	 *  - letters were swapped at most once
	 */
	public static String scrambleWord(String word) {
		String scramble = "";
		
		for(int i = 0; i < word.length(); i++) {
			if(i < word.length() - 1 && 
					word.substring(i,i+1).equals("A") &&
					!word.substring(i+1,i+2).equals("A")) {
				scramble += word.substring(i+1,i+2);
				scramble += word.substring(i,i+1);
				i++;
			}else {
				scramble += word.substring(i,i+1);
			}
		}
		
		return scramble;
	}
	
	/**
	 * Modifies wordList by replacing each word with its scrambled
	 * version, removing any words that are unchanged as a result of scrambling.
	 * @param wordList the list of words
	 * Precondition: wordList contains only non-null objects
	 * Postcondition:
	 * 	- all words unchanged by scrambling have been removed from wordList
	 *  - each of the remaining words has been replaced by its scrambled version
	 *  - the relative ordering of the entries in wordList is the same as it was
	 *  	  before the method was called
	 */
	public static void scrambleOrRemove(List<String> wordList) {
		for(int i = wordList.size() - 1; i >= 0; i--) {
			String word = wordList.get(i);
			String scramble = scrambleWord(word);
			if(word.equals(scramble)) {
				wordList.remove(i);
			}else {
				wordList.set(i, scramble);
			}
		}
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		System.out.println(scrambleWord("TAN"));				// "TNA"
		System.out.println(scrambleWord("ABRACADABRA"));		// "BARCADABARA"
		System.out.println(scrambleWord("WHOA"));			// "WHOA"
		System.out.println(scrambleWord("AARDVARK"));		// "ARADVRAK"
		System.out.println(scrambleWord("EGGS"));			// "EGGS"
		System.out.println(scrambleWord("A"));				// "A"
		System.out.println(scrambleWord(""));				// ""
		
		List<String> wordList = new ArrayList<>();
		wordList.add("TAN");
		wordList.add("ABRACADABRA");
		wordList.add("WHOA");
		wordList.add("APPLE");
		wordList.add("EGGS");
		scrambleOrRemove(wordList);
		System.out.println(wordList);
	}
}
