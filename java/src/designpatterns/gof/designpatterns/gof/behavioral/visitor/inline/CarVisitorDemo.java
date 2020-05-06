package designpatterns.gof.behavioral.visitor.inline;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class CarVisitorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ---------------------------------------------------------------
		// Create Element object
		// ---------------------------------------------------------------
		Car hondaCity = new Car();
		Car toyotaCorolla = new Car();
		Truck mercedesTruck = new Truck();
		// Truck
		List<Car> cars = new ArrayList();
		List<Truck> trucks = new ArrayList();
		cars.add(hondaCity);
		cars.add(toyotaCorolla);
		// trucks

		// ---------------------------------------------------------------
		// Create collection of Visitors
		// ---------------------------------------------------------------
		List<IVisitor> myVisitors = new ArrayList<IVisitor>();
		myVisitors.add(new SerialNoVisitor());
		myVisitors.add(new PaintVisitor());

		// ---------------------------------------------------------------
		// Do the visiting, transparently achieves double-dispatch
		// ---------------------------------------------------------------
		for (IVisitor myVisitor : myVisitors) {
			for (Car car : cars) {
				car.accept(myVisitor);
			}
			for (Truck truck : trucks) {
				truck.accept(myVisitor);
			}
		}

		for (IVisitor myVisitor : myVisitors) {
			for (Car car : cars) {
				myVisitor.visitCarPart(car);
			}
			for (Truck truck : trucks) {
				myVisitor.visitTruck(truck);
			}
		}
	}
}

interface ICarPart {
	public void accept(IVisitor visitor);
}

class Body implements ICarPart {
	public void accept(IVisitor visitor) {
		visitor.visitCarPart(this);
	}
}

class Engine implements ICarPart {
	public void accept(IVisitor visitor) {
		visitor.visitCarPart(this);
	}

}

class Car implements ICarPart {

	private final Engine engine = new Engine();
	private final Body body = new Body();
	private final Wheel[] wheels = { new Wheel("front left"),
			new Wheel("front right"), new Wheel("rear left"),
			new Wheel("rear left") };

	public Engine getEngine() {
		return engine;
	}

	public Body getBody() {
		return body;
	}

	public Wheel[] getWheels() {
		return wheels;
	}

	public void accept(IVisitor visitor) {

		visitor.visitCarPart(this);
	}

}

class Wheel implements ICarPart {
	private String name;

	public Wheel(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void accept(IVisitor visitor) {
		visitor.visitCarPart(this);
	}

}

class Truck {
	public void accept(IVisitor visitor) {
		visitor.visitTruck(this);
	}
}

interface IVisitor {
	public void visitCarPart(Car car);

	public void visitCarPart(ICarPart car);

	public void visitTruck(Truck truck);
}

// Visitor 1
class SerialNoVisitor implements IVisitor {

	@Override
	public final void visitCarPart(Car car) {
		// get car number
		// insert into a database -- > car has been updated
		System.out.println("Imprinting the serial no. on carpart " + car);
	}

	@Override
	public void visitTruck(Truck truck) {

		// get car number
		// insert into a database -- > car has been updated
		// TODO Auto-generated method stub

	}

	@Override
	public void visitCarPart(ICarPart car) {
		// TODO Auto-generated method stub

	}
}

// Visitor 2
class PaintVisitor implements IVisitor {
	@Override
	public final void visitCarPart(Car car) {
		System.out.println("Imprinting the serial no. on carpart " + car);
	}

	@Override
	public void visitTruck(Truck truck) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitCarPart(ICarPart car) {
		// TODO Auto-generated method stub

	}
}