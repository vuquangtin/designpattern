package designpatterns.gof.behavioral.states.pattern;
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
public class Context {
    private State state;
    private State stateA;
    private State stateB;

    public Context() {
        stateA = new ConcreteStateA();
        stateB = new ConcreteStateB();
        state = stateA;
    }

    public void request() {
        state.handle(this);
    }

    public State getStateB() {
        return stateB;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getStateA() {
        return stateA;
    }

    public State getState() {
        return state;
    }
}