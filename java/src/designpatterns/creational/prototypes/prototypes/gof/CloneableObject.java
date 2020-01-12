package prototypes.gof;

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
public class CloneableObject extends CloneableObjectPrototype {

	private final int ID;

	public CloneableObject(int id) {
		ID = id;
	}

	public CloneableObjectPrototype clone() {
		return new CloneableObject(ID);
	}

	public int getId() {
		return ID;
	}
}