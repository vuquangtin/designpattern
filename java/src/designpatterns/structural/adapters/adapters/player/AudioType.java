package adapters.player;

public enum AudioType {
  MP3("mp3"), MP4("mp4"), VLC("vlc");

  String type;

  private AudioType(String type) {
    this.type = type;
  }

  String getType() {
    return type;
  }

}
