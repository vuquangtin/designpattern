package visitors.SingleDispatchandDoubleDispatchs;

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
public class Girl {
	public static void main(final String[] args) {
        Girl hotGirl = new HotGirl();
        Men ladyKiller = new LadyKiller();
        ladyKiller.kiss(hotGirl);
    }
}

class HotGirl extends Girl {
}

class Men {
	public void kiss(HotGirl hotGirl) {
		System.out.println("a Men kissed a Hot girl");
	}

	public void kiss(Girl girl) {
		System.out.println("a Men kissed a Girl");
	}
}

class LadyKiller extends Men {
	@Override
	public void kiss(HotGirl hotGirl) {
		System.out.println("a LadyKiller kissed a Hot girl");
	}

	@Override
	public void kiss(Girl girl) {
		System.out.println("a LadyKiller kissed a Girl");
	}
}