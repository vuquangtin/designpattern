package facades.gof;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Facade {

	public String makeCoffee() {
		Sugar s = new Sugar();
		Caffeine c = new Caffeine();
		Water w = new Water();

		return "Coffee = " + w.addWater() + " + " + c.addCaffeine() + " + "
				+ s.addSugar();
	}
}