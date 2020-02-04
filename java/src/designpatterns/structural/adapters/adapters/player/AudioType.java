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
