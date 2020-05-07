package designpatterns.gof.creational.factorymethod.inline;


/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.Factory Pattern giao việc khởi
 * tạo một đối tượng cụ thể cho lớp con.
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class FactoryDemo {
	// 客户端
	public static void main(String[] args) {
		AbstractFactory abstractFactory = null;

		abstractFactory = new ConcreteFacoryA();
		abstractFactory.createProduct().hellow();

		abstractFactory = new ConcreteFactoryB();
		abstractFactory.createProduct().hellow();
	}

	/**
	 * 抽象产品
	 */
	interface Product {
		void hellow();
	}

	/**
	 * 具体产品A
	 */
	static class ConcreteProductA implements Product {

		@Override
		public void hellow() {
			System.out.println("hellow concreteProductA");
		}
	}

	/**
	 * 具体产品B
	 */
	static class ConcreteProductB implements Product {

		@Override
		public void hellow() {
			System.out.println("hellow concreteProductB");
		}
	}

	/**
	 * 抽象工厂
	 */
	interface AbstractFactory {
		Product createProduct();
	}

	/**
	 * 具体工厂A
	 */
	static class ConcreteFacoryA implements AbstractFactory {

		@Override
		public Product createProduct() {
			System.out.println("concreteFacoryA  --> concreteProductA");
			return new ConcreteProductA();
		}
	}

	/**
	 * 具体工厂B
	 */
	static class ConcreteFactoryB implements AbstractFactory {

		@Override
		public Product createProduct() {
			System.out.println("concreteFacoryB  --> concreteProductB");
			return new ConcreteProductB();
		}
	}

}
