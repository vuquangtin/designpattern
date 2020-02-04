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
public class AudioPlayer implements MediaPlayer {
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {

		// inbuilt support to play mp3 music files
		if (audioType.equalsIgnoreCase(AudioType.MP3.getType())) {
			System.out.println("Playing " + AudioType.MP3.getType()
					+ " file. Name: " + fileName);
		}

		// mediaAdapter is providing support to play other file formats
		else if (audioType.equalsIgnoreCase(AudioType.VLC.getType())
				|| audioType.equalsIgnoreCase(AudioType.MP4.getType())) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}

		else {
			System.out.println("Invalid media. " + audioType
					+ " format not supported");
		}
	}
}
