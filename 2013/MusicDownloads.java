package frq2013;

import java.util.ArrayList;
import java.util.List;

public class MusicDownloads {

	/** The list of downloaded information.
	* Guaranteed not to be null and not to contain duplicate titles. 
	*/
	private List<DownloadInfo> downloadList;
	
	/** Creates the list of downloaded information. */
	public MusicDownloads(){
		downloadList = new ArrayList<DownloadInfo>(); 
	}
	
	/**
	 * Returns a reference to the DownloadInfo object with the requested title if it exists.
	 * @param title the requested title
	 * @return a reference to the DownloadInfo object 
	 * 		   with the title that matches the parameter title if it exists in the list;
	 *         null otherwise.
	 *         
	 * Postcondition: no changes were made to downloadList.
	 */
	public DownloadInfo getDownloadInfo(String title){
		for(DownloadInfo info : downloadList) {
			if(info.getTitle().equals(title))
				return info;
		}
		return null;
	}
	
	/**
	 * Updates downloadList with information from titles.
	 * @param titles a list of song titles
	 * Postcondition:
	 * 	- there are no duplicate titles in downloadList.
	 *  - no entries were removed from downloadList.
	 *  - all songs in titles are represented in downloadList. 
	 *  - for each existing entry in downloadList, the download count is increased by 
	 *  	  the number of times its title appeared in titles.
	 *  - the order of the existing entries in downloadList is not changed.
	 *  - the first time an object with a title from titles is added to downloadList, it
	 *    is added to the end of the list.
	 *  - new entries in downloadList appear in the same order 
	 *    in which they first appear in titles.
	 *  - for each new entry in downloadList, the download count is equal to
	 *    the number of times its title appeared in titles.
	 */
	public void updateDownloads(List<String> titles) {
		for(String title : titles) {
			DownloadInfo info = getDownloadInfo(title);
			if(info != null) {
				info.incrementTimesDownloaded();
			}else {
				DownloadInfo newInfo = new DownloadInfo(title);
				downloadList.add(newInfo);
			}
		}
	}
	
	/**
	 * Return a string representation of MusicDownloads
	 */
	public String toString() {
		if(downloadList.isEmpty()) return "[]";

		StringBuilder res = new StringBuilder();
		res.append("[");
		for(int i = 0; i < downloadList.size()-1; i++) {
			res.append(downloadList.get(i).toString() + ", ");
		}
		res.append(downloadList.get(downloadList.size()-1).toString() + "]");
		return res.toString();
	}
	
	public static void main(String[] args) {
		
		/* initialize downloads object */
		MusicDownloads webMusic = new MusicDownloads();
		initialize(webMusic);
		System.out.println(webMusic);
		
		update(webMusic);
		System.out.println(webMusic);		
	}
	
	private static void initialize(MusicDownloads downloads) {
		List<String> titles = new ArrayList<>();
		titles.add("Hey Jude");
		titles.add("Hey Jude");
		titles.add("Hey Jude");
		titles.add("Hey Jude");
		titles.add("Hey Jude");
		titles.add("Soul Sister");
		titles.add("Soul Sister");
		titles.add("Soul Sister");
		titles.add("Aqualung");
		titles.add("Aqualung");
		titles.add("Aqualung");
		titles.add("Aqualung");
		titles.add("Aqualung");
		titles.add("Aqualung");
		titles.add("Aqualung");
		titles.add("Aqualung");
		titles.add("Aqualung");
		titles.add("Aqualung");

		downloads.updateDownloads(titles);
	}
	
	private static void update(MusicDownloads downloads) {
		List<String> addTitles = new ArrayList<>();
		addTitles.add("Lights");
		addTitles.add("Aqualung");
		addTitles.add("Soul Sister");
		addTitles.add("Go Now");
		addTitles.add("Lights");
		addTitles.add("Soul Sister");
		
		downloads.updateDownloads(addTitles);
	}
}
