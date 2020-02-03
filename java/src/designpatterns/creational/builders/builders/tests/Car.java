package builders.tests;

/**
 * <h1>Builder</h1> Tách rời việc xây dựng (khởi tạo) của một đối tượng phức tạp
 * khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng (khởi tạo) có
 * thể tạo ra các biểu diễn khác nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Car {
	private String name;
	private int seat;
	private double money;
	private String color;

	public Car(Builder mBuilder) {
		name = mBuilder.name;
		seat = mBuilder.seat;
		money = mBuilder.money;
		color = mBuilder.color;
	}

	@Override
	public String toString() {
		return name + seat + money + color;
	}

	public static class Builder {
		private String name;
		private int seat;
		private double money;
		private String color;

		public Builder setName(String mName) {
			this.name = mName;
			return this;
		}

		public Builder setSeat() {
			this.seat = 4;
			return this;
		}

		public Builder setMoney(double mMoney) {
			this.money = mMoney;
			return this;
		}

		public Builder setColor(String mColor) {
			this.color = mColor;
			return this;
		}

		public Car build() {
			return new Car(this);
		}

	}
}