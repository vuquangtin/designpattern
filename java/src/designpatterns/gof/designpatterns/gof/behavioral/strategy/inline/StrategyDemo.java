package designpatterns.gof.behavioral.strategy.inline;

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
public class StrategyDemo {

	// 客户端
	public static void main(String[] args) {

		Context context = new Context(new ConcreteStrategyA());
		context.execute();

	}

	/**
	 * 环境上下文
	 */

	static class Context {
		private Strategy strategy;

		public Context(Strategy strategy) {
			this.strategy = strategy;
		}

		void execute() {
			strategy.execute();
		}
	}

	/**
	 * 抽象策略类
	 */
	interface Strategy {
		void execute();
	}

	/**
	 * 具体策略A
	 */
	static class ConcreteStrategyA implements Strategy {

		@Override
		public void execute() {
			System.out.println("execute strategy A");
		}
	}

	/**
	 * 具体策略B
	 */
	static class ConcreteStrategyB implements Strategy {

		@Override
		public void execute() {
			System.out.println("execute strategy B");
		}
	}

}