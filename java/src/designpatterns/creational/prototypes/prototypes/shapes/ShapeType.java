package prototypes.shapes;

public enum ShapeType {
  CIRCLE("1"), SQUARE("2"), RECTANGLE("3");

  private String id;

  private ShapeType(String id) {
    this.id = id;
  }

  String getId() {
    return id;
  }
}
