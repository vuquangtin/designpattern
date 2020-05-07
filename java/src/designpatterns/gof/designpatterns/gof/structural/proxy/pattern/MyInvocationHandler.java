package designpatterns.gof.structural.proxy.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
public class MyInvocationHandler implements InvocationHandler {
	private Object obj;

	public MyInvocationHandler(Object _obj) {
		this.obj = _obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(this.obj, args);
	}
}