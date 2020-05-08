package designpatterns.gof.book.inline;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Proxy</h1> Cung cấp một đối tượng thay thế hoặc giữ chỗ placeholder cho
 * một đối tượng khác để truy xuất đến nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.Proxy, description = "代理")
public class ProxyPattern implements DesignPatternClient {

	private class DocumentEditor {
		public Graphic imageGraphic;
	}

	private interface Graphic {
		public void draw();

		public byte[] getExtent();

		public void store();

		public void load();
	}

	/** 被代理的类 */
	private class Image implements Graphic {

		private byte[] extent;

		@Override
		public void draw() {
			System.out.println("Image#draw");
		}

		@Override
		public byte[] getExtent() {
			System.out.println("Image#getExtent");
			return extent;
		}

		@Override
		public void store() {
			System.out.println("Image#store");
		}

		@Override
		public void load() {
			System.out.println("Image#load");
			extent = new byte[] { 1, 2, 3, 4 };
		}
	}

	/** 代理类 */
	private class ImageProxy implements Graphic {

		/** 被代理的对象 */
		private Image image;

		private byte[] extent;
		private String fileName;

		@Override
		public void draw() {
			if (image == null) {
				image = loadImage(fileName);
			}

			image.draw();
		}

		@Override
		public byte[] getExtent() {
			if (image == null) {
				image = loadImage(fileName);
			}

			extent = image.getExtent();

			return extent;
		}

		@Override
		public void store() {
			if (image == null) {
				image = loadImage(fileName);
			}

			image.store();
		}

		@Override
		public void load() {
			if (image == null) {
				image = loadImage(fileName);
			}

			image.load();
		}

		private Image loadImage(String fileName) {
			// 省略fileName => Image的逻辑
			return new Image();
		}

	}

	@Override
	public void usage() {
		DocumentEditor editor = new DocumentEditor();
		editor.imageGraphic = new ImageProxy();

		editor.imageGraphic.load();
		editor.imageGraphic.getExtent();

		editor.imageGraphic.draw();

		editor.imageGraphic.store();

	}

	public static void main(String[] args) {
		new ProxyPattern().usage();
	}

}