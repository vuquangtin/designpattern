package designpatterns.gof.structural.flyweight.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class RoleFactory {
	private static RoleFactory roleFactory;
	private Map<String, Role> roles = new HashMap<String, Role>();

	private RoleFactory() {
	}

	public synchronized static RoleFactory getInstance() {
		if (roleFactory == null) {
			roleFactory = new RoleFactory();
		}
		return roleFactory;
	}

	public Role getRole(String roleName) {
		if (roles.containsKey(roleName)) {
			return roles.get(roleName);
		}

		try {
			Role role = (Role) Class.forName("designpatterns.gof.structural.flyweight.demo." + roleName).newInstance();
			roles.put(roleName, role);
			return role;
		} catch (Exception e) {
			throw new RuntimeException("获取角色失败");
		}
	}

	public Role getRole(List<String> roleNames) {
		RoleGroup roleGroup = new RoleGroup();
		for (String roleName : roleNames) {
			Role role = getRole(roleName);
			roleGroup.addRole(role);
		}
		return roleGroup;
	}
}