package colleagues;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class Colleague {
	private final Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	public void send(String message) {
		mediator.send(message, this);
	}

	public abstract void receive(String message);
}
