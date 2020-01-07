package states.app.players.v2;

import java.util.ArrayList;
import java.util.List;

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
public class Player {

	private State state;
	private boolean playing = true;
	private List<String> playList = new ArrayList<String>();
	private int currentTrack = 0;

	public Player() {

		this.state = new ReadyStateImpl(this);
		setPlaying(true);
		for (int i = 0; i <= 12; i++) {
			playList.add("Track " + i);
		}
	}

	public void changeState(State state) {

		this.state = state;
	}

	public State getState() {

		return state;
	}

	public void setPlaying(boolean playing) {

		this.playing = playing;
	}

	public boolean isPlaying() {

		return playing;
	}

	public String startPlayback() {

		return getCurrentTrack();
	}

	public String nextTrack() {

		currentTrack++;
		if (currentTrack > maxPlaylist()) {
			currentTrack = 0;
		}
		return getCurrentTrack();
	}

	public String previousTrack() {

		currentTrack--;
		if (currentTrack < 0) {
			currentTrack = maxPlaylist();
		}
		return getCurrentTrack();
	}

	public void setCurrentTrackAfterStop() {

		this.currentTrack = 0;
	}

	private String getCurrentTrack() {

		return "Playing " + playList.get(currentTrack);
	}

	private int maxPlaylist() {

		return playList.size() - 1;
	}
}