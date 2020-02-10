package commands.gof;

import java.util.ArrayList;
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
public class Invoker {

  private ArrayList<Command> commands = new ArrayList<Command>();

  public void setCommandAndExecute(Command c) {
    commands.add(c);
    c.execute();
  }

  public String toString() {
    String output = "History:";

    for (Command command : commands) {
      output += "\n" + command.toString();
    }

    return output;
  }
}
