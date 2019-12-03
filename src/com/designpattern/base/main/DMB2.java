package com.designpattern.base.main;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
// Listing 3. DMB2.java
// DMB2.java
interface StartStop {
	void start();

	void stop();
}

class Conference implements StartStop {
	public void start() {
		System.out.println("Start the conference.");
	}

	public void stop() {
		System.out.println("Stop the conference.");
	}
}

class PoliticalConvention extends Conference {
	public void start() {
		System.out.println("Introduce the guest speaker.");
	}

	public void stop() {
		System.out.println("Grab some refreshments.");
	}
}

class Vehicle implements StartStop {
	public void start() {
	}

	public void stop() {
	}
}

class Car extends Vehicle {
	public void start() {
		System.out.println("Insert key in ignition and turn.");
	}

	public void stop() {
		System.out.println("Turn key in ignition and remove.");
	}
}

class LawnMower extends Vehicle {
	public void start() {
		System.out.println("Move sliding switch to on and pull cord.");
	}

	public void stop() {
		System.out.println("Move sliding switch to off.");
	}
}

class DMB2 {
	public static void main(String[] args) {
		Vehicle v = new LawnMower();
		StartStop[] ss = { new Car(), v, new PoliticalConvention(),
				new Conference() };
		for (int i = 0; i < ss.length; i++) {
			ss[i].start();
			ss[i].stop();
			System.out.println("");
		}
	}
}

class Rectangle {

	public static final int Area = 0;

	public void setWidth(int i) {
		// TODO Auto-generated method stub

	}

	// Data members of rectangle...
	// Member functions of rectangle...

	public void setHeight(int i) {
		// TODO Auto-generated method stub
		
	}
}

class Square extends Rectangle {
	// Data members of square...
	// Member functions of square...

	double doSomething(Rectangle obj) {
		obj.setWidth(5);
		obj.setHeight(6);
		//if (Rectangle.Area == 30)
		//	return Rectangle.Area;
		throw new IllegalArgumentException();
	}
}
class Employee
{
    String position;
    void developSoftware(){};
    void testSoftware(){};
    void saleSoftware(){};
}