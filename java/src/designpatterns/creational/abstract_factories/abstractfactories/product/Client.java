package abstractfactories.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class Client {
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