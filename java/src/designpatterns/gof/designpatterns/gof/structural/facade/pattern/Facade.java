package designpatterns.gof.structural.facade.pattern;

import designpatterns.gof.structural.facade.pattern.sub.system.InterfaceB;
import designpatterns.gof.structural.facade.pattern.sub.system.InterfaceBImpl;
import designpatterns.gof.structural.facade.pattern.sub.system.ModuleA;
import designpatterns.gof.structural.facade.pattern.sub.system.SubClassC;
import designpatterns.gof.structural.facade.pattern.sub.system.SuperClassC;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn. <br/>
 * Provide a unified interface to a set of interfaces in a subsystem. Facade
 * Pattern defines a higher-level interface that makes the subsystem easier to
 * use. <br/>
 * Important Points:
 * <ul>
 * <li>Facade pattern is more like a helper for client applications, it doesn’t
 * hide subsystem interfaces from the client. Whether to use Facade or not is
 * completely dependent on client code.</li>
 * <li>Facade pattern can be applied at any point of development, usually when
 * the number of interfaces grow and system gets complex.</li>
 * <li>Subsystem interfaces are not aware of Facade and they shouldn’t have any
 * reference of the Facade interface.</li>
 * <li>Facade pattern should be applied for similar kind of interfaces, its
 * purpose is to provide a single interface rather than multiple interfaces that
 * does the similar kind of jobs.</li>
 * <li>We can use Factory pattern with Facade to provide better interface to
 * client systems</li>
 * </ul>
 * Notice that using Facade interface is a lot easier and cleaner way and avoid
 * having a lot of logic at client side.
 * 
 * JDBC Driver Manager Class to get the database connection is a wonderful
 * example of facade pattern.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Facade {
	private ModuleA moduleA;
	private InterfaceB interfaceB;
	private SuperClassC classC;

	public Facade() {
		moduleA = new ModuleA();
		interfaceB = new InterfaceBImpl();
		classC = new SubClassC();
	}

	public void run() {
		moduleA.methodA();
		interfaceB.methodB();
		classC.methodC();
	}
}