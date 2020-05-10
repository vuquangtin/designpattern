package designpatterns.gof.behavioral.states.pattern2;

/**
 * <h1>State</h1> cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính
 * nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class ConcreteStateC extends State {
	public ConcreteStateC() {
		this.name = "ConcreteStateC";
	}

	/**
	 * @param context
	 */
	public void handle(Context context) {
		// TODO: implement
		context.setState(new ConcreteStateA());
	}

}