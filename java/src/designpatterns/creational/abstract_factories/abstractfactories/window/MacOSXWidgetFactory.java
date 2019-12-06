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
// ConcreteFactory2
public class MacOSXWidgetFactory implements AbstractWidgetFactory {
	// create a MacOSXWindow
	public Window createWindow() {
		MacOSXWindow window = new MacOSXWindow();
		return window;
	}
}
