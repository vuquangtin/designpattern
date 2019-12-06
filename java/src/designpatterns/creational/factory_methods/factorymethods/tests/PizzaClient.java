package factorymethods.tests;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
abstract class Pizza {
	public abstract long GetPrice();

	public enum PizzaType {
		HamMushroom, Deluxe, Seafood
	}

	public static Pizza PizzaFactory(PizzaType pizzaType) throws Exception {
		switch (pizzaType) {
		case HamMushroom:
			return new HamAndMushroomPizza();

		case Deluxe:
			return new DeluxePizza();

		case Seafood:
			return new SeafoodPizza();

		}

		throw new Exception("The pizza type " + pizzaType.toString()
				+ " is not recognized.");
	}
}

class HamAndMushroomPizza extends Pizza {
	private long price = 8;

	public long GetPrice() {
		return price;
	}
}

class DeluxePizza extends Pizza {
	private long price = 10;

	public long GetPrice() {
		return price;
	}
}

class SeafoodPizza extends Pizza {
	private long price = 11;

	public long GetPrice() {
		return price;
	}
}

public class PizzaClient {
}