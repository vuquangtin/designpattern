package designpatterns.gof.behavioral.states.inline;

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
public class StateClient {

	public static void main(String[] args) {

		StateContext context = new StateContext();
		context.executeActions("MONDAY");
		context.executeActions("TUESDAY");
		context.executeActions("WEDNESDAY");
		context.executeActions("THURSDAY");
		context.executeActions("FRIDAY");
		context.executeActions("SATURDAY");
		context.executeActions("SUNDAY");
	}
}

interface State {

	/**
	 * 
	 * @param stateContext
	 */
	public void stateAction(StateContext stateContext);
}

class StateA implements State {

	/**
	 * Constructor
	 */
	public StateA() {
		// does nothing
	}

	@Override
	public void stateAction(StateContext stateContext) {
		System.out.println("In State A : now switching to State B");
		stateContext.setState(new StateB());
	}

}

class StateB implements State {

	/* private fields */

	private int count = 0;

	/**
	 * Constructor
	 */
	public StateB() {
		// does nothing
	}

	@Override
	public void stateAction(StateContext stateContext) {

		System.out.println("In State B");
		// switch state when in State B more than 2 times
		if (++count > 1) {
			stateContext.setState(new StateA());
			System.out.println("Switching to State A");
		}
	}

}

class StateContext {

	/* private fields */

	private State state;

	/**
	 * Constructor
	 */
	public StateContext() {
		setState(new StateA());
	}

	/**
	 * Sets the state
	 * 
	 * @param state
	 *            the new state
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Execute some arbitrary action
	 * 
	 * @param text
	 *            a piece text
	 */
	public void executeActions(String text) {
		System.out.println(text);
		state.stateAction(this);
	}
}