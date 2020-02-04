package proxies.shapes;

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
public class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}
