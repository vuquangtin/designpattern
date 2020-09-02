package designpatterns.lambdas.behavioral.strategies;

import java.util.function.BinaryOperator;

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
@SuppressWarnings("unused")
enum StrategyEnum {
	ADD((x, y) -> x + y), SUB((x, y) -> x - y), MUL((x, y) -> x * y);

	private BinaryOperator<Integer> operator;

	StrategyEnum(BinaryOperator<Integer> operator) {
		this.operator = operator;
	}

	public BinaryOperator<Integer> get() {
		return operator;
	}
}

class Context {
	private StrategyEnum strategy;

	public Context(StrategyEnum strategy) {
		this.strategy = strategy;

	}

	public int getResult(int x, int y) {
		return strategy.get().apply(x, y);
	}
}


public class StrategyEnumClient {
	public static void main(String[] args) {
		int x = 10;
		int y = 5;

		// add
		System.out.println(new Context(StrategyEnum.ADD).getResult(x, y));
		// sub
		System.out.println(new Context(StrategyEnum.SUB).getResult(x, y));
		// mul
		System.out.println(new Context(StrategyEnum.MUL).getResult(x, y));
	}
}