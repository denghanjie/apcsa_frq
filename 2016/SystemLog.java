package frq2016;

import java.util.ArrayList;
import java.util.List;

public class SystemLog {
	
	/** 
	 * Contains all the entries in this system log.
	 * Guaranteed not to be null and to contain only non-null entries. 
	 */
	private List<LogMessage> messageList;
	
	/**
	 * Construct an empty SystemLog
	 */
	public SystemLog() {
		messageList = new ArrayList<>();
	}
	
	/**
	 * Construct a message list with a list of LogMessage
	 */
	public SystemLog(List<LogMessage> messageList) {
		this.messageList = messageList;
	}
	
	/**
	 * Removes from the system log all entries whose descriptions properly contain keyword, 
	 * and returns a list (possibly empty) containing the removed entries.
	 * Postcondition:
	 * - Entries in the returned list properly contain keyword and
	 * 	 are in the order in which they appeared in the system log.
	 * - The remaining entries in the system log do not properly contain keyword and 
	 * 	 are in their original order.
	 * - The returned list is empty if no messages properly contain keyword.
	 */
	public List<LogMessage> removeMessages(String keyword){
		List<LogMessage> messages = new ArrayList<>();
		for(int i = 0; i < messageList.size(); i++) {
			if(messageList.get(i).containsWord(keyword)) {
				messages.add(messageList.remove(i));
				i--;
			}
		}
		return messages;
	}
	
	/**
	 * Add a LogMessage to SystemLog.
	 */
	public void addLogMessage(LogMessage msg) {
		messageList.add(msg);
	}
	
	/**
	 * Return a string representation of SystemLog object
	 */
	public String toString() {
		if(messageList.isEmpty()) return "[]";

		StringBuilder res = new StringBuilder();
		for(int i = 0; i < messageList.size(); i++) {
			res.append(messageList.get(i) + "\n");
		}
		return res.toString();
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		SystemLog syslog = new SystemLog();
		syslog.addLogMessage(new LogMessage("LogCLIENT3:security alert – repeated login failures"));
	    syslog.addLogMessage(new LogMessage("Webserver:disk offline"));
	    syslog.addLogMessage(new LogMessage("SERVER1:file not found"));
	    syslog.addLogMessage(new LogMessage("SERVER2:read error on disk DSK1"));
	    syslog.addLogMessage(new LogMessage("SERVER1:write error on disk DSK2"));
	    syslog.addLogMessage(new LogMessage("Webserver:error on /dev/disk"));
	    System.out.println(syslog);
	    
	    List<LogMessage> removedMsg = syslog.removeMessages("disk");
	    System.out.println("Removed:\n" + removedMsg);
	    System.out.println("Left:\n" + syslog);
	}
}
