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

public class ReadyStateImpl extends StateImpl {

	public ReadyStateImpl(Player player) {

		super(player);
	}

	public String onLock() {

		Player player = getPlayer();
		player.changeState(new LockedStateImpl(player));
		return "Locked ...";
	}

	public String onPlay() {

		Player player = getPlayer();
		String action = player.startPlayback();
		player.changeState(new PlayingStateImpl(player));
		return action;
	}

	public String onNext() {

		return "Locked ...";
	}

	public String onPrevious() {

		return "Locked ...";
	}

}
