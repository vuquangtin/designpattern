package adapters.gof.objects;

class AdapterRectangle implements Figure {

  private Rectangle rectangle = new Rectangle();

  public String draw() {
    return rectangle.drawRectangle();
  }
}
