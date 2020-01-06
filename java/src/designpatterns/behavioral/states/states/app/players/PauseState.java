package states.app.players;

/**
 * Concrete states provide the special implementation for all interface methods.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class PauseState extends State {

	PauseState(Player player) {
		super(player);
		player.setPlaying(false);
	}

	@Override
	public String onPause() {
		if (player.isPlaying()) {
			player.changeState(new ReadyState(player));
			return "Stop playing";
		} else {
			return "Paused...";
		}
	}

	@Override
	public String onPlay() {
		player.changeState(new ReadyState(player));
		return "Ready";
	}

	@Override
	public String onNext() {
		return "Paused...";
	}

	@Override
	public String onPrevious() {
		return "Paused...";
	}
}