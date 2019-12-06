package singletons.all;

public class SingletonLanhan {

	private static SingletonLanhan mSingletonLanhan = null;

	private SingletonLanhan() {

	}

	public static SingletonLanhan getInstance() {

		if (mSingletonLanhan == null) {
			mSingletonLanhan = new SingletonLanhan();
		}
		return mSingletonLanhan;
	}
}
