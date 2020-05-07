package designpatterns.gof.behavioral.templatemethod.inline;

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
public class TemplateDemo {
	// 客户端
	public static void main(String[] args) {
		Template template = null;

		template = new ConcreteClassA();
		template.templateMeth();

		template = new ConcreteClassB();
		template.templateMeth();
	}

	/**
	 * 模板类，提供一个模板方法
	 */
	static abstract class Template {
		final void templateMeth() {
			method1();

			method2();

			specialmethod();

		}

		void method1() {
			System.out.println("电饭锅插电");
		}

		void method2() {
			System.out.println("放入材料");
		}

		abstract void specialmethod();

	}

	/**
	 * 具体模板类A
	 */
	static class ConcreteClassA extends Template {

		@Override
		void specialmethod() {
			System.out.println("按煮饭按钮，等30min");
		}
	}

	/**
	 * 具体模板类B
	 */
	static class ConcreteClassB extends Template {

		@Override
		void specialmethod() {
			System.out.println("按煲汤按钮，等1h");
		}
	}
}