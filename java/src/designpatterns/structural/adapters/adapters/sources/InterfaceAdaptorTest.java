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
public class InterfaceAdaptorTest {
	@Test
	public void testMain() {
		SourceWrp1 sourceWrp1 = new SourceWrp1();
		SourceWrp2 sourceWrp2 = new SourceWrp2();
		sourceWrp1.method1();
		sourceWrp1.method2();
		sourceWrp2.method1();
		sourceWrp2.method2();
	}
}
