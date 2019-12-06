package abstractfactories.gof.products;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Design Patterns
 * 
 * @see http
 *      ://www.itsenka.com/contents/development/designpattern/abstract_factory
 *      .html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		List<AbstractFactory> factorys = new ArrayList<AbstractFactory>();
		factorys.add(AbstractFactory.createFactory(ConcreteFactoryA.id));
		factorys.add(AbstractFactory.createFactory(ConcreteFactoryB.id));
		Iterator<AbstractFactory> it = factorys.iterator();
		while (it.hasNext()) {
			AbstractFactory factory = it.next();
			AbstractProduct1 product1 = factory.createProduct1();
			AbstractProduct2 product2 = factory.createProduct2();
			AbstractProduct3 product3 = factory.createProduct3();
			product1.execute();
			product2.run();
			product3.action();
		}
	}
}

abstract class AbstractProduct1 {
	protected String name;

	public AbstractProduct1(String name) {
		this.name = name;
	}

	public abstract void execute();
}

abstract class AbstractProduct2 {
	protected String name;

	public AbstractProduct2(String name) {
		this.name = name;
	}

	public abstract void run();
}

abstract class AbstractProduct3 {
	protected String name;

	public AbstractProduct3(String name) {
		this.name = name;
	}

	public abstract void action();
}

class ConcreteProductA1 extends AbstractProduct1 {
	public ConcreteProductA1(String name) {
		super(name);
	}

	public void execute() {
		System.out.println(name + " 完成(A1-execute)！");
	}
}

class ConcreteProductA2 extends AbstractProduct2 {
	public ConcreteProductA2(String name) {
		super(name);
	}

	public void run() {
		System.out.println(name + " 完成(A2-run)！");
	}
}

class ConcreteProductA3 extends AbstractProduct3 {
	public ConcreteProductA3(String name) {
		super(name);
	}

	public void action() {
		System.out.println(name + " 完成(A3-action)！");
	}
}

class ConcreteProductB1 extends AbstractProduct1 {
	public ConcreteProductB1(String name) {
		super(name);
	}

	public void execute() {
		System.out.println(name + " 完成(B1-execute)！");
	}
}

class ConcreteProductB2 extends AbstractProduct2 {
	public ConcreteProductB2(String name) {
		super(name);
	}

	public void run() {
		System.out.println(name + " 完成(B2-run)！");
	}
}

class ConcreteProductB3 extends AbstractProduct3 {
	public ConcreteProductB3(String name) {
		super(name);
	}

	public void action() {
		System.out.println(name + " 完成(B3-action)！");
	}
}

abstract class AbstractFactory {
	public static AbstractFactory createFactory(int factoryId) {
		switch (factoryId) {
		case ConcreteFactoryA.id:
			return new ConcreteFactoryA();
		case ConcreteFactoryB.id:
			return new ConcreteFactoryB();
		default:
			return null;
		}
	}

	public abstract AbstractProduct1 createProduct1();

	public abstract AbstractProduct2 createProduct2();

	public abstract AbstractProduct3 createProduct3();
}

class ConcreteFactoryA extends AbstractFactory {
	public static final int id = 1;

	public AbstractProduct1 createProduct1() {
		return new ConcreteProductA1("工場A - 製品1");
	}

	public AbstractProduct2 createProduct2() {
		return new ConcreteProductA2("工場A - 製品2");
	}

	public AbstractProduct3 createProduct3() {
		return new ConcreteProductA3("工場A - 製品3");
	}
}

class ConcreteFactoryB extends AbstractFactory {
	public static final int id = 2;

	public AbstractProduct1 createProduct1() {
		return new ConcreteProductB1("工場B - 製品1");
	}

	public AbstractProduct2 createProduct2() {
		return new ConcreteProductB2("工場B - 製品2");
	}

	public AbstractProduct3 createProduct3() {
		return new ConcreteProductB3("工場B - 製品3");
	}
}