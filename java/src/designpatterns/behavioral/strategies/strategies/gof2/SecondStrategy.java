package strategies.gof2;

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
public class SecondStrategy extends Strategy {

	public String algorithm() {
		return doSomething() + " then " + doSomethingElse() + " and " + doSomethingDifferent();
	}

	private String doSomething() {
		return "Do something";
	}

	private String doSomethingElse() {
		return "Do something else";
	}

	private String doSomethingDifferent() {
		return "Do something different";
	}
}