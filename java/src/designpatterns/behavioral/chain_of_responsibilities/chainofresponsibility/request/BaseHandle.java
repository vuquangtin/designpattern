package chainofresponsibility.request;

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
public abstract class BaseHandle {

	protected BaseHandle mNextBaseHandle;

	protected abstract int getHandleLevel();

	protected abstract void handle(BaseRequest mBaseRequest);

	public final void handleRequest(BaseRequest mBaseRequest) {
		if (getHandleLevel() == mBaseRequest.getRequestLevel()) {
			handle(mBaseRequest);
		} else {
			if (mNextBaseHandle != null) {
				mNextBaseHandle.handle(mBaseRequest);
			} else {
				System.out.println("every handler can not do this ");
			}
		}

	}

}
