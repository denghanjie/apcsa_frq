package frq2014;

public class Student {
	
	/*instance variable*/
	private String name;
	private int absenceCount;
	
	/**Construct a Student object.*/
	public Student(String name, int count) {
		this.name = name;
		this.absenceCount = count;
	}
	
	/**ReturnsthenameofthisStudent. */ 
	public String getName(){
		return name;
	}
	
	/**ReturnsthenumberoftimesthisStudenthasmissedclass. */ 
	public int getAbsenceCount(){ 
		return absenceCount;
	}
	
	/**Return a string representation of a student object.*/
	public String toString() {
		return "(" + name + ", " + absenceCount + ")";
	}
}
