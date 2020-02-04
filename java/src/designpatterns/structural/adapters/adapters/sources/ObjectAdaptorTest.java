package adapters.sources;

import org.junit.Test;

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
public class ObjectAdaptorTest {

	@Test
	public void testMain() {
		Source source = new Source();
		Targetable a = new Wrapper(source);
		a.method1();
		a.method2();
	}
}
