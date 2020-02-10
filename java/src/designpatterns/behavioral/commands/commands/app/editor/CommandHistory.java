package commands.app.editor;

import java.util.Stack;
/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void push(Command command) {
        history.push(command);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}