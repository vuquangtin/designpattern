package delegation.playlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Playlist {
	private Map<String, String> songs;

	public Playlist() {
		songs = new HashMap<String, String>();
	}

	public void addSong(String location, String title) {
		songs.put(location, title);

	}

	public String getM3U() {
		String m3u = "#EXTM3U\n\n";
		for (Map.Entry<String, String> m : songs.entrySet()) {
			if (m.getKey().endsWith(".mp3")) {
				System.out.println(m.getKey() + " " + m.getValue());
				m3u += "#EXTINF:-1,{$song[" + m.getValue() + "]}\n";
				m3u += "{$song[" + m.getKey() + "]}\n";
			}
		}

		return m3u;
	}

	public String getPLS() {
		String pls = "[playIist]\nNumberOfEntries=" + this.songs.size()
				+ "\n\n";
		int counter = 0;
		for (Map.Entry<String, String> m : songs.entrySet()) {
			counter = counter + 1;
			pls += "File{" + counter + "}={" + m.getKey() + "}\n";
			pls += "Title{" + counter + "}={" + m.getValue() + "}\n";
			pls += "Length{" + counter + "}=-1\n\n";
		}
		return pls;
	}
}