package states.app.players.v2;

/**
 * <h1>State</h1> cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính
 * nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class StateImpl implements State {

	private Player player;

	/**
	 * Context passes itself through the state constructor. This may help a
	 * state to fetch some useful context data if needed.
	 */
	protected StateImpl(Player player) {

		this.player = player;
	}

	public Player getPlayer() {

		return player;
	}
}