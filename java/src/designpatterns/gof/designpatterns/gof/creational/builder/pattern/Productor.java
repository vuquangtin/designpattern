package designpatterns.gof.creational.builder.pattern;

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
public class Productor {
	private Part partA;
	private Part partB;
	private Part partC;

	public Part getPartA() {
		return partA;
	}

	public void setPartA(Part partA) {
		this.partA = partA;
	}

	public Part getPartB() {
		return partB;
	}

	public void setPartB(Part partB) {
		this.partB = partB;
	}

	public Part getPartC() {
		return partC;
	}

	public void setPartC(Part partC) {
		this.partC = partC;
	}

	@Override
	public String toString() {
		return "Productor [partA=" + partA + ", partB=" + partB + ", partC="
				+ partC + "]";
	}

}