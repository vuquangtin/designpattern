package delegation.playlist;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Main {

	public static void main(String[] args) {
		Playlist playlist = new Playlist();
		playlist.addSong("http://allaravel/music/song_1.mp3", "Song 1");
		playlist.addSong("http://allaravel/music/song_2.mp3", "Song 2");
		String externalRetrievedType = "pls";
		String playlistContent;
		if (externalRetrievedType == "pls") {
			playlistContent = playlist.getPLS();
		} else {
			playlistContent = playlist.getM3U();
		}
		System.out.println(playlistContent);

	}
}
