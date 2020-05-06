package designpatterns.gof.structural.bridge.pattern;
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
public class ConcreteImplementorA extends Implementor {

	public ConcreteImplementorA(){

	}

	public void OperationImp(){
        System.out.print("ConcreteImplementorA" + "\n");
	}

}