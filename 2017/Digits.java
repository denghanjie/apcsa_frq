package frq2017;

import java.util.ArrayList;

public class Digits {

	/** 
	 * The list of digits from the number used to construct this object.
	 * The digits appear in the list in the same order in which they appear in the original number. 
	 */
	 private ArrayList<Integer> digitList;
	 
	 /** 
	  * Constructs a Digits object that represents num. * Precondition: num >= 0
	  */
	 public Digits(int num){
		 digitList = new ArrayList<>();
		 while(num > 0) {
			 digitList.add(0, num%10);
			 num /= 10;
		 }
	 }
	 
	 /** 
	  * Returns true if the digits in this Digits object are in strictly increasing order; 
	  * false otherwise.
	  */
	 public boolean isStrictlyIncreasing(){
		 for(int i = 0; i < digitList.size()-1; i++) {
			 if(digitList.get(i) >= digitList.get(i+1)) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 /**
	  * Return a string representation of the digits
	  */
	 public String toString() {
		 return digitList.toString();
	 }
	 
	 /**
	  * For testing use
	  */
	 public static void main(String[] args) {
		 Digits d1 = new Digits(1356);
		 System.out.print(d1 + " Is in increasing order? ");
		 System.out.println(d1.isStrictlyIncreasing());
		 
		 Digits d2 = new Digits(7);
		 System.out.print(d2 + " Is in increasing order? ");
		 System.out.println(d2.isStrictlyIncreasing());
		 
		 Digits d3 = new Digits(1336);
		 System.out.print(d3 + " Is in increasing order? ");
		 System.out.println(d3.isStrictlyIncreasing());
		 
		 Digits d4 = new Digits(1536);
		 System.out.print(d4 + " Is in increasing order? ");
		 System.out.println(d4.isStrictlyIncreasing());
		 
		 Digits d5 = new Digits(65310);
		 System.out.print(d5 + " Is in increasing order? ");
		 System.out.println(d5.isStrictlyIncreasing());
	 }
}
