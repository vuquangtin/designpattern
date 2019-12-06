package mediators.colleagues;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
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
