package bridges.share;

public class BridgePatternDemo {
  public static void main(String[] args) {
    Shape redCircle = new Circle(100, 100, 10, new RedCircle());
    Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
    Shape yellowCircle = new Circle(100, 100, 10, new YellowCircle());

    redCircle.draw();
    greenCircle.draw();
    yellowCircle.draw();
  }
}
