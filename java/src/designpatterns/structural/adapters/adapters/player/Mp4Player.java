package adapters.player;

public class Mp4Player implements AdvancedMediaPlayer {

  @Override
  public void playVlc(String fileName) {
    // do nothing
  }

  @Override
  public void playMp4(String fileName) {
    System.out.println("Playing " + AudioType.MP4.getType() + " file. Name: " + fileName);
  }
}
