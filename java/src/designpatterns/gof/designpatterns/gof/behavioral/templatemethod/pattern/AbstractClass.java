package designpatterns.gof.behavioral.templatemethod.pattern;


/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template
 * Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà
 * không phải thay đổi cấu trúc thuật toán. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class AbstractClass {

	public void templateMethod() {
		System.out.println("template method start");
		primitiveOperation1();
		System.out.println("template method running");
		primitiveOperation2();
		System.out.println("template method end");
	}

	protected abstract void primitiveOperation1();

	protected abstract void primitiveOperation2();
}
