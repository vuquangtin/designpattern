package adapters.player;

/**
 * <h1>Adapter</h1> Chuyển interface của một lớp thành interface khác mà các
 * client mong muốn. Adapter để cho các lớp làm việc với nhau dù có thể các
 * interface không tương thích.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class AdapterPatternDemo {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

		audioPlayer.play(AudioType.MP3.getType(), "beyond the horizon.mp3");
		audioPlayer.play(AudioType.MP4.getType(), "alone.mp4");
		audioPlayer.play(AudioType.VLC.getType(), "far far away.vlc");
		audioPlayer.play("avi", "mind me.avi");
	}
}
