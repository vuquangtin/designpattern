package builders.pizza;

import java.util.ArrayList;

/**
 * <h1>Builder</h1> Tách rời việc xây dựng (khởi tạo) của một đối tượng phức tạp
 * khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng (khởi tạo) có
 * thể tạo ra các biểu diễn khác nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
abstract public class PizzaBuilder {

	protected ArrayList<String> ingredients;
	protected String name;
	protected int price;
	protected Pizza pizza;

	public Pizza getPizza() {
		return new Pizza(this);
	}

	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<String> getIngredients() {
		return this.ingredients;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}
}