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
public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {

		if (audioType.equalsIgnoreCase(AudioType.VLC.getType())) {
			advancedMusicPlayer = new VlcPlayer();

		} else if (audioType.equalsIgnoreCase(AudioType.MP4.getType())) {
			advancedMusicPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileName) {

		if (audioType.equalsIgnoreCase(AudioType.VLC.getType())) {
			advancedMusicPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase(AudioType.MP4.getType())) {
			advancedMusicPlayer.playMp4(fileName);
		}
	}
}
