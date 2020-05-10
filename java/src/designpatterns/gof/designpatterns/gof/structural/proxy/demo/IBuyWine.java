package designpatterns.gof.structural.proxy.demo;

/**
 * <h1>Proxy</h1> Cung cấp một đối tượng thay thế hoặc giữ chỗ placeholder cho
 * một đối tượng khác để truy xuất đến nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public interface IBuyWine {
	void buyWine();
}

/**
 * 买酒的用户（委托类）
 */
class UserWine implements IBuyWine {

	@Override
	public void buyWine() {
		System.out.println("UserWine buyWine ");
	}
}
