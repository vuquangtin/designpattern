package adapters.player;

public class AdapterPatternDemo {
  public static void main(String[] args) {
    AudioPlayer audioPlayer = new AudioPlayer();

    audioPlayer.play(AudioType.MP3.getType(), "beyond the horizon.mp3");
    audioPlayer.play(AudioType.MP4.getType(), "alone.mp4");
    audioPlayer.play(AudioType.VLC.getType(), "far far away.vlc");
    audioPlayer.play("avi", "mind me.avi");
  }
}
