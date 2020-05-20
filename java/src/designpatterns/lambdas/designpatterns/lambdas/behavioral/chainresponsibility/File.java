package designpatterns.lambdas.behavioral.chainresponsibility;

/**
 * <h1>Chain of Responsability</h1> Tránh sự liên kết trực tiếp giữa đối tượng
 * gửi yêu cầu và đối tượng nhận yêu cầu, khi yêu cầu có thể dc sử lý bởi hơn 1
 * đối tượng. móc nối các đối tượng nhận yêu cầu thành 1 chuỗi và gửi yêu cầu
 * theo chuỗi đó cho đến khi có đối tượng xử lý nó.
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/observer.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class File {

	enum Type {
		TEXT, PRESENTATION, AUDIO, VIDEO
	}

	private final Type type;
	private final String content;

	public File(Type type, String content) {
		this.type = type;
		this.content = content;
	}

	public Type getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return type + ": " + content;
	}
}