package reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * Các helper method làm việc với Reflections
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Reflects {

	static final ClassLoader CLASS_LOADER = Reflects.class.getClassLoader();

	@SuppressWarnings("unchecked")
	public static <T> Class<T> getClassInstance(T object) {
		return (Class<T>) object.getClass();
	}

	public static <T> T newInstance(Class<T> c) {
		try {
			return c.newInstance();
		} catch (IllegalAccessException | InstantiationException
				| NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T newInstance(String className) {
		try {
			return (T) CLASS_LOADER.loadClass(className).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T newInstance(String className,
			Class<?>[] parameterTypes, Object... parameters) {
		try {
			return (T) CLASS_LOADER.loadClass(className)
					.getConstructor(parameterTypes).newInstance(parameters);
		} catch (InstantiationException | IllegalAccessException
				| InvocationTargetException | NoSuchMethodException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}