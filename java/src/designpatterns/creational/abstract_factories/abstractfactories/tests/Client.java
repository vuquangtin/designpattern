package abstractfactories.tests;

import org.apache.log4j.Logger;

import utilities.Log4jUtils;
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
	static Logger logger = Logger.getLogger(Client.class.getName());

	public static void main(String[] args) {
		logger = Log4jUtils.initLog4j();
		AbstractFactory mFactory1 = new Factory1();
		AbstractFactory mFactory2 = new Factory2();
		mFactory1.createAbstractProductA().method();
		mFactory1.createAbstractProductB().method();
		mFactory2.createAbstractProductB().method();
		mFactory2.createAbstractProductA().method();
	}
}
