package designpatterns.gof.creational.abstractfactory.inline;

/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class AbstractFactoryDemo {
	// Client
	public static void main(String[] args) {
		AbstractFactory huaweiFactory = new ConcreteFactoryA();
		Product1 product1 = huaweiFactory.createProduct1();
		product1.show();
	}

	/**
	 * 抽象工厂
	 */
	interface AbstractFactory {
		Product1 createProduct1();

		Product2 createProduct2();
	}

	/**
	 * 具体工厂A 举例 HUAWEI大厂
	 */
	static class ConcreteFactoryA implements AbstractFactory {

		@Override
		public Product1 createProduct1() {
			System.out.println("HUAWEI 生产 耳机");
			return new ConcreteProductA1();
		}

		@Override
		public Product2 createProduct2() {
			System.out.println("HUAWIE 生产 手机");
			return new ConcreteProductA2();
		}
	}

	/**
	 * 具体工厂B 举例 苹果大厂
	 */
	static class ConcreteFactoryB implements AbstractFactory {

		@Override
		public Product1 createProduct1() {
			System.out.println("APPLE 生产 耳机");
			return new ConcreteProductB1();
		}

		@Override
		public Product2 createProduct2() {
			System.out.println("APPLE 生产 手机");
			return new ConcreteProductB2();
		}
	}

	/**
	 * 抽象产品1 举例： 耳机
	 */
	interface Product1 {
		void show();
	}

	/**
	 * 抽象产品2 举例： 手机
	 */
	interface Product2 {
		void show();
	}

	/**
	 * 具体产品A1 举例： 华为耳机
	 */
	static class ConcreteProductA1 implements Product1 {

		@Override
		public void show() {
			System.out.println(" i am huawei headphone");
		}
	}

	/**
	 * 具体产品B1 举例： 苹果耳机
	 */
	static class ConcreteProductB1 implements Product1 {

		@Override
		public void show() {
			System.out.println(" i am apple headphone");
		}
	}

	/**
	 * 具体产品A2 举例： 华为手机
	 */
	static class ConcreteProductA2 implements Product2 {

		@Override
		public void show() {
			System.out.println(" i am huawei phone ");
		}
	}

	/**
	 * 具体产品B2 举例： 苹果手机
	 */
	static class ConcreteProductB2 implements Product2 {

		@Override
		public void show() {
			System.out.println(" i am iphone ");
		}
	}
}