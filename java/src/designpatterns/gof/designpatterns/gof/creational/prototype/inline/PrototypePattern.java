package designpatterns.gof.creational.prototype.inline;


/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
/**
 * 客户端代码
 */
public class PrototypePattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		ConcretePrototype1 p1 = new ConcretePrototype1("I");
		ConcretePrototype1 c1 = (ConcretePrototype1) p1.clone();
		System.out.println("Cloned():" + c1.getId());
	}
}

/**
 * 具体原型类
 */
class ConcretePrototype1 implements Cloneable {

	private String id;

	public ConcretePrototype1(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
