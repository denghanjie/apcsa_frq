package frq2014;

public class Sandwich implements MenuItem{

	/*instance variables*/
	private String name;
	private double price;
	
	/**
	 * Constructs a Sandwich object.
	 */
	public Sandwich(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	/** @return the name of the menu item */ 
	public String getName() {
		return name;
	}
	
	/** @return the price of the menu item */
	public double getPrice() {
		return price;
	}
}
