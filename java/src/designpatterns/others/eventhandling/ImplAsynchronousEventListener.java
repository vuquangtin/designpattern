package eventhandling;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ImplAsynchronousEventListener implements AsynchronousEventListener {

	@Override
	public void onAsynchronousEvent() {
		System.out.println("Performing callback after Asynchronous Task");
		// perform some routine operation
	}
	// some class A methods
}