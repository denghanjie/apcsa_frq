package frq2016;

import java.util.ArrayList;

public class RandomStringChooser {

	/*instance variables*/
	private ArrayList<String> wordList;
	
	/**Constructor*/
	public RandomStringChooser(String[] wordArray) {
		wordList = new ArrayList<>();
		for(String word : wordArray) {
			wordList.add(word);
		}
	}
	
	/**
	 * Return a randomly chosen string from the available strings in the object.
	 * Once a particular string has been returned from a call to getNext, it is 
	 * no longer available to be returned from subsequent calls to getNext. 
	 * If no strings are available to be returned, returns "NONE".
	 */
	public String getNext() {
		if(wordList.size() > 0) {
			int randomIndex = (int)(Math.random()*wordList.size());
			String word = wordList.get(randomIndex);
			wordList.remove(randomIndex);
			return word;
		}
		
		return "None";
	}
	
	/**
	 * For testing use.
	 */
	public static void main(String[] args) {
		String[] wordArray = {"wheels", "on", "the", "bus"};
	    RandomStringChooser sChooser = new RandomStringChooser(wordArray);
	    for (int k = 0; k < 6; k++){
	       System.out.print(sChooser.getNext() + " ");
	    }
	}
}
