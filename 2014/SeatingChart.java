package frq2014;

import java.util.ArrayList;
import java.util.List;

public class SeatingChart {

	/** seats[r][c] represents the Student in row r and column c in the classroom. */ 
	private Student[][] seats;
	
	/**
	 * Creates a seating chart with the given number of rows and columns from the students in
	 * studentList. Empty seats in the seating chart are represented by null.
	 * @param rows the number of rows of seats in the classroom
	 * @param cols the number of columns of seats in the classroom
	 * Precondition: rows > 0; cols > 0;
	 * 				 rows * cols >= studentList.size()
	 * Postcondition:
	 * 	- Students appear in the seating chart in the same order as they appear
	 * 	  in studentList, starting at seats[0][0].
	 *  - seats is filled column by column from studentList, followed by any
	 *    empty seats (represented by null).
	 *  - studentList is unchanged.
	 */
	public SeatingChart(List<Student> studentList, int rows, int cols) {
		seats = new Student[rows][cols];
		int index = 0;
		for(int col = 0; col < cols; col++) {
			for(int row = 0; row < rows; row++) {
				if(index < studentList.size()) {
					seats[row][col] = studentList.get(index);
					index++;
				}
			}
		}
	}
		
	/**
	 * Removes students who have more than a given number of absences from the
	 * seating chart, replacing those entries in the seating chart with null
	 * and returns the number of students removed.
	 * @param allowedAbsences an integer >= 0
	 * @return number of students removed from seats
	 * Postcondition:
	 * 	- All students with allowedAbsences or fewer are in their original positions in seats.
	 * 	- No student in seats has more than allowedAbsences absences.
	 *  - Entries without students contain null.
	 */
	public int removeAbsentStudents(int allowedAbsences) {
		int count = 0;
		for(int r = 0; r < seats.length; r++) {
			for(int c = 0; c < seats[0].length; c++) {
				if(seats[r][c] != null && seats[r][c].getAbsenceCount() > allowedAbsences) {
					seats[r][c] = null;
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Return a 2D representation of seating.
	 */
	public String toString() {
		if(seats == null) return "[[]]";
		
		StringBuilder res = new StringBuilder();
		for(int r = 0; r < seats.length; r++) {
			res.append("[");
			for(int c = 0; c < seats[r].length-1; c++) {
				res.append(seats[r][c] + ", ");
			}
			res.append(seats[r][seats[r].length-1] + "]\n");
		}
		return res.toString();
	}
	
	/**
	 * For testing use.
	 */
	public static void main(String[] args) {
		List<Student> roster = new ArrayList<>();
		roster.add(new Student("Karen", 3));
		roster.add(new Student("Liz", 1));
		roster.add(new Student("Paul", 4));
		roster.add(new Student("Lester", 1));
		roster.add(new Student("Henry", 5));
		roster.add(new Student("Renee", 9));
		roster.add(new Student("Glen", 2));
		roster.add(new Student( "Fran", 6));
		roster.add(new Student("David", 1));
		roster.add(new Student("Danny", 3));
		
		SeatingChart introCS = new SeatingChart(roster, 3, 4);
		System.out.println(introCS);
		
		System.out.println("Removed " + introCS.removeAbsentStudents(4) + " students.");
		System.out.println(introCS);
	}
}
