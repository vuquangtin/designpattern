package designpatterns.gof.book.inline;

import org.apache.commons.lang.math.RandomUtils;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

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
@DesignPattern(value = Pattern.ChainofResponsibility, description = "职责链")
public class ChainofResponsibilityPattern implements DesignPatternClient {

	/** 处理器抽象 */
	private abstract class HandleHelper {
		/** 下一个处理器 */
		protected HandleHelper nextHandler;

		/** 默认将请求转发为下一个处理器 */
		protected void handle() {
			if (nextHandler != null) {
				nextHandler.handle();
			} else {
				System.out.println("处理请求...");
			}
		}

		/** 设置下一个处理器 */
		public void setNextHandler(HandleHelper nextHandler) {
			this.nextHandler = nextHandler;
		}
	}

	/** 提供默认处理器 */
	private class Application extends HandleHelper {
		@Override
		public void handle() {
			System.out.println("使用应用的默认方式处理请求");
		}

	}

	private class Widget extends HandleHelper {
		@Override
		public void handle() {
			if (RandomUtils.nextBoolean()) {
				System.out.println("#Widget处理");
			} else {
				if (nextHandler != null) {// 如果存在后续的处理器，交由它处理
					nextHandler.handle();
				} else {
					System.out.println("到Widget无法处理");
				}
			}
		}
	}

	private class Dialog extends Widget {
		@Override
		public void handle() {
			if (RandomUtils.nextBoolean()) {
				System.out.println("#Dialog处理");
			} else {
				if (nextHandler != null) {// 如果存在后续的处理器，交由它处理
					nextHandler.handle();
				} else {
					System.out.println("到Dialog无法处理");
				}
			}
		}
	}

	private class Button extends Widget {
		@Override
		public void handle() {
			if (RandomUtils.nextBoolean()) {
				System.out.println("#Button处理");
			} else {
				if (nextHandler != null) {// 如果存在后续的处理器，交由它处理
					nextHandler.handle();
				} else {
					System.out.println("到Button无法处理");
				}
			}
		}
	}

	@Override
	public void usage() {
		Application application = new Application();
		Widget widget = new Widget();
		Dialog dialog = new Dialog();
		Button button = new Button();

		// 组装职责链
		button.setNextHandler(dialog);
		dialog.setNextHandler(widget);
		widget.setNextHandler(application);

		// 调用处理，多执行几次
		button.handle();

		System.out.println();

		button.handle();
	}

	public static void main(String[] args) {
		new ChainofResponsibilityPattern().usage();
	}
}
