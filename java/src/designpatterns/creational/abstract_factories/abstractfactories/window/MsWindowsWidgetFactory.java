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

// ConcreteFactory1
public class MsWindowsWidgetFactory implements AbstractWidgetFactory{
	// create an MSWindow
	public Window createWindow() {
		MSWindow window = new MSWindow();
		return window;
	}
}