package designpatterns.gof.behavioral.visitor.overloading;
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
class AT {
	
    public void method1(AT X) {
        System.out.println("AT");
    }
}
class BT extends AT {
    public void method2() {
        System.out.println("BT");
    }
}
class CT extends BT {
	//overriding for AT
    public void method1(AT x) {
        System.out.println("C");
    }
}
class DT extends CT {
    public void method1(DT x) {
        System.out.println("DT");
    }
}
public class Test2 {
    public static void main(String[] args) {
        CT c = new DT();
        BT b = c;
        c.method1(c);  // prints C
        b.method1(b);  // prints C
    }
}
