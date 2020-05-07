package designpatterns.gof.behavioral.command.demo;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */

public class GeneralAttackCommand implements Command {
	private String target;
	private List<Troop> troops;

	public GeneralAttackCommand(String target) {
		this.target = target;
		troops = Arrays.asList(new Army(), new Navy());
	}

	@Override
	public String execute() {
		StringBuilder message = new StringBuilder();
		for (Troop troop : troops) {
			message.append(troop.attack(target)).append("\n");
		}
		return message.toString();
	}
}