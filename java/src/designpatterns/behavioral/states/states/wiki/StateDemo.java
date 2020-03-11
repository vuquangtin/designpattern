package states.wiki;

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
// The state interface and two implementations. The state’s method has a
// reference to the context object and is able to change its state.
interface State {
	void writeName(StateContext context, String name);
}

class LowerCaseState implements State {
	@Override
	public void writeName(StateContext context, String name) {
		System.out.println(name.toLowerCase());
		context.setState(new MultipleUpperCaseState());
	}
}

class MultipleUpperCaseState implements State {
	/* Counter local to this state */
	private int count = 0;

	@Override
	public void writeName(StateContext context, String name) {
		System.out.println(name.toUpperCase());
		/*
		 * Change state after StateMultipleUpperCase's writeName() gets invoked
		 * twice
		 */
		if (++count > 1) {
			context.setState(new LowerCaseState());
		}
	}
}
// The context class has a state variable that it instantiates in an initial
// state, in this case LowerCaseState. In its method, it uses the corresponding
// methods of the state object.

class StateContext {
	private State state;

	public StateContext() {
		state = new LowerCaseState();
	}

	/**
	 * Set the current state. Normally only called by classes implementing the
	 * State interface.
	 * 
	 * @param newState
	 *            the new state of this context
	 */
	void setState(State newState) {
		state = newState;
	}

	public void writeName(String name) {
		state.writeName(this, name);
	}
}
// The demonstration below shows the usage:

public class StateDemo {
	public static void main(String[] args) {
		StateContext context = new StateContext();

		context.writeName("Monday");
		context.writeName("Tuesday");
		context.writeName("Wednesday");
		context.writeName("Thursday");
		context.writeName("Friday");
		context.writeName("Saturday");
		context.writeName("Sunday");
	}
}
// With the above code, the output of main() from StateDemo is:
//
// monday
// TUESDAY
// WEDNESDAY
// thursday
// FRIDAY
// SATURDAY
// sunday
