package designpatterns.gof.structural.proxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <h1>Proxy</h1> Cung cấp một đối tượng thay thế hoặc giữ chỗ placeholder cho
 * một đối tượng khác để truy xuất đến nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */

public class DynamicProxyDemo {

	public static void main(String[] args) {
		System.out.println("DynamicProxyDemo main");

		// 委托类
		Subject realSubject = new RealSubject();
		InvocationHandler invocationHandler = new ProxyHandler(realSubject);
		// 返回一个运行时反射创建的代理实例
		Subject proxySubject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
				realSubject.getClass().getInterfaces(), invocationHandler);
		proxySubject.doAction();

		/**
		 * 需求：买酒的用户想通过代购公司买酒
		 * 1。代购公司通过Proxy.newProxyInstance动态反射创建一个买酒的代理实例，最终调用帮用户实现买酒操作
		 */
		IBuyWine userWine = new UserWine();
		InvocationHandler handler = new ProxyHandler(userWine);
		// 买酒的代理类实例
		IBuyWine proxyWine = (IBuyWine) Proxy.newProxyInstance(userWine.getClass().getClassLoader(),
				userWine.getClass().getInterfaces(), handler);
		proxyWine.buyWine();

	}
}

/**
 * 可以理解为中介公司 中介公司会派出一个代理实例（动态生成的）
 */
class ProxyHandler implements InvocationHandler {

	private Object object;

	public ProxyHandler(Object o) {
		this.object = o;
	}

	/**
	 * @param proxy
	 *            代理
	 * @param method
	 * @param args
	 *            参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("ProxyHandler invoke before " + "- proxy name:" + proxy.getClass().getName()
				+ "- args.toString():" + args.toString());

		/**
		 * 真正执行的是委托类的方法反射调用
		 */
		method.invoke(object, args);

		System.out.println("ProxyHandler invoke after");
		return null;
	}
}