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
public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}

	@Override
	public void Operation() {

		System.out.print("RefinedAbstraction" + "\n");

		mImplementor.OperationImp(); // 可以调用在Implementor中定义的业务方法
	}

}