package features.polymorphism;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>What’s the purpose of polymorphism?</h1> The great advantage and purpose
 * of using polymorphism is to decouple the client class from implementation
 * code. Instead of being hard-coded, the client class receives the
 * implementation to execute the necessary action. In this way, the client class
 * know just enough to execute its actions, which is an example of loose
 * coupling.
 * 
 * To better understand the purpose of polymorphism, take a look at the
 * SweetCreator:
 * 
 * <br/>
 * In this example, you can see that the SweetCreator class only knows the
 * SweetProducer class. It doesn’t know the implementation of each Sweet. That
 * separation gives us flexibility to update and re-use our classes, and it
 * makes the code much easier to maintain. When designing your code, always look
 * for ways to make it as flexible and maintainable as possible. polymorphism is
 * a very powerful technique to use for these purposes.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
abstract class SweetProducer {
	public abstract void produceSweet();
}

class CakeProducer extends SweetProducer {
	@Override
	public void produceSweet() {
		System.out.println("Cake produced");
	}
}

class ChocolateProducer extends SweetProducer {
	@Override
	public void produceSweet() {
		System.out.println("Chocolate produced");
	}
}

class CookieProducer extends SweetProducer {
	@Override
	public void produceSweet() {
		System.out.println("Cookie produced");
	}
}

class SweetCreator {
	private List<SweetProducer> sweetProducer;

	public SweetCreator(List<SweetProducer> sweetProducer) {
		this.sweetProducer = sweetProducer;
	}

	public void createSweets() {
		sweetProducer.forEach(sweet -> sweet.produceSweet());
	}
}

public class SweetCreatorTest {
	public static void main(String... args) {
		SweetCreator sweetCreator = new SweetCreator(
				Arrays.asList(new CakeProducer(), new ChocolateProducer(), new CookieProducer()));
		sweetCreator.createSweets();
	}
}