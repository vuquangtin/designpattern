package strategies.gof;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		Context context = new Context(new ConcreteStrategyA());
		System.out.println(context.contextMeshod());
		context.setStrategy(new ConcreteStrategyB());
		System.out.println(context.contextMeshod());
	}
}

interface Strategy {
	public abstract String strategyMethod();
}

class ConcreteStrategyA implements Strategy {
	public String strategyMethod() {
		return "戦略A";
	}
}

class ConcreteStrategyB implements Strategy {
	public String strategyMethod() {
		return "戦略B";
	}
}

class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		setStrategy(strategy);
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public String contextMeshod() {
		return strategy.strategyMethod();
	}
}