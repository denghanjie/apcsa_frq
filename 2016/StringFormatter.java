package frq2016;

import java.util.ArrayList;
import java.util.List;

public class StringFormatter {

	/** 
	 * Returns the total number of letters in wordList.
	 * Precondition: wordList contains at least two words, consisting of letters only. 
	 */
	public static int totalLetters(List<String> wordList) {
		int total = 0;
		for(String word : wordList) {
			total += word.length();
		}
		return total;
	}
	
	/**
	 * Returns the basic gap width when wordList is used to produce
	 * a formatted string of formattedLen characters.
	 * Precondition: wordList contains at least two words, consisting of letters only.
	 * 				 formattedLen is large enough for all the words and gaps.
	 */
	public static int basicGapWidth(List<String> wordList, int formattedLen) {
		int totalGaps = formattedLen - totalLetters(wordList);
		int basicGap = totalGaps / (wordList.size() - 1);
		return basicGap;
	}
	
	/**
	 * Returns the number of leftover spaces when wordList is used to produce
	 * a formatted string of formattedLen characters.
	 * Precondition: wordList contains at least two words, consisting of letters only.
	 * 				 formattedLen is large enough for all the words and gaps.
	 */
	public static int leftoverSpaces(List<String> wordList, int formattedLen) {
		return formattedLen - totalLetters(wordList)
				- basicGapWidth(wordList, formattedLen) * (wordList.size() - 1);
	}
	
	/**
	 * Returns a formatted string consisting of the words in wordList separated by spaces.
	 * Precondition: The wordList contains at least two words,consisting of letters only.
	 * 				 formattedLen is large enough for all the words and gaps.
	 * Postcondition: All words in wordList appear in the formatted string.
	 * 				- The words appear in the same order as in wordList.
	 * 				- The number of spaces between words is determined by basicGapWidth and the
	 * 				  distribution of leftoverSpaces from left to right, as described in the question.
	 */
	public static String format(List<String> wordList, int formattedLen) {
		String formatted = "";
		int gapWidth = basicGapWidth(wordList, formattedLen);
		int leftover = leftoverSpaces(wordList, formattedLen);
		for(int w = 0; w < wordList.size() - 1; w++) {
			formatted += wordList.get(w);
			
			for(int i = 0; i < gapWidth; i++) {
				formatted += " ";
			}
			
			if(leftover > 0) {
				formatted += " ";
				leftover--;
			}
		}
		return formatted + wordList.get(wordList.size()-1);
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		List<String> wordList1 = new ArrayList<>();
		wordList1.add("AP");
		wordList1.add("COMP");
		wordList1.add("SCI");
		wordList1.add("ROCKS");
		System.out.println(format(wordList1, 20));
		
		List<String> wordList2 = new ArrayList<>();
		wordList2.add("GREEN");
		wordList2.add("EGGS");
		wordList2.add("AND");
		wordList2.add("HAM");
		System.out.println(format(wordList2, 20));
		
		List<String> wordList3 = new ArrayList<>();
		wordList3.add("BEACH");
		wordList3.add("BALL");
		System.out.println(format(wordList3, 20));
	}
}
