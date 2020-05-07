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
public class DeepClient {

	public static void main(String[] args) {
		DeepConcretePrototype deepConcretePrototype = new DeepConcretePrototype(
				"test");
		System.out.println(deepConcretePrototype.getlist());

		DeepConcretePrototype clone_deepConcretePrototype = deepConcretePrototype
				.clone();
		clone_deepConcretePrototype.add("test1");
		System.out.println(clone_deepConcretePrototype.getlist());
		System.out.println(deepConcretePrototype.getlist());

	}
}

class DeepConcretePrototype implements Cloneable {
	public String name;
	private ArrayList<String> allname = new ArrayList<String>();

	public DeepConcretePrototype(String name) {
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
	public DeepConcretePrototype clone() {
		DeepConcretePrototype self = null;
		try {
			self = (DeepConcretePrototype) super.clone();
			self.allname = (ArrayList<String>) this.allname.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return self;
	}

}