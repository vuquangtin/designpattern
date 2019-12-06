package adapters.player;

public class AudioPlayer implements MediaPlayer {
  MediaAdapter mediaAdapter;

  @Override
  public void play(String audioType, String fileName) {

    // inbuilt support to play mp3 music files
    if (audioType.equalsIgnoreCase(AudioType.MP3.getType())) {
      System.out.println("Playing " + AudioType.MP3.getType() + " file. Name: " + fileName);
    }

    // mediaAdapter is providing support to play other file formats
    else if (audioType.equalsIgnoreCase(AudioType.VLC.getType())
        || audioType.equalsIgnoreCase(AudioType.MP4.getType())) {
      mediaAdapter = new MediaAdapter(audioType);
      mediaAdapter.play(audioType, fileName);
    }

    else {
      System.out.println("Invalid media. " + audioType + " format not supported");
    }
  }
}
