package designpatterns.gof.book.inline;

import com.google.api.client.repackaged.com.google.common.base.Preconditions;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Adapter</h1> Chuyển interface của một lớp thành interface khác mà các
 * client mong muốn. Adapter để cho các lớp làm việc với nhau dù có thể các
 * interface không tương thích.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.AdapterO, description = "适配器")
public class AdaptorPattern implements DesignPatternClient {

	private class DrawingEditor {
		public Shape lineShape;
		public Shape textShape;
	}

	/** 已有实现类：需要被适配的类 */
	private class TextView {
		public TextExtent getExtent() {
			TextExtent result = new TextExtent();
			result.x = 1;
			result.y = 1;
			return result;
		}
	}

	/** 文本范围，体现接口不兼容 */
	private class TextExtent {
		public int x;
		public int y;
	}

	/** 形状抽象类 */
	private abstract class Shape {
		public abstract BoxArea boundingBox();

		public abstract ShapeManipulator createManipulator();
	}

	/** 形状区域 */
	private class BoxArea {
		public float x;
		public float y;
	}

	/** 形状处理器指示型接口 */
	private interface ShapeManipulator {
	}

	private class TextManipulator implements ShapeManipulator {
	}

	private class LineManipulator implements ShapeManipulator {
	}

	/** 具体的形状实现类 */
	private class Line extends Shape {

		@Override
		public BoxArea boundingBox() {
			BoxArea result = new BoxArea();
			result.x = 0.0f;
			result.y = 0.0f;
			return result;
		}

		@Override
		public LineManipulator createManipulator() {
			return new LineManipulator();
		}
	}

	/** 具体的形状类，需要适配已实现的类{@link TextView} */
	private class TextShape extends Shape {

		/** 需要被适配类的实例 */
		private TextView textView;

		public TextShape(TextView textView) {
			this.textView = textView;
		}

		@Override
		public BoxArea boundingBox() {
			// 处理适配工作
			BoxArea result = new BoxArea();
			TextExtent textExtent = textView.getExtent();
			result.x = textExtent.x;
			result.y = textExtent.y;

			return result;
		}

		@Override
		public TextManipulator createManipulator() {
			return new TextManipulator();
		}
	}

	@Override
	public void usage() {
		DrawingEditor editor = new DrawingEditor();
		editor.lineShape = new Line();
		TextView textView = new TextView();
		editor.textShape = new TextShape(textView);

		BoxArea boxArea = editor.lineShape.boundingBox();
		Preconditions.checkState(boxArea.x == 0.0f);
		Preconditions.checkState(boxArea.y == 0.0f);

		// 隐式调用被适配对象的方法
		boxArea = editor.textShape.boundingBox();
		Preconditions.checkState(boxArea.x == 1.0f);
		Preconditions.checkState(boxArea.y == 1.0f);
	}

	public static void main(String[] args) {
		new AdaptorPattern().usage();
	}

}