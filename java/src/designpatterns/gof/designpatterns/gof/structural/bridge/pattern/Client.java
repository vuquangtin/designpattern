package designpatterns.gof.structural.bridge.pattern;

/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {

	public static void main(String[] args) {

		// 页面风格（可增加）
		ConcreteImplementorA concreteImplementorA = new ConcreteImplementorA();
		ConcreteImplementorB concreteImplementorB = new ConcreteImplementorB();
		// 具体页面
		RefinedAbstraction refinedAbstraction = new RefinedAbstraction(concreteImplementorA);// A风格
		refinedAbstraction.Operation();

		refinedAbstraction = new RefinedAbstraction(concreteImplementorB);// B风格
		refinedAbstraction.Operation();
	}
}