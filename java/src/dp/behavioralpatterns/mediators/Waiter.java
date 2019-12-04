package dp.behavioralpatterns.mediators;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class Waiter {
	public String country;
	private Mediator mediator;

	Waiter(String country) {
		this.country = country;
	}

	public abstract void say();

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}

class ChineseWaiter extends Waiter {

	public ChineseWaiter() {
		super("chinese");
	}

	@Override
	public void say() {
		System.out.println("世界，你好");
	}

}

class EnglishWaiter extends Waiter {

	public EnglishWaiter() {
		super("english");
	}

	@Override
	public void say() {
		System.out.println("hello world!");
	}

}

class GermanWaiter extends Waiter {

	public GermanWaiter() {
		super("german");
	}

	@Override
	public void say() {
		System.out.println("Hallo Welt");
	}

}