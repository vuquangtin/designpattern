package designpatterns.gof.structural.proxy.demo;

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
public class SubjectProxy extends DynamicProxy {

	public static <T> T newProxyInstance(Subject subject) {
		ClassLoader classLoader = subject.getClass().getClassLoader();
		Class<?>[] interfaces = subject.getClass().getInterfaces();
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(
				subject);
		return newProxyInstance(classLoader, interfaces, myInvocationHandler);
	}
}