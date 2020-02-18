package decorators.gof;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Main {
	public static void printInfo(Coffee c) {
		System.out.println("Cost: " + c.getCost() + "; Ingredients: "
				+ c.getIngredients());
	}

	public static void main(String[] args) {
		Coffee c = new SimpleCoffee();
		printInfo(c);

		c = new WithMilk(c);
		printInfo(c);

		c = new WithSprinkles(c);
		printInfo(c);
	}
}

// Decorator WithMilk mixes milk into coffee.
// Note it extends CoffeeDecorator.
class WithMilk extends CoffeeDecorator {
	public WithMilk(Coffee c) {
		super(c);
	}

	@Override
	public double getCost() { // Overriding methods defined in the abstract
								// superclass
		return super.getCost() + 0.5;
	}

	@Override
	public String getIngredients() {
		return super.getIngredients() + ", Milk";
	}
}

// Decorator WithSprinkles mixes sprinkles onto coffee.
// Note it extends CoffeeDecorator.
class WithSprinkles extends CoffeeDecorator {
	public WithSprinkles(Coffee c) {
		super(c);
	}

	@Override
	public double getCost() {
		return super.getCost() + 0.2;
	}

	@Override
	public String getIngredients() {
		return super.getIngredients() + ", Sprinkles";
	}
}
