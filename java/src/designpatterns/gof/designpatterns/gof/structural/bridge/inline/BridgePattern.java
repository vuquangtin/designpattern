package designpatterns.gof.structural.bridge.inline;

/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
interface AbstractInterface {
	/* Implemented interface. */
	public void someFunctionality();
}

/* Interface for internal implementation that Bridge uses. */
interface ImplementationInterface {
	public void anotherFunctionality();
}

/* The Bridge */
class Bridge implements AbstractInterface {
	protected ImplementationInterface implementation;

	public Bridge(ImplementationInterface backend) {
		implementation = backend;
	}

	@Override
	public void someFunctionality() {
		// TODO Auto-generated method stub

	}
};

/* Different special cases of the interface. */

class UseCase1 extends Bridge {
	public UseCase1(ImplementationInterface backend) {
		super(backend);

	}

	public void someFunctionality() {
		System.out.println("UseCase1 on ");
		implementation.anotherFunctionality();
	}
};

class UseCase2 extends Bridge {
	public UseCase2(ImplementationInterface backend) {
		super(backend);
	}

	public void someFunctionality() {
		System.out.println("UseCase2 on ");
		implementation.anotherFunctionality();
	}
}

/* Different background implementations. */

class Windows implements ImplementationInterface {
	public void anotherFunctionality() {
		System.out.println("Windows");
	}
}

class Linux implements ImplementationInterface {
	public void anotherFunctionality() {
		System.out.println("Linux!");
	}
}

public class BridgePattern {
	public static void main(String[] args) {
		AbstractInterface useCase;
		ImplementationInterface osWindows = new Windows();
		ImplementationInterface osLinux = new Linux();

		/* First case */
		useCase = new UseCase1(osWindows);
		useCase.someFunctionality();

		useCase = new UseCase1(osLinux);
		useCase.someFunctionality();

		/* Second case */
		useCase = new UseCase2(osWindows);
		useCase.someFunctionality();

		useCase = new UseCase2(osLinux);
		useCase.someFunctionality();

		// return 0;
	}
}