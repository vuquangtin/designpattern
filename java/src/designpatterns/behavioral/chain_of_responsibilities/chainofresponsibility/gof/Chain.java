package chainofresponsibility.gof;

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
public abstract class Chain {

	protected static final int ERR_SYSTEM = 1;
	protected static final int ERR_APPLICATION = 2;
	protected static final int ERR_NETWORK = 3;
	protected int priority;
	private Chain next = null;

	public String handleRequest(int priority) {
		if (this.priority == priority) {
			return this.writeMessage();
		} else if (next != null) {
			return this.next.handleRequest(priority);
		}

		return "Request Not Handled";
	}

	public void setNext(Chain nextChain) {
		this.next = nextChain;
	}

	public abstract String writeMessage();
}
