package adapters.player;

public class VlcPlayer implements AdvancedMediaPlayer {
  @Override
  public void playVlc(String fileName) {
    System.out.println("Playing " + AudioType.VLC.getType() + " file. Name: " + fileName);
  }

  @Override
  public void playMp4(String fileName) {
    // do nothing
  }
}
