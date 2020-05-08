package designpatterns.gof.book.inline;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

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
@DesignPattern(value = Pattern.Prototype, description = "原型")
public class PrototypePattern implements DesignPatternClient {

	/** 工具客户端，使用prototype对象 */
	private interface Tool {
		/** 使用克隆原型出的新对象做处理 */
		public void mantipulate();
	}

	private class GraphicTool implements Tool {

		private Graphic[] graphics;

		public GraphicTool(Graphic... graphics) {
			this.graphics = graphics;
		}

		@Override
		public void mantipulate() {
			for (Graphic graphic : graphics) {
				Graphic newGraphic = graphic._clone();
				System.out.println("克隆出新的对象：" + newGraphic);
			}
		}
	}

	private class RotateTool implements Tool {

		private Staff staff;

		public RotateTool(Staff staff) {
			this.staff = staff;
		}

		@Override
		public void mantipulate() {
			Staff newStaff = staff._clone();
			System.out.println("克隆出新的对象：" + newStaff);
		}

	}

	/** 原型对象：图形工具 */
	private interface Graphic {
		/** 克隆：深度拷贝 */
		Graphic _clone();
	}

	private class Staff implements Graphic {

		// 返回值不属于方法签名的一部分
		@Override
		public Staff _clone() {
			Staff staff = new Staff();
			// ... 深度拷贝
			return staff;
		}
	}

	private interface MusicNote extends Graphic {
	}

	private class WholeNote implements MusicNote {

		@Override
		public WholeNote _clone() {
			WholeNote wholeNote = new WholeNote();
			// ... 深度拷贝
			return wholeNote;
		}
	}

	private class HalfNote implements MusicNote {

		@Override
		public HalfNote _clone() {
			HalfNote halfNote = new HalfNote();
			// ... 深度拷贝
			return halfNote;
		}
	}

	@Override
	public void usage() {
		Tool graphicTool = new GraphicTool(new HalfNote(), new HalfNote(),
				new WholeNote(), new HalfNote());
		graphicTool.mantipulate();

		System.out.println();

		Tool rotateTool = new RotateTool(new Staff());
		rotateTool.mantipulate();
	}

	public static void main(String[] args) {
		new PrototypePattern().usage();
	}

}
