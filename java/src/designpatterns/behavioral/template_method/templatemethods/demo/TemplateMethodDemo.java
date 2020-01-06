package templatemethods.demo;

/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template
 * Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà
 * không phải thay đổi cấu trúc thuật toán. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
abstract class Generalization {
	// 1. Standardize the skeleton of an algorithm in a "template" method
	void findSolution() {
		stepOne();
		stepTwo();
		stepThr();
		stepFor();
	}

	// 2. Common implementations of individual steps are defined in base class
	private void stepOne() {
		System.out.println("Generalization.stepOne");
	}

	// 3. Steps requiring peculiar implementations are "placeholders" in the
	// base class
	abstract void stepTwo();

	abstract void stepThr();

	void stepFor() {
		System.out.println("Generalization.stepFor");
	}
}

abstract class Specialization extends Generalization {
	// 4. Derived classes can override placeholder methods
	// 1. Standardize the skeleton of an algorithm in a "template" method
	protected void stepThr() {
		step3_1();
		step3_2();
		step3_3();
	}

	// 2. Common implementations of individual steps are defined in base class
	private void step3_1() {
		System.out.println("Specialization.step3_1");
	}

	// 3. Steps requiring peculiar implementations are "placeholders" in the
	// base class
	abstract protected void step3_2();

	private void step3_3() {
		System.out.println("Specialization.step3_3");
	}
}

class Realization extends Specialization {
	// 4. Derived classes can override placeholder methods
	protected void stepTwo() {
		System.out.println("Realization.stepTwo");
	}

	protected void step3_2() {
		System.out.println("Realization.step3_2");
	}

	// 5. Derived classes can override implemented methods
	// 6. Derived classes can override and "call back to" base class methods
	protected void stepFor() {
		System.out.println("Realization.stepFor");
		super.stepFor();
	}
}

public class TemplateMethodDemo {
	public static void main(String[] args) {
		Generalization algorithm = new Realization();
		algorithm.findSolution();
	}
}
