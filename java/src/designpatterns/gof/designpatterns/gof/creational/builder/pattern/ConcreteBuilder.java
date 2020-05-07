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
public class ConcreteBuilder extends Builder {
	
	private Productor productor;
	public ConcreteBuilder()
	{
		productor = new Productor();
	}
	@Override
	public void buliderPartA() {
		Part parta = new Part("parta");
		productor.setPartA(parta);
		System.out.println(parta);
	}

	@Override
	public void buliderPartB() {
		Part partb = new Part("partb");
		productor.setPartB(partb);
		System.out.println(partb);
	}

	@Override
	public void buliderPartC() {
		Part partc = new Part("partc");
		productor.setPartC(partc);
		System.out.println(partc);
	}

	public Productor getProductor() {
		return productor;
	}

}