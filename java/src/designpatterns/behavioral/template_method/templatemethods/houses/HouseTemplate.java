package templatemethods.houses;

/**
 * <h1>Template Method</h1> Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức
 * năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template
 * Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà
 * không phải thay đổi cấu trúc thuật toán. <br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class HouseTemplate {

	// template method, final so subclasses can't override

	public final void buildHouse() {

		buildFoundation();

		buildPillars();

		buildWalls();

		buildWindows();

		System.out.println("House is built.");

	}

	// default implementation

	private void buildWindows() {

		System.out.println("Building Glass Windows");

	}

	// methods to be implemented by subclasses

	public abstract void buildWalls();

	public abstract void buildPillars();

	private void buildFoundation() {

		System.out
				.println("Building foundation with cement,iron rods and sand");

	}

}