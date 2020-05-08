package designpatterns.gof.book.inline;

import java.util.List;

import com.google.api.client.repackaged.com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CompositePattern implements DesignPatternClient {

	/** 图元和图元的容器(container)抽象 */
	private abstract class Graphic {
		public abstract void draw();

		/** 作为容器的方法，提供模式实现，因为这里大部分子类不需要使用 */
		public void add(Graphic graphic) {
		}

		public void remove(Graphic graphic) {
		}

		public Graphic getChild(int index) {
			return null;
		}
	}

	private class Line extends Graphic {
		@Override
		public void draw() {
			System.out.println("draw Line");
		}
	}

	private class Rectangle extends Graphic {
		@Override
		public void draw() {
			System.out.println("draw Rectangle");
		}
	}

	private class Text extends Graphic {
		@Override
		public void draw() {
			System.out.println("draw Text");
		}
	}

	private class Picture extends Graphic {

		private List<Graphic> children = Lists.newArrayList();

		@Override
		public void draw() {
			System.out.println("draw Picture");

			System.out.println("[children: ");
			for (Graphic graphic : children) {
				graphic.draw();
			}

			System.out.println("]");
		}

		@Override
		public void add(Graphic graphic) {
			children.add(graphic);
		}

		@Override
		public void remove(Graphic graphic) {
			// 太粗糙，需要具体实现类的equals, hashCode
			children.remove(graphic);
		}

		@Override
		public Graphic getChild(int index) {
			return children.get(index);
		}

	}

	@Override
	public void usage() {
		Graphic pictureContainer = new Picture();

		Graphic innerPictureContainer = new Picture();
		innerPictureContainer.add(new Text());
		innerPictureContainer.add(new Line());
		innerPictureContainer.add(new Rectangle());

		pictureContainer.add(innerPictureContainer);
		pictureContainer.add(new Line());
		pictureContainer.add(new Rectangle());

		pictureContainer.draw();
		Graphic child = pictureContainer.getChild(1);
		Preconditions.checkState(child instanceof Line);

		pictureContainer.remove(child);
		child = pictureContainer.getChild(1);
		Preconditions.checkState(child instanceof Rectangle);
	}

	public static void main(String[] args) {
		new CompositePattern().usage();
	}

}