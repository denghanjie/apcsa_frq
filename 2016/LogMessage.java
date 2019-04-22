package frq2016;

public class LogMessage {

	 private String machineId;
	 private String description;
	 
	 /** Precondition: message is a valid log message. */ 
	 public LogMessage(String message){ 
		 int colonIndex = message.indexOf(":");
		 machineId = message.substring(0,colonIndex);
		 description = message.substring(colonIndex+1);
	 }
	 
	 /** 
	  * Returns true if the description in this log message properly contains keyword;
	  * false otherwise.
	  */
	 public boolean containsWord(String keyword){
		 if(description.equals(keyword)) return true;  // completely equal
		 if(description.indexOf(keyword+" ") == 0) return true;  // at the beginning
		 if(description.indexOf(" " + keyword + " ") >= 0) return true; // in the middle
		 if(description.length() > keyword.length() &&
				 description.substring(description.length()-keyword.length()-1).equals(" " + keyword)) {
			 return true;
		 } // at the end
		 return false;
	 }
	 
	 public String getMachineId() {
		 return machineId;
	 }
	 
	 public String getDescription() {
		 return description;
	 }
	 
	 public String toString() {
		 return machineId + ":" + description;
	 }
	 
	 /**
	  * For testing use
	  */
	 public static void main(String[] args) {
		 LogMessage msg1 = new LogMessage("msg1:disk");
		 LogMessage msg2 = new LogMessage("msg2:error on disk");
		 LogMessage msg3 = new LogMessage("msg3:error on /dev/disk disk");
		 LogMessage msg4 = new LogMessage("msg4:error on disk DSK1");
		 System.out.println("msg1: " + msg1.containsWord("disk"));
		 System.out.println("msg2: " + msg2.containsWord("disk"));
		 System.out.println("msg3: " + msg3.containsWord("disk"));
		 System.out.println("msg4: " + msg4.containsWord("disk"));
		 
		 LogMessage msg5 = new LogMessage("msg5:DISK");
		 LogMessage msg6 = new LogMessage("msg6:error on disk3");
		 LogMessage msg7 = new LogMessage("msg7:error on /dev/disk");
		 LogMessage msg8 = new LogMessage("msg8:diskette");
		 System.out.println("msg5: " + msg5.containsWord("disk"));
		 System.out.println("msg6: " + msg6.containsWord("disk"));
		 System.out.println("msg7: " + msg7.containsWord("disk"));
		 System.out.println("msg8: " + msg8.containsWord("disk"));
	 }
}
