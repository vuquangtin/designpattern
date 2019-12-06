package features;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.println("Hello, I'm " + super.getName());
	}

}