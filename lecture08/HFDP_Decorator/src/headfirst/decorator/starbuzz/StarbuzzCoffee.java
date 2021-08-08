package headfirst.decorator.starbuzz;

public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		// -------------------------- 
		// Espresso $1.99
		// -------------------------- 
		// Mocha: beverage.cost() is: 0.99
		// - adding One Mocha cost of 0.20c 
		// - new cost is: 1.19
		// Mocha: beverage.cost() is: 1.19
		// - adding One Mocha cost of 0.20c 
		// - new cost is: 1.39
		// Whipe: beverage.cost() is: 1.39
		// - adding One Whip cost of 0.10c 
		// - new cost is: 1.49
		// Dark Roast Coffee, Mocha, Mocha, Whip $1.49
		// -------------------------- 
		// Soy: beverage.cost() is: 0.89
		// - adding One Soy cost of 0.15c 
		// - new cost is: 1.04
		// Mocha: beverage.cost() is: 1.04
		// - adding One Mocha cost of 0.20c 
		// - new cost is: 1.24
		// Whipe: beverage.cost() is: 1.24
		// - adding One Whip cost of 0.10c 
		// - new cost is: 1.34
		// House Blend Coffee, Soy, Mocha, Whip $1.34
		// -------------------------- 
		
		System.out.println("-------------------------- ");

		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() 
				+ " $" + beverage.cost());
		System.out.println("-------------------------- ");
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + beverage2.cost());
		
		System.out.println("-------------------------- ");
 
		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() 
				+ " $" + beverage3.cost());
		System.out.println("-------------------------- ");
		
		
	}
}
