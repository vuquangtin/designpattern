package bridges.share;

public class YellowCircle implements DrawAPI {

  @Override
  public void drawCircle(int radius, int x, int y) {
    System.out.println("Drawing Circle[ color: yellow, radius: " + radius + ", x: " + x + ", " + y
        + "]");
  }

}
