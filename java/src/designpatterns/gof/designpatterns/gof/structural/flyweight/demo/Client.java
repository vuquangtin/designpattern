package designpatterns.gof.structural.flyweight.demo;

import java.util.Arrays;

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
public class Client {
	public static void main(String[] args) {
		RoleFactory factory = RoleFactory.getInstance();
		Role role1 = factory.getRole("Admin");
		Role role2 = factory.getRole("Guest");
		System.out.println(role1 == role2);

		Role getRole3 = factory.getRole("Admin");
		getRole3.login("extrinsic state 1");
		getRole3.login("extrinsic state 2");
		getRole3.login("extrinsic state 3");

		System.out.println("unshared flyweight:");
		Role getRole4 = factory.getRole(Arrays.asList("Admin", "Guest"));
		getRole4.login("extrinsic state 4");

	}
}