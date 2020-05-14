package designpatterns.lambdas.behavioral.strategies;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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
public class StrategyLambda {
	public static final UnaryOperator<String> UPPER = String::toUpperCase;

	public static void publishText(String text, Predicate<String> filter,
			UnaryOperator<String> format) {
		if (filter.test(text)) {
			System.out.println(format.apply(text));
		}
	}

	public static void main(String[] args) {
		publishText("ERROR - something bad happened", s -> true,
				String::toUpperCase);
		publishText("DEBUG - I'm here", s -> s.length() < 20,
				String::toLowerCase);
	}
}