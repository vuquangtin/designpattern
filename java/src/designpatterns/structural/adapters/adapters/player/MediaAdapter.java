package adapters.player;

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
