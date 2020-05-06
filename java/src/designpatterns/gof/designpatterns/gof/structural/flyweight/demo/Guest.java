package designpatterns.gof.structural.flyweight.demo;

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
public class Guest implements Role {
	private String roleName = "游客";

	Guest() {
	}

	@Override
	public String login(String username) {
		return username + "以" + roleName + "身份登录，只有普通用户权限";
	}
}