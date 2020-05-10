package designpatterns.gof.structural.decorator.inline;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class DecoratorPattern {
	static abstract class Component {
		public abstract void operation();
	}

	static class ConcreteComponent extends Component {

		@Override
		public void operation() {

		}
	}

	static class Decorator extends Component {
		protected Component mComponent;

		public void setComponent(Component component) {
			this.mComponent = component;
		}

		@Override
		public void operation() {
			if (mComponent != null) {
				mComponent.operation();
			}
		}
	}

	static class ConcreteDecoratorA extends Decorator {
		@Override
		public void operation() {
			super.operation();
			// do stuff
		}
	}

	static class ConcreteDecoratorB extends Decorator {
		@Override
		public void operation() {
			super.operation();
			// do stuff
		}
	}

	public static void main(String[] args) {
		ConcreteComponent c = new ConcreteComponent();
		ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
		ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

		concreteDecoratorA.setComponent(c);
		concreteDecoratorB.setComponent(concreteDecoratorA);
		concreteDecoratorB.operation();
	}

}
