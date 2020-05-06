package designpatterns.gof.structural.flyweight.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Flyweight</h1> Sử dụng việc chia sẻ để hỗ trợ số lượng lớn các đối tượng
 * fine-graied cỡ nhỏ 1 cách hiệu quả
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class RoleGroup implements Role {
	private List<Role> roles = new ArrayList<Role>();

	RoleGroup() {
	}

	@Override
	public String login(String username) {
		StringBuilder message = new StringBuilder();
		for (Role role : roles) {
			message.append(role.login(username)).append("\n");
		}
		return message.toString();
	}

	public void addRole(Role role) {
		roles.add(role);
	}
}