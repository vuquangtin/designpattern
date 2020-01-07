package singletons.inits;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBreakSingleton {
	public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
         
		EagerInitialization instanceOne = EagerInitialization.getInstance();
		EagerInitialization instanceTwo = null;
 
        Constructor<?>[] constructors = EagerInitialization.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            instanceTwo = (EagerInitialization) constructor.newInstance();
        }
 
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
