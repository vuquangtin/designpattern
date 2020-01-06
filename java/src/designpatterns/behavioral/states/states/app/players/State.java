package states.app.players;

/**
 * Common interface for all states.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class State {
	Player player;

	/**
	 * Context passes itself through the state constructor. This may help a
	 * state to fetch some useful context data if needed.
	 */
	State(Player player) {
		this.player = player;
	}

	public abstract String onPause();

	public abstract String onPlay();

	public abstract String onNext();

	public abstract String onPrevious();
}