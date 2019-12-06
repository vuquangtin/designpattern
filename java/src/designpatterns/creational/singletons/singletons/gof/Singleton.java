package singletons.gof;

class Singleton {

	private static Singleton instance;

	private Singleton() {
	}

	public static synchronized Singleton getInstance() {
		if (instance == null) {
			Singleton.instance = new Singleton();
		}

		return instance;
	}

	protected String doSomething() {
		return "I do something";
	}
}