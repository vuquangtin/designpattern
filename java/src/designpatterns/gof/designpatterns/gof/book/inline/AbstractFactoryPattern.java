package designpatterns.gof.book.inline;

import com.google.api.client.repackaged.com.google.common.base.Preconditions;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.AbstractFactory, description = "抽象工厂")
public class AbstractFactoryPattern implements DesignPatternClient {

	/** 抽象工厂 */
	private interface WidgetFactory {
		Window createWindow();

		ScrollBar createScrollBar();
	}

	/** Motif具体工厂 */
	private class MotifWidgetFactory implements WidgetFactory {

		@Override
		public Window createWindow() {
			return new MotifWindow();
		}

		@Override
		public ScrollBar createScrollBar() {
			return new MotifiScrollBar();
		}
	}

	/** PM具体工厂 */
	private class PMWidgetFactory implements WidgetFactory {

		@Override
		public Window createWindow() {
			return new PMWindow();
		}

		@Override
		public ScrollBar createScrollBar() {
			return new PMScrollBar();
		}
	}

	/** 窗体抽象产品 */
	private interface Window {
	}

	private class MotifWindow implements Window {
	}

	private class PMWindow implements Window {
	}

	/** 滚动条抽象产品 */
	private interface ScrollBar {
	}

	private class MotifiScrollBar implements ScrollBar {
	}

	private class PMScrollBar implements ScrollBar {
	}

	/** 只使用抽象工厂和抽象产品 */
	@Override
	public void usage() {
		// 1 Motif
		WidgetFactory motifWidgetFactory = new MotifWidgetFactory();// 注入

		Window motifWindow = motifWidgetFactory.createWindow();
		ScrollBar motifScrollBar = motifWidgetFactory.createScrollBar();
		Preconditions.checkState(motifWindow instanceof MotifWindow);// 检查运行时实例
		Preconditions.checkState(motifScrollBar instanceof MotifiScrollBar);

		// 2 PM
		WidgetFactory pMWidgetFactory = new PMWidgetFactory();
		Window pMwindow = pMWidgetFactory.createWindow();
		ScrollBar pMscrollBar = pMWidgetFactory.createScrollBar();
		Preconditions.checkState(pMwindow instanceof PMWindow);
		Preconditions.checkState(pMscrollBar instanceof PMScrollBar);
	}

	public static void main(String[] args) {
		new AbstractFactoryPattern().usage();
	}

}
