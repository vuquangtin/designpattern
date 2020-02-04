package proxies.gof;

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
public class ProxyProtectedFile extends File {

	private File file;

	public ProxyProtectedFile() {
		file = new PublicFile();
	}

	public String read() {
		return isProtected ? "Read: File is Protected" : file.read();
	}
}