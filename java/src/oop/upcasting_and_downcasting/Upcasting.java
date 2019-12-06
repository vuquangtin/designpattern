package upcasting_and_downcasting;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Upcasting {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Animal animal1 = cat;
		// Chuyển kiểu không tường minh
		Animal animal2 = (Animal) cat;
		// Chuyển kiểu tường minh

		cat.eat();
		cat.meow();
		animal1.eat();
		animal2.eat();
		// animal2.meow();
		// Không thể gọi phương thức meow()
	}

}