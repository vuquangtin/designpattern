package abstractfactories.window;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
// ConcreteProductA1
public class MSWindow implements Window {
	public void setTitle(String text) {
		System.out.println("MSWindow:" + text);
	}

	public void repaint() {
		// MS Windows specific behaviour
	}

}