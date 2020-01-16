package observers.converts;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ObserverPatternDemo {
	public static void main(String[] args) {
		Subject subject = new Subject();

		Observer hexaObserver = new HexaObserver(subject);
		Observer octalObserver = new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);

		System.out.println("---Remove HexaObserver---");
		subject.detach(hexaObserver);
		System.out.println("Third state change: 11");
		subject.setState(11);
		System.out.println("Fourth state change: 7");
		subject.setState(7);

		System.out.println("---Remove OctalObserver---");
		subject.detach(octalObserver);
		System.out.println("Fifth state change: 8");
		subject.setState(8);
		System.out.println("Sixth state change: 4");
		subject.setState(4);
	}
}
