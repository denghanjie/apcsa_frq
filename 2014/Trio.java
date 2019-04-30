package frq2014;

public class Trio implements MenuItem{
	
	/*instance variables*/
	private Sandwich sandwich;
	private Salad salad;
	private Drink drink;
	
	/**
	 * Construct a Trio object.
	 */
	public Trio(Sandwich sandwich, Salad salad, Drink drink) {
		this.sandwich = sandwich;
		this.salad = salad;
		this.drink = drink;
	}
	
	/** @return the name of the menu item */ 
	public String getName() {
		return sandwich.getName() + "/" 
				+ salad.getName() + "/"
				+ drink.getName() + " "
				+ "Trio";
	}
	
	/** @return the price of the menu item */
	public double getPrice() {
		return sandwich.getPrice() 
				+ salad.getPrice() 
				+ drink.getPrice() 
				- getLowestPriceItem();
	}
	
	private double getLowestPriceItem() {
		double lowest = sandwich.getPrice();
		if(lowest > salad.getPrice())
			lowest = salad.getPrice();
		if(lowest > drink.getPrice())
			lowest = drink.getPrice();
		return lowest;
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		Sandwich cheeseBurger = new Sandwich("Cheeseburger", 2.75);
		Sandwich clubSandwich = new Sandwich("Club Sandwich", 2.75);
		
		Salad spinach = new Salad("Spinach Salad", 1.25);
		Salad coleslaw = new Salad("Coleslaw", 1.25);
		
		Drink orangeSoda = new Drink("Orange Soda", 1.25);
		Drink cappuccino = new Drink("Cappuccino", 3.50);
		
		Trio trio1 = new Trio(cheeseBurger, spinach, orangeSoda);
		Trio trio2 = new Trio(clubSandwich, coleslaw, cappuccino);
		System.out.println(trio1.getName() + " $" + trio1.getPrice());
		System.out.println(trio2.getName() + " $" + trio2.getPrice());
	}
}
