package frq2018;

public class CodeWordChecker implements StringChecker{
	
	/*constants*/
	private static final int DEFAULT_MIN_LENGTH = 6;
	private static final int DEFAULT_MAX_LENGTH = 20;
	
	/*instance variable*/
	private String code;
	private int minLen;
	private int maxLen;
	
	/**Construct a CodeWordChecker with a minimum length, maximum length and a code to check.*/
	public CodeWordChecker(int min, int max, String code) {
		minLen = min;
		maxLen = max;
		this.code = code;
	}
	
	/**Construct a CodeWordChecker with a code to check.*/
	public CodeWordChecker(String code) {
		minLen = DEFAULT_MIN_LENGTH;
		maxLen = DEFAULT_MAX_LENGTH;
		this.code = code;
	}
	
	/** Returns true if str is valid. */
	public boolean isValid(String str) {
		return str.length() >= minLen &&
				str.length() <= maxLen && 
				str.indexOf(code) == -1;
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		StringChecker sc1 = new CodeWordChecker(5, 8, "$");
		System.out.println(sc1.isValid("happy"));
		System.out.println(sc1.isValid("happy$"));
		System.out.println(sc1.isValid("Code"));
		System.out.println(sc1.isValid("happyCode"));
		
		StringChecker sc2 = new CodeWordChecker("pass");
		System.out.println(sc2.isValid("MyPass"));
		System.out.println(sc2.isValid("Mypassport"));
		System.out.println(sc2.isValid("happy"));
		System.out.println(sc2.isValid("1,000,000,000,000,000"));
	}
}
