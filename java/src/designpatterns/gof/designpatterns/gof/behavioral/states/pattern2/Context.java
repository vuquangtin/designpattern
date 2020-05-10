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
public class Context {
	private State state;

	/** 对请求做处理，并设置下一个状态 请求有很多选择，根据不同选择做不同处理，并跳转到不同状态 */
	public void request() {
		// TODO: implement
		state.handle(this);
	}

	/**
	 * @param state
	 */
	public Context(State state) {
		// TODO: implement
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		System.out.println("当前状态：" + state.name);
	}

}