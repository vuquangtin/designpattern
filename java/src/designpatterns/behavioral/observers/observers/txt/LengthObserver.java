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
public class LengthObserver extends Observer {
	
	public LengthObserver(Subject subject){
		this.subject = subject;
		this.subject.registerObserver(this);
	}

	@Override
	public void update() {
		System.out.println("Length: " + subject.getState().length());
	}

}