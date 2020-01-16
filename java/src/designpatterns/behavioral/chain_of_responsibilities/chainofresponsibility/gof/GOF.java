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
public class GOF {
	public static void main(String[] args) {
		Handler hand1 = new ConcreteHandlerA("A", 1, 10);
		Handler hand2 = new ConcreteHandlerA("B", 11, 20);
		Handler hand3 = new ConcreteHandlerA("C", 21, 30);
		Handler hand11 = new ConcreteHandlerB("D");
		hand1.setNext(hand2).setNext(hand3).setNext(hand11); // 責任のチェーンを構築
		hand1.request(31);
	}
}

abstract class Handler {
	protected String name;
	protected Handler next;

	public Handler(String name) {
		this.name = name;
	}

	public Handler setNext(Handler handler) {
		this.next = handler;
		return handler;
	}

	public abstract void request(int req);
}

class ConcreteHandlerA extends Handler {
	private int rangeS;
	private int rangeE;

	public ConcreteHandlerA(String name, int rangeS, int rangeE) {
		super(name);
		this.rangeS = rangeS;
		this.rangeE = rangeE;
	}

	public void request(int req) {
		if (req >= rangeS && req <= rangeE) {
			System.out.println(name + "：私が成敗してくれるわ!");
		} else if (next != null) {
			System.out.println(name + "：私では無理じゃ!次の者出合えー");
			next.request(req);
		} else {
			System.out.println(name + "：次の者がおりませぬー");
		}
	}
}

class ConcreteHandlerB extends Handler {
	public ConcreteHandlerB(String name) {
		super(name);
	}

	public void request(int req) {
		if (req % 2 == 0) {
			System.out.println(name + "：ようこそ!偶数は私のテリトリーです。");
		} else if (next != null) {
			System.out.println(name + "：無念!偶数以外は・・・!次の方お願いします。");
			next.request(req);
		} else {
			System.out.println(name + "：無念!偶数以外は・・・!次もいないー");
		}
	}
}