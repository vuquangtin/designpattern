package singletons.all;

public class Test {
	public static void main(String[] args) {
        SingletonClass.getInstance();
        SingletonEhan.getInstance();
        SingletonVolatile.getSingletonVolatile();
        SingletonSync.getSingletonSync();
        SingletonTwoSync.getSingletonSync();
        SingletonLanhan.getInstance();
    }
}
