package open_closed;

import java.util.ArrayList;



/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Main {
	public void draw(ArrayList<Shape> shapeList) {
		for (Shape s : shapeList)
			s.draw();
	}

	public void doSomething(Vehicle vehicle) {
		Car car = (Car) vehicle;
		car.run();
		car.stop();
	}

	public void doSomething(Car car) {
		car.run();
		car.stop();
	}

	public void doSomethingForVehicle(Vehicle vehicle) {
		vehicle.run();
		vehicle.stop();
	}
}
