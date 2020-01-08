package visitors.animals;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Dracula implements Monster {

	public void hitBy(Warrior warrior) {
		damaged(10);
	}

	public void hitBy(Wizard wizard) {
		damaged(80);
	}

	public void damaged(int hp) {
		System.out.println("Owie! I lost " + hp + "hp ᙙᙖ");
	}

}
