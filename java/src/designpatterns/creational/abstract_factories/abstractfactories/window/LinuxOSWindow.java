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
public class LinuxOSWindow implements Window {
	public void setTitle(String text) {
		// Mac OSX specific behaviour
		System.out.println("LinuxOS:" + text);
	}

	public void repaint() {
		// Mac OSX specific behaviour
	}
}