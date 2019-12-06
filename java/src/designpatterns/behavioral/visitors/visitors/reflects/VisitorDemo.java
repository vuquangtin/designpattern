package visitors.reflects;

import java.lang.reflect.Method;

//The "element" hierarchy
interface Element {
	void accept(ReflectiveVisitor v);
}

class This implements Element {
	public void accept(ReflectiveVisitor v) {
		v.visit(this);
	}

	public String thiss() {
		return "This";
	}
}

class That implements Element {
	public void accept(ReflectiveVisitor v) {
		v.visit(this);
	}

	public String that() {
		return "That";
	}
}
class Right implements Element {
	public void accept(ReflectiveVisitor v) {
		v.visit(this);
	}

	public String right() {
		return "right";
	}
}
class TheOther implements Element {
	public void accept(ReflectiveVisitor v) {
		v.visit(this);
	}

	public String theOther() {
		return "TheOther";
	}
}

// The "operation" hierarchy
abstract class ReflectiveVisitor {
	abstract public void visit(Object o);

	public void visitTheOther(TheOther e) {
		System.out.println("ReflectiveVisitor: do Base on " + e.theOther());
	}

	// 1. Look for visitElementClassName() in the current class
	// 2. Look for visitElementClassName() in superclasses
	// 3. Look for visitElementClassName() in interfaces
	// 4. Look for visitObject() in current class
	protected Method getMethod(Class<?> source) {
		Class<?> clazz = source;
		Method methodName = null;
		while (methodName == null && clazz != Object.class) {
			String clazzName = clazz.getName();
			clazzName = "visit" + clazzName.substring(clazzName.lastIndexOf('.') + 1);
			try {
				methodName = getClass().getMethod(clazzName, clazz);
			} catch (NoSuchMethodException ex) {
				clazz = clazz.getSuperclass();
			}
		}
		if (clazz == Object.class) {
			// System.out.println( "Searching for interfaces" );
			Class<?>[] interfaces = source.getInterfaces();
			for (Class<?> intface : interfaces) {
				String interfaceName = intface.getName();
				interfaceName = "visit" + interfaceName.substring(interfaceName.lastIndexOf('.') + 1);
				try {
					methodName = getClass().getMethod(interfaceName, intface);
				} catch (NoSuchMethodException ex) {
					// ex.printStackTrace();
				}
			}
		}
		if (methodName == null)
			try {
				methodName = getClass().getMethod("visitObject", Object.class);
			} catch (Exception ex) {
				// ex.printStackTrace();
			}
		return methodName;
	}
}

class UpVisitor extends ReflectiveVisitor {
	public void visit(Object o) {
		try {
			getMethod(o.getClass()).invoke(this, o);
		} catch (Exception ex) {
			System.out.println("UpVisitor - no appropriate visit() method");
		}
	}

	public void visitThis(This element) {
		System.out.println("UpVisitor: do Up on " + element.thiss());
	}

	public void visitObject(Object o) {
		System.out.println("UpVisitor: generic visitObject() method");
	}
}

class DownVisitor extends ReflectiveVisitor {
	public void visit(Object o) {
		try {
			getMethod(o.getClass()).invoke(this, o);
		} catch (Exception ex) {
			System.out.println("DownVisitor - no appropriate visit() method");
		}
	}

	public void visitThat(That element) {
		System.out.println("DownVisitor: do Down on " + element.that());
	}
}
class RightVisitor extends ReflectiveVisitor {
	public void visit(Object o) {
		try {
			getMethod(o.getClass()).invoke(this, o);
		} catch (Exception ex) {
			System.out.println("RightVisitor - no appropriate visit() method");
		}
	}

	public void visitRight(Right element) {
		System.out.println("RightVisitor: do Right on " + element.right());
	}
	public void visitThat(That element) {
		System.out.println("RightVisitor: do Down on " + element.that());
	}
}
/***
 * @see https://sourcemaking.com/design_patterns/visitor/java/2
 * @author admin
 *
 */
public class VisitorDemo {
	public static void main(String[] args) {
		Element[] list = { new This(), new That(), new TheOther(),new Right() };
		UpVisitor up = new UpVisitor();
		DownVisitor down = new DownVisitor();
		RightVisitor right = new RightVisitor();
		for (Element element : list) {
			element.accept(up);
			element.accept(right);
		}
		for (Element element : list) {
			element.accept(down);
		}
	}
}
