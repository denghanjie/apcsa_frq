package frq2018;

import java.util.ArrayList;

public class WordPairList {
	
	/** The list of word pairs, initialized by the constructor. */
	private ArrayList<WordPair> allPairs;

	/**
	 * Constructs a WordPairList object as described in part (a). 
	 * Precondition: words.length >= 2
	 */
	public WordPairList(String[] words) {
		allPairs = new ArrayList<WordPair>();
		
		for(int i = 0; i < words.length; i++) {
			for(int j = i+1; j < words.length; j++) {
				allPairs.add(new WordPair(words[i], words[j]));
			}
		}
	}

	/** Returns the number of matches as described in part (b). */
	public int numMatches() {
		int count = 0;
		for(WordPair pair : allPairs) {
			if(pair.getFirst().equals(pair.getSecond()))
				count++;
		}
		return count;
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		int count = 0;
		for(WordPair pair : allPairs) {
			res.append(pair.toString() + " ");
			count++;
			
			if(count == 3) {
				count = 0;
				res.append("\n");
			}
		}
		return res.toString();
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		String[] wordList = {"the", "red", "fox", "the", "red"};
		WordPairList pairList = new WordPairList(wordList);
		System.out.println(pairList);
		System.out.println(pairList.numMatches());
	}
	
}
