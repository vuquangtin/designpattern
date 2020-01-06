package commands.javacodegeeks;

import java.util.ArrayList;
import java.util.List;
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
public class Command {

    public static void main(String[] args) {
        List<BetCommand> betCommands = new ArrayList<>();
        betCommands.add(new BackingCommand(new Bet("match1",10)));
        betCommands.add(new BackingCommand(new Bet("match2",11)));

        BetBook betBook = new BetBook();
        betCommands.forEach(bc->bc.applyTo(betBook));
    }

}
