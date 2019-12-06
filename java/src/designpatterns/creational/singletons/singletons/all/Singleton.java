package singletons.all;

/*
 * A journey to write double checked locking of Singleton class in Java.
 * @see https://codepumpkin.com/double-checked-locking-singleton/
 */

public class Singleton {

	private volatile static Singleton _instance;

	private Singleton() {
		// preventing Singleton object instantiation from outside
	}

	/*
	 * 1st version: creates multiple instance if two thread access this method
	 * simultaneously
	 */

	public static Singleton getInstance() {
		/*
		 * One of the common scenario, where a Singleton class breaks its
		 * contracts is multi-threading. If you ask a beginner to write code for
		 * Singleton design pattern, there is good chance that he will come up
		 * with something like below :
		 * 
		 * and when you point out that this code will create multiple instances
		 * of Singleton class if called by more than one thread parallel, he
		 * would probably make this whole getInstance() method synchronized, as
		 * shown in our 2nd code example getInstanceTS() method.
		 * 
		 * 
		 * 
		 */
		if (_instance == null) {
			_instance = new Singleton();
		}
		return _instance;
	}

	/*
	 * 2nd version : this definitely thread-safe and only creates one instance
	 * of Singleton on concurrent environment but unnecessarily expensive due to
	 * cost of synchronization at every call.
	 */

	public static synchronized Singleton getInstanceTS() {
		/*
		 * Though it’s a thread-safe and solves issue of multiple instance, it's
		 * not very efficient. You need to bear cost of synchronization all the
		 * time you call this method, while synchronization is only needed on
		 * first class, when Singleton instance is created.
		 * 
		 * This will bring us to double checked locking pattern, where only
		 * critical section of code is locked. Programmer call it double checked
		 * locking because there are two checks for _instance == null, one
		 * without locking and other with locking (inside synchronized) block.
		 * 
		 * Here is how double checked locking looks like in Java :
		 * 
		 * 
		 *
		 */
		if (_instance == null) {
			_instance = new Singleton();
		}
		return _instance;
	}

	/*
	 * 3rd version : An implementation of double checked locking of Singleton.
	 * Intention is to minimize cost of synchronization and improve performance,
	 * by only locking critical section of code, the code which creates instance
	 * of Singleton class. By the way this is still broken, if we don't make
	 * _instance volatile, as another thread can see a half initialized instance
	 * of Singleton.
	 */

	public static Singleton getInstanceDC() {
		/*
		 * On surface this method looks perfect, as you only need to pay price
		 * for synchronized block one time, but it still broken, until you make
		 * _instance variable volatile.
		 * 
		 * Without volatile modifier it's possible for another thread in Java to
		 * see half initialized state of _instance variable, but with volatile
		 * variable guaranteeing happens-before relationship, all the write will
		 * happen on volatile _instance before any read of _instance variable.
		 * 
		 * This was not the case prior to Java 5, and that's why double checked
		 * locking was broken before. Now, with happens-before guarantee, you
		 * can safely assume that this will work.
		 * 
		 * By the way this is not the best way to create thread-safe Singleton,
		 * you can use Enum as Singleton, which provides inbuilt thread-safety
		 * during instance creation. Another way is to use static holder
		 * pattern.
		 * 
		 * 
		 */
		if (_instance == null) {
			synchronized (Singleton.class) {
				if (_instance == null) {
					_instance = new Singleton();
				}
			}
		}
		return _instance;
	}
}

// Read more:
// https://javarevisited.blogspot.com/2014/05/double-checked-locking-on-singleton-in-java.html#ixzz5vcN7Yk43