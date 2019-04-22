package frq2015;

import java.util.ArrayList;
import java.util.List;

public class MultipleGroups implements NumberGroup{

	/* instance variable */
	private List<NumberGroup> groupList;
	
	/** constructs */
	public MultipleGroups() {
		groupList = new ArrayList<>();
	}
	
	/** check if num is included in any one of the NumberGroup. */
	public boolean contains(int num) {
		for(NumberGroup ng : groupList) {
			if(ng.contains(num))
				return true;
		}
		return false;
	}
	
	/**
	 * For testing's use
	 */
	public void addGroup(NumberGroup ng) {
		groupList.add(ng);
	}
	
	/**
	 * Testing Method
	 */
	public static void main(String[] args) {
		NumberGroup group1 = new Range(5, 8);
		NumberGroup group2 = new Range(10, 12);
		NumberGroup group3 = new Range(1, 6);
		
		MultipleGroups groups = new MultipleGroups();
		groups.addGroup(group1);
		groups.addGroup(group2);
		groups.addGroup(group3);
		
		System.out.println(groups.contains(2));
		System.out.println(groups.contains(9));
		System.out.println(groups.contains(6));
	}
}
