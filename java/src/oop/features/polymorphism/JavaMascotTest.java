package features.polymorphism;

/**
 * <h1>Interfaces and inheritance in polymorphism</h1> With this Java
 * Challenger, we are focusing on the relationship between polymorphism and
 * inheritance. The main thing to keep in mind is that polymorphism requires
 * inheritance or interface implementation. You can see this in the example
 * below, featuring Duke and Juggy:
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
abstract class JavaMascot {
	public abstract void executeAction();
}

class Duke extends JavaMascot {
	@Override
	public void executeAction() {
		System.out.println("Punch!");
	}
}

class Juggy extends JavaMascot {
	@Override
	public void executeAction() {
		System.out.println("Fly!");
	}
}

public class JavaMascotTest {
	public static void main(String... args) {
		JavaMascot dukeMascot = new Duke();
		JavaMascot juggyMascot = new Juggy();
		dukeMascot.executeAction();
		juggyMascot.executeAction();
	}
}