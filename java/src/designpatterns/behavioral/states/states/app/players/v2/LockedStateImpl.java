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
public class LockedStateImpl extends StateImpl {

	public LockedStateImpl(Player player) {

		super(player);
		player.setPlaying(false);
	}

	public String onLock() {

		Player player = getPlayer();

		if (player.isPlaying()) {

			player.changeState(new ReadyStateImpl(player));
			return "Stop playing";
		}

		return locked();
	}

	public String onPlay() {

		getPlayer().changeState(new ReadyStateImpl(getPlayer()));
		return "Ready";
	}

	public String onNext() {

		return locked();
	}

	public String onPrevious() {

		return locked();
	}

	private String locked() {

		return "Locked ...";
	}

}