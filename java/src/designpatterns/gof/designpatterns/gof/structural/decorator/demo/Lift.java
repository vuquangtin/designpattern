package designpatterns.gof.structural.decorator.demo;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Lift extends HouseDecorator {

	protected Lift(House house) {
		super(house);
	}

	@Override
	public String rent() {
		int rentPrice = house.getPrice();
		house.setPrice(rentPrice + 100);

		return "有电梯," + super.rent();
	}
}