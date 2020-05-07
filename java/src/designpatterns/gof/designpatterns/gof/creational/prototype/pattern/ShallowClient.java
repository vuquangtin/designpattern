package designpatterns.gof.creational.prototype.pattern;

import java.util.ArrayList;

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
public class ShallowClient {

	public static void main(String[] args) {
		ShallowConcretePrototype shallowConcretePrototype = new ShallowConcretePrototype(
				"test");
		System.out.println(shallowConcretePrototype.getlist());

		ShallowConcretePrototype clone_shallowConcretePrototype = shallowConcretePrototype
				.clone();
		clone_shallowConcretePrototype.add("test1");
		System.out.println(clone_shallowConcretePrototype.getlist());
		System.out.println(shallowConcretePrototype.getlist());

	}
}

class ShallowConcretePrototype implements Cloneable {
	public String name;
	private ArrayList<String> allname = new ArrayList<String>();

	public ShallowConcretePrototype(String name) {
		this.name = name;
		this.allname.add(name);
	}

	public void add(String name) {
		this.allname.add(name);
	}

	public ArrayList<String> getlist() {
		return this.allname;
	}

	@Override
	public ShallowConcretePrototype clone() {
		ShallowConcretePrototype self = null;
		try {
			self = (ShallowConcretePrototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return self;
	}

}