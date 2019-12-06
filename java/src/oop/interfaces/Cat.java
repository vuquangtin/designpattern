package interfaces;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
class Cat implements Animal {
	public void makeSound() {
		System.out.println("Meow");
	}

	public void eat() {
		System.out.println("omnomnom");
	}
}