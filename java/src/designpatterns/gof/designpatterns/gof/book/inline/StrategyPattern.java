package designpatterns.gof.book.inline;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.Strategy, description = "策略")
public class StrategyPattern implements DesignPatternClient {

	private class Composition {
		/** 策略对象应用 */
		private Compositor compositor;

		public Composition(Compositor compositor) {
			this.compositor = compositor;
		}

		public void repair() {
			compositor.compose();
		}
	}

	/** 策略抽象 */
	private abstract class Compositor {
		public abstract void compose();
	}

	private class SimpleCompositor extends Compositor {
		@Override
		public void compose() {
			System.out.println("SimpleCompositor compose");
		}
	}

	private class TexCompositor extends Compositor {
		@Override
		public void compose() {
			System.out.println("TexCompositor compose");
		}
	}

	private class ArrayCompositor extends Compositor {
		@Override
		public void compose() {
			System.out.println("ArrayCompositor compose");
		}
	}

	@Override
	public void usage() {
		Compositor compositor = null;
		Composition composition = null;

		compositor = new SimpleCompositor();
		composition = new Composition(compositor);
		composition.repair();

		compositor = new TexCompositor();
		composition = new Composition(compositor);
		composition.repair();

		compositor = new ArrayCompositor();
		composition = new Composition(compositor);
		composition.repair();

	}

	public static void main(String[] args) {
		new StrategyPattern().usage();
	}

}