package states.app.INGSW;

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
public class LockedState extends State {

	LockedState(Player player) {
		super(player);
		player.setPlaying(false);
	}

	@Override
	public String onLock() {
		if (player.isPlaying()) {
			player.changeState(new ReadyState(player));
			return "Stop playing";
		} else {
			return "Locked...";
		}
	}

	@Override
	public String onPlay() {
		player.changeState(new ReadyState(player));
		return "Ready";
	}

	@Override
	public String onNext() {
		return "Locked...";
	}

	@Override
	public String onPrevious() {
		return "Locked...";
	}
}