package com.principles.openclosed;

import java.util.ArrayList;

import com.designpatterns.behavioral.strategy.Car;
import com.designpatterns.behavioral.strategy.Vehicle;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
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
    public void doSomethingForVehicle(Vehicle vehicle)
    {
    	vehicle.run(); 
    	vehicle.stop();
    }
}
