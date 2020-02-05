package factorymethods.products;
/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Product2 extends Product {
	@Override
	public void start() {
		System.out.println("cn.edu.nuc1.Product 2 start");
	}

	@Override
	public void end() {

		System.out.println("product 2 end");
	}
}