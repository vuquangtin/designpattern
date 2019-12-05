package colleagues;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Vova extends Colleague {
	public Vova(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void receive(String message) {
		System.out.println("Vova received: " + message);
	}
}
