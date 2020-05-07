package designpatterns.gof.creational.factorymethod.pattern;


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
public class Client {
	public static void main(String[] args) {
		ConcreteCreator concreteCreator = new ConcreteCreator();
		ProductA productA = concreteCreator.createProduct(ProductA.class);
		productA.pubMethod();
		productA.method();
		ProductB productB = concreteCreator.createProduct(ProductB.class);
		productB.pubMethod();
		productB.method();
	}
}
