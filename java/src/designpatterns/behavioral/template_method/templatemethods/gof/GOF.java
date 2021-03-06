package templatemethods.gof;

/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. mẫu Template Method cho phép
 * lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà không phải thay đổi
 * cấu trúc thuật toán.
 * 
 * @see http
 *      ://www.itsenka.com/contents/development/designpattern/template_method
 *      .html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		AbstractClass AC = new ConcreteClass();
		AC.templateMethod();
	}
}

abstract class AbstractClass {
	/**
	 * 「templateMethod」に「final」修飾子を付けをオーバーライド出来ないようにします。
	 * 処理内容をサブクラスで変更されるのを禁止します。
	 */
	public final void templateMethod() {
		method1();
		method2();
	}

	/** 外部から直接アクセスさせないようにします。サブクラスでのオーバーライドを強制という意味を込めて「protected」にします。 */
	protected abstract void method1();

	protected abstract void method2();
}

class ConcreteClass extends AbstractClass {
	public void method1() {
		System.out.println("method1");
	}

	public void method2() {
		System.out.println("method2");
	}
}