package factorymethods.computers;

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
public class TestFactory {
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB",
				"2.4 GHz");
		Computer server = ComputerFactory.getComputer("server", "16 GB",
				"1 TB", "2.9 GHz");
		System.out.println("Factory PC Config::" + pc);
		System.out.println("Factory Server Config::" + server);
	}
}