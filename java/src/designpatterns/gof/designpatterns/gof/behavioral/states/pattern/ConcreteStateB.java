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
public class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("concrete state B handle");
        context.setState(context.getStateA());
    }


    @Override
    public String toString() {
        return "state B";
    }
}