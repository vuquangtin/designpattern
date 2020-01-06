package states.client;

import java.util.Random;

/**
 * <h1>State</h1> cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính
 * nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */

public class Client {
	public static void main(String[] args) {
		Random rand = new Random();
		Context context = new Context();
		int temp = 0;
		int condition = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("--------------------");
			temp = rand.nextInt(10);
			System.out.println(i + "回目：" + temp);
			condition = temp % 2;
			System.out.println("　　 ：" + condition);
			context.contextMethod1(condition);
			context.contextMethod2();
			System.out.println();
		}
	}
}

interface State {
	public abstract void stateMethod1(Context context, int condition);

	public abstract void stateMethod2(Context context);
}

class ConcreteStateA implements State {
	private static final String stateName = "ConcreteStateA";

	// -「Singleton」パターンを適用 -------------------------------------------
	private static State concreteStateA = new ConcreteStateA();

	private ConcreteStateA() {
	}

	public static State getInstance() {
		return concreteStateA;
	}

	// ------------------------------------------------------------------------

	// 「Context」が参照しているアクティブな「State」オブジェクト変更用メソッド
	public void stateMethod1(Context context, int condition) {
		if (condition == 1) {
			context.setState(ConcreteStateB.getInstance());
			System.out.println("☆☆☆☆☆ 状態変更 A -> B ☆☆☆☆☆");
		}
	}

	public void stateMethod2(Context context) {
		context.contextMethod3(" 状態：" + stateName);
	}
}

class ConcreteStateB implements State {
	private static final String stateName = "ConcreteStateB";

	// -「Singleton」パターンを適用 -------------------------------------------
	private static State concreteStateB = new ConcreteStateB();

	private ConcreteStateB() {
	}

	public static State getInstance() {
		return concreteStateB;
	}

	// ------------------------------------------------------------------------

	// 「Context」が参照しているアクティブな「State」オブジェクト変更用メソッド
	public void stateMethod1(Context context, int condition) {
		if (condition == 0) {
			context.setState(ConcreteStateA.getInstance());
			System.out.println("★★★★★ 状態変更 B -> A ★★★★★");
		}
	}

	public void stateMethod2(Context context) {
		context.contextMethod3(" 状態：" + stateName);
	}
}

class Context {
	private State state = null;

	public Context() {
		state = ConcreteStateA.getInstance();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void contextMethod1(int condition) {
		state.stateMethod1(this, condition);
	}

	public void contextMethod2() {
		state.stateMethod2(this);
	}

	public void contextMethod3(String msg) {
		System.out.println(msg);
	}
}