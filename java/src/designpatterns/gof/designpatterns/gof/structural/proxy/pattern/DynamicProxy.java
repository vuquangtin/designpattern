package designpatterns.gof.structural.proxy.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

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
public class DynamicProxy<T> {

	public static <T> T newProxyInstance(ClassLoader classLoader,
			Class<?>[] interfaces, InvocationHandler invocationHandler) {
		return (T) Proxy.newProxyInstance(classLoader, interfaces,
				invocationHandler);
	}
}