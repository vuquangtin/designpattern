package flyweights.shapes;

import java.util.ArrayList;
import java.util.List;


public class FlyweightPatternDemo {
  private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};

  public static void main(String[] args) {
    List<Circle> circles = new ArrayList<Circle>();

    for (int i = 0; i < 20; ++i) {
      Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
      circle.setX(getRandomX());
      circle.setY(getRandomY());
      circle.setRadius(100);
      circle.draw();
      circles.add(circle);
    }

    System.out.println("\nThe actual values of all drawed circles because of only " + colors.length
        + " object exist all the time");
    for (Circle circle : circles) {
      circle.draw();
    }
  }

  private static String getRandomColor() {
    return colors[(int) (Math.random() * colors.length)];
  }

  private static int getRandomX() {
    return (int) (Math.random() * 100);
  }

  private static int getRandomY() {
    return (int) (Math.random() * 100);
  }
}
