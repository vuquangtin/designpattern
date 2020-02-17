package observers.tests;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 * @see http://www.programmergirl.com/observer-design-pattern-java/
 *
 */

public class Subscriber implements Observer {

	private String name;
	private Subject subject;

	public Subscriber(String name) {
		this.name = name;
	}

	public void subscribeTo(Subject subject) {
		subject.register(this);
		this.subject = subject;
	}

	public void unsubscribeFrom(Subject subject) {
		subject.unregister(this);
		this.subject = null;
	}

	@Override
	public void update() {
		if (this.subject == null) {
			System.out.println("Not yet subscribed!");
			return;
		}
		// get the last published post
		Post recentPost = this.subject.getRecentPost();
		System.out.println(this.name + ", a new post got published: " + recentPost);
	}
}