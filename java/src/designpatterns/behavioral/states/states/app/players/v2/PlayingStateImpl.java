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
public class PlayingStateImpl extends StateImpl {

	public PlayingStateImpl(Player player) {

		super(player);
	}

	public String onLock() {

		Player player = getPlayer();
		player.changeState(new LockedStateImpl(player));
		player.setCurrentTrackAfterStop();
		return "Stop playing";
	}

	public String onPlay() {

		getPlayer().changeState(new ReadyStateImpl(getPlayer()));
		return "Paused...";
	}

	public String onNext() {

		return getPlayer().nextTrack();
	}

	public String onPrevious() {

		return getPlayer().previousTrack();
	}
}