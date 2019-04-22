package frq2013;

public class DownloadInfo {

	/** Creates a new instance with the given unique title and sets the
	* number of times downloaded to 1.
	* @param title the unique title of the downloaded song
	*/
	public DownloadInfo(String title){
		this.title = title;
		downloadTimes = 1;
	}
	
	/** @return the title */
	public String getTitle(){
		return title;
	}
	
	/** Increment the number times downloaded by 1 */ 
	public void incrementTimesDownloaded() {
		downloadTimes++;
	}
	
	public String toString() {
		return "(" + title + ", " + downloadTimes + ")";
	}
	
	/*instance variables*/
	private String title;
	private int downloadTimes;
}
