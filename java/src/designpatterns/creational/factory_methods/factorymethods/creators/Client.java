package factorymethods.creators;

/**
 * Design Patterns
 * 
 * @see http
 *      ://www.itsenka.com/contents/development/designpattern/factory_method.
 *      html
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();
		Product product = creator.factoryMethod();
		product.method1();
		product.method2();
	}
}