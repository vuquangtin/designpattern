package observers.txt;
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



public class Test {
	
	public static void main(String[] args) {
		Subject subject = new Subject("Hello World");
		
		new CapsObserver(subject);
		new LengthObserver(subject);
		new WordsObserver(subject);
		
		subject.notifyObservers();
		
		subject.setState("Testing the Observer Design Pattern");
		
		subject.setState("");
		

	}

}