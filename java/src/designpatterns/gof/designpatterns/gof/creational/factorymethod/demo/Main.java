package designpatterns.gof.creational.factorymethod.demo;

import designpatterns.gof.creational.simplefactory.demo.Operation;

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
public class Main {
	public static void main(String[] args) {
		IFactory operFactory = new AddFactory();
		Operation oper = operFactory.createOpeation();
		oper.setNumberA(2);
		oper.setNumberB(3);
		double result = oper.getResult();
		System.out.println(result);
	}
}