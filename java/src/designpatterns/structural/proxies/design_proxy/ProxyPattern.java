package design_proxy;

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
public class ProxyPattern {

	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutorProxy("almasud", "wrong");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rt test.txt");
		} catch (Exception e) {
			System.err.println("Exception message: " + e.getMessage());
		}
	}

}