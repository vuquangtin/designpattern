package com.designpatterns.behavioral.visitor;

interface ComputerPart {
	public void accept(ComputerPartVisitor computerPartVisitor);
}

class Keyboard implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}

class Monitor implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}

class Mouse implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}

class Computer implements ComputerPart {

	ComputerPart[] parts;

	public Computer() {
		parts = new ComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };
	}

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		for (int i = 0; i < parts.length; i++) {
			parts[i].accept(computerPartVisitor);
		}
		computerPartVisitor.visit(this);
	}
}

interface ComputerPartVisitor {
	public void visit(Computer computer);

	public void visit(Mouse mouse);

	public void visit(Keyboard keyboard);

	public void visit(Monitor monitor);
}

class ComputerPartDisplayVisitor implements ComputerPartVisitor {

	@Override
	public void visit(Computer computer) {
		System.out.println("Displaying Computer.");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Displaying Mouse.");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Displaying Keyboard.");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Displaying Monitor.");
	}
}

/***
 * @see https://www.tutorialspoint.com/design_pattern/visitor_pattern.htm
 * @author admin
 *
 */
public class VisitorPatternDemo {
	public static void main(String[] args) {

		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDisplayVisitor());
		Keyboard keyboard = new Keyboard();
		keyboard.accept(new ComputerPartDisplayVisitor());
	}
}