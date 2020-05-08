package designpatterns.gof.book.inline;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.Decorator, description = "装饰")
public class DecoratorPattern implements DesignPatternClient {

	/** 可视组件 */
	private abstract class VisualComponent {
		public abstract void draw();
	}

	/** 具体的可视组件：文本视图 */
	private class TextView extends VisualComponent {
		@Override
		public void draw() {
			System.out.println("draw TextView");
		}
	}

	/** 具体的可视组件：图形视图 */
	private class GraphView extends VisualComponent {
		@Override
		public void draw() {
			System.out.println("draw GraphView");
		}
	}

	/** 装饰器，继承可视组件 */
	private abstract class Decorator extends VisualComponent {
		/** 聚合可视组件 */
		private VisualComponent component;

		public Decorator(VisualComponent component) {
			this.component = component;
		}

		@Override
		public void draw() {
			component.draw();
		}
	}

	/** 具体装饰器: 带滚动条 */
	private class ScrollDecorator extends Decorator {
		private int scrollPosistion;

		public ScrollDecorator(VisualComponent component, int scrollPosistion) {
			super(component);
			this.scrollPosistion = scrollPosistion;
		}

		@Override
		public void draw() {
			super.draw();// 常规功能
			this.scrollTo();// 扩展的功能
		}

		public void scrollTo() {
			System.out.println("draw ScrollDecorator[scrollPosistion="
					+ scrollPosistion + "]");
		}
	}

	/** 具体装饰器：带边框 */
	private class BorderDecorator extends Decorator {
		private int borderWidth;

		public BorderDecorator(VisualComponent component, int borderWidth) {
			super(component);
			this.borderWidth = borderWidth;
		}

		@Override
		public void draw() {
			super.draw();// 常规功能
			this.drawBorder();// 扩展的功能
		}

		private void drawBorder() {
			System.out.println("draw BorderDecorator[borderWidth="
					+ borderWidth + "]");
		}
	}

	@Override
	public void usage() {

		// 1 单个装饰
		VisualComponent visualComponent = new ScrollDecorator(new TextView(), 1);
		visualComponent.draw();

		System.out.println();

		visualComponent = new BorderDecorator(new GraphView(), 2);
		visualComponent.draw();

		System.out.println();

		// 2 多个装饰，顺序不同
		visualComponent = new ScrollDecorator(new BorderDecorator(
				new TextView(), 2), 1);
		visualComponent.draw();

		System.out.println();

		visualComponent = new BorderDecorator(new ScrollDecorator(
				new TextView(), 1), 2);
		visualComponent.draw();
	}

	public static void main(String[] args) {
		new DecoratorPattern().usage();
	}
}