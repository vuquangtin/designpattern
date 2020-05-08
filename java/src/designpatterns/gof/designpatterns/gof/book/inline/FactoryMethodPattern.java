package designpatterns.gof.book.inline;

import java.util.List;
import java.util.Set;

import com.google.api.client.util.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.Factory Pattern giao việc khởi
 * tạo một đối tượng cụ thể cho lớp con.
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.FactoryMethod, description = "工厂方法")
public class FactoryMethodPattern implements DesignPatternClient {

	/** 应用 */
	private abstract class Application {

		private Set<Document> documents = Sets.newHashSet();

		/** 工厂方法 */
		protected abstract Document createDocument();

		/** 新建文档 */
		public Document newDocument() {
			Document document = createDocument();// 调用工厂方法
			documents.add(document);

			document.open();
			return document;
		}

		/** 打开文档 */
		public void openDocument(Document document) {
			documents.add(document);

			document.open();
		}
	}

	private class DrawingApplication extends Application {
		@Override
		protected Document createDocument() {
			return new DrawingDocument();
		}
	}

	private class ConsoleApplication extends Application {

		@Override
		protected Document createDocument() {
			return new ConsoleDocument();
		}
	}

	/** 文档 */
	private abstract class Document {
		private List<String> contents = Lists.newArrayList();

		/** 打开 */
		public abstract void open();

		/** 关闭 */
		public abstract void close();

		/** 保存 */
		public void save() {
			System.out.println("保存文档...");
		}

		/** 追加内容 */
		public void append(String literal) {
			contents.add(literal);
		}

	}

	private class DrawingDocument extends Document {

		@Override
		public void open() {
			System.out.println(this.getClass().getCanonicalName() + "打开...");
		}

		@Override
		public void close() {
			System.out.println(this.getClass().getCanonicalName() + "关闭...");
		}

	}

	private class ConsoleDocument extends Document {

		@Override
		public void open() {
			System.out.println(this.getClass().getCanonicalName() + "打开...");
		}

		@Override
		public void close() {
			System.out.println(this.getClass().getCanonicalName() + "关闭...");
		}
	}

	@Override
	public void usage() {
		Application drawingApplication = new DrawingApplication();
		Document drawingDocument = drawingApplication.newDocument();
		Preconditions.checkState(drawingDocument instanceof DrawingDocument);
		drawingDocument.append("hello, there");
		drawingDocument.save();
		drawingDocument.close();

		drawingApplication.openDocument(drawingDocument);

		Application consoleApplication = new ConsoleApplication();
		Document consoleDocument = consoleApplication.newDocument();
		Preconditions.checkState(consoleDocument instanceof ConsoleDocument);
		consoleDocument.append("hello, there");
		consoleDocument.save();
		consoleDocument.close();
	}

	public static void main(String[] args) {
		new FactoryMethodPattern().usage();
	}

}
