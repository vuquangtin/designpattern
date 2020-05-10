package designpatterns.gof.behavioral.chainresponsibility.inline2;

/**
 * <h1>Chain of Responsability</h1> Tránh sự liên kết trực tiếp giữa đối tượng
 * gửi yêu cầu và đối tượng nhận yêu cầu, khi yêu cầu có thể dc sử lý bởi hơn 1
 * đối tượng. móc nối các đối tượng nhận yêu cầu thành 1 chuỗi và gửi yêu cầu
 * theo chuỗi đó cho đến khi có đối tượng xử lý nó.
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/observer.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */

public class ChainofResponsibilityPattern {
	public static void main(String[] args) {
		ConcreteHandler1 concreteHandler1 = new ConcreteHandler1();
		ConcreteHandler2 concreteHandler2 = new ConcreteHandler2();
		concreteHandler1.setNextHandler(concreteHandler2);
		concreteHandler1.handlerRequest("adf");
	}
}

// 抽象处理者角色
abstract class Handler {
	private Handler nextHandler;

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public Handler getNextHandler() {
		return nextHandler;// vue开发实战
	}

	// 处理请求的方法
	public abstract void handlerRequest(String request);
}

// 具体处理者1
class ConcreteHandler1 extends Handler {

	@Override
	public void handlerRequest(String request) {
		if (request.equals("one")) {
			System.out.println("具体处理者1负责处理该请求！");
		} else {
			if (getNextHandler() != null) {
				getNextHandler().handlerRequest(request);
			} else {
				System.out.println("没有人处理该请求！");
			}
		}
	}
}
// 具体处理者2

class ConcreteHandler2 extends Handler {

	@Override
	public void handlerRequest(String request) {
		if (request.equals("two")) {
			System.out.println("具体处理者1负责处理该请求！");
		} else {
			if (getNextHandler() != null) {
				getNextHandler().handlerRequest(request);
			} else {
				System.out.println("没有人处理该请求！");
			}
		}
	}
}
