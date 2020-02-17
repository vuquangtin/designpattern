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
public class Blog extends Subject {

	private String title;
	private String author;

	public Blog(String title, String author) {
		this.title = title;
		this.setAuthor(author);
	}

	public void publish(Post post) {
		// code to publish a new post
		// ...
		notifyAllObserver();
	}

	public Post getRecentPost() {
		// ...
		return new Post(title);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// ...
}