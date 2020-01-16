package chainofresponsibility.managers;

/**
 * <h1>Chain of Responsability</h1> Tránh sự liên kết trực tiếp giữa đối tượng
 * gửi yêu cầu và đối tượng nhận yêu cầu, khi yêu cầu có thể dc sử lý bởi hơn 1
 * đối tượng. móc nối các đối tượng nhận yêu cầu thành 1 chuỗi và gửi yêu cầu
 * theo chuỗi đó cho đến khi có đối tượng xử lý nó.
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/observer.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class Leader {

	protected Leader mNextLeader;

	/**
	 * 处理请求
	 * 
	 * @param money
	 */
	public final void handleRequest(int money) {
		if (money < limit()) {
			handle(money);
		} else {
			if (mNextLeader != null) {
				money = money / 10;
				System.out.println("handleRequest:" + money);
				mNextLeader.handleRequest(money);
			}
		}
	}

	/**
	 * 自身能承受的最大额度
	 * 
	 * @return
	 */
	public abstract int limit();

	/**
	 * 处理报销
	 * 
	 * @param money
	 */
	public abstract void handle(int money);

}