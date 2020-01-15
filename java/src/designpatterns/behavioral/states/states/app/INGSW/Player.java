package states.app.INGSW;

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
	private boolean playing = false;
	private List<String> playlist = new ArrayList<>();
	private int currentTrack = 0;

	public Player() {
		this.state = new ReadyState(this);
		setPlaying(true);
		for (int i = 1; i <= 12; i++) {
			playlist.add("Track " + i);
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
		return "Playing " + playlist.get(currentTrack);
	}

	public String nextTrack() {
		currentTrack++;
		if (currentTrack > playlist.size() - 1) {
			currentTrack = 0;
		}
		return "Playing " + playlist.get(currentTrack);
	}

	public String previousTrack() {
		currentTrack--;
		if (currentTrack < 0) {
			currentTrack = playlist.size() - 1;
		}
		return "Playing " + playlist.get(currentTrack);
	}

	public void setCurrentTrackAfterStop() {
		this.currentTrack = 0;
	}
}