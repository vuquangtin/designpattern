package lazyloading.lazy_initialization;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Program {
	public static void main(String[] args) {
		Car.getCarByTypeName(CarType.BMW);
		Car.showAll();
		Car.getCarByTypeName(CarType.Audi);
		Car.showAll();
		Car.getCarByTypeName(CarType.BMW);
		Car.showAll();
	}
}