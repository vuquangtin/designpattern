package designpatterns.gof.behavioral.chainresponsibility.inline;

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
class Request {
	private int m_value;
	private String m_description;

	public Request(String description, int value) {
		m_description = description;
		m_value = value;
	}

	public int getValue() {
		return m_value;
	}

	public String getDescription() {
		return m_description;
	}
}

abstract class Handler {
	protected Handler m_successor;

	public void setSuccessor(Handler successor) {
		m_successor = successor;
	}

	public abstract void handleRequest(Request request);
}

class ConcreteHandlerOne extends Handler {
	public void handleRequest(Request request) {
		if (request.getValue() < 0) { // if request is eligible handle it
			System.out
					.println("Negative values are handled by ConcreteHandlerOne:");
			System.out.println("\tConcreteHandlerOne.HandleRequest : "
					+ request.getDescription() + request.getValue());
		} else {
			m_successor.handleRequest(request);
		}
	}
}

class ConcreteHandlerThree extends Handler {
	public void handleRequest(Request request) {
		if (request.getValue() >= 0) { // if request is eligible handle it
			System.out
					.println("Zero values are handled by ConcreteHandlerThree:");
			System.out.println("\tConcreteHandlerThree.HandleRequest : "
					+ request.getDescription() + request.getValue());
		} else {
			m_successor.handleRequest(request);
		}
	}
}

class ConcreteHandlerTwo extends Handler {
	public void handleRequest(Request request) {
		if (request.getValue() > 0) { // if request is eligible handle it
			System.out
					.println("Positive values are handled by ConcreteHandlerTwo:");
			System.out.println("\tConcreteHandlerTwo.HandleRequest : "
					+ request.getDescription() + request.getValue());
		} else {
			m_successor.handleRequest(request);
		}
	}
}

public class MainRequest {
	public static void main(String[] args) {
		// Setup Chain of Responsibility
		Handler h1 = new ConcreteHandlerOne();
		Handler h2 = new ConcreteHandlerTwo();
		Handler h3 = new ConcreteHandlerThree();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);

		// Send requests to the chain
		h1.handleRequest(new Request("Negative Value ", -1));
		h1.handleRequest(new Request("zero Value ", 0));
		h1.handleRequest(new Request("Negative Value ", 1));
		h1.handleRequest(new Request("Negative Value ", 2));
		h1.handleRequest(new Request("Negative Value ", -5));
	}
}
