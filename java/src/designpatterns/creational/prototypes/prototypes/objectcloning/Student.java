package prototypes.objectcloning;

/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Student {
	int id;
	String name;

	Student() {

	}

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void show() {
		System.out.println("Student [id=" + id + ", name=" + name + "]");
	}
}