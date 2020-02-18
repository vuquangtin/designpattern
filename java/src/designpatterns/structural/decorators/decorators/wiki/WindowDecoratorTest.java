package decorators.wiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */

public class WindowDecoratorTest {
	@Test
	public void testWindowDecoratorTest() {
		Window decoratedWindow = new HorizontalScrollBarDecorator(
				new VerticalScrollBarDecorator(new SimpleWindow()));
		// assert that the description indeed includes horizontal + vertical
		// scrollbars
		assertEquals(
				"simple window, including vertical scrollbars, including horizontal scrollbars",
				decoratedWindow.getDescription());
	}
}