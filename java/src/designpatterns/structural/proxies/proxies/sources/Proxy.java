package proxies.sources;

/**
 * <h1>Proxy</h1> Cung cấp một đối tượng thay thế hoặc giữ chỗ placeholder cho
 * một đối tượng khác để truy xuất đến nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Proxy implements Sourceable {
	private Sourceable source = null;

	public Proxy() {
		source = new Source();
	}

	@Override
	public void method() {
		before();
		System.out.println("this is proxy method");
		after();
	}

	private void after() {
		System.out.println("after proxy!");
	}

	private void before() {
		System.out.println("before proxy!");
	}
}
