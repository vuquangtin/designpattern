package designpatterns.gof.creational.factorymethod.demo;

import designpatterns.gof.creational.simplefactory.demo.Operation;
import designpatterns.gof.creational.simplefactory.demo.OperationSub;

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
public class SubFactory implements IFactory {
	@Override
	public Operation createOpeation() {
		return new OperationSub();
	}
}