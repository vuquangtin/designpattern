package designpatterns.gof.behavioral.strategy.inline;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class StrategyPattern {

	// 客户端
	public static void main(String[] args) {
		Context context = new Context(new ConcreteStrategyA());
		System.out.println("Go to airport with ConcreteStrategyA, take a taxi=" + context.contextInterface());

		context = new Context(new ConcreteStrategyB());
		System.out.println("Go to airport with ConcreteStrategyB, take a bus=" + context.contextInterface());

		context = new Context(new ConcreteStrategyC());
		System.out.println("Go to airport with ConcreteStrategyC, take a metro=" + context.contextInterface());

	}

	/**
	 * Declares an interface common to all supported algorithms. Context uses
	 * this interface to call the algorithm defined by a ConcreteStrategy.
	 * 
	 */
	public interface Strategy {

		String algorithmInterface();
	}

	/**
	 * Implements the algorithm defined in Strategy interface.
	 *
	 */
	public static class ConcreteStrategyA implements Strategy {

		public String algorithmInterface() {
			return "Go to airport with ConcreteStrategyA, take a taxi";
		}
	}

	/**
	 * Implements the algorithm defined in Strategy interface.
	 *
	 */
	public static class ConcreteStrategyB implements Strategy {

		public String algorithmInterface() {
			return "Go to airport with ConcreteStrategyB, take a bus";
		}
	}

	/**
	 * Implements the algorithm defined in Strategy interface.
	 *
	 */
	public static class ConcreteStrategyC implements Strategy {

		public String algorithmInterface() {
			return "Go to airport with ConcreteStrategyC, take a metro";
		}
	}

	/**
	 * Maintains a reference to a Strategy object. Invokes algorithm implemented
	 * in ConcreteStrategy.
	 *
	 */
	public static class Context {

		private Strategy strategy;

		public Context(Strategy strategy) {
			this.strategy = strategy;
		}

		protected String contextInterface() {
			return this.strategy.algorithmInterface();
		}
	}

}