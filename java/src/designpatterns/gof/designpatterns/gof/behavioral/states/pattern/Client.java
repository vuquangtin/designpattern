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
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.request();
        System.out.println(context.getState());

        System.out.println();
        context.request();
        System.out.println(context.getState());
    }
}