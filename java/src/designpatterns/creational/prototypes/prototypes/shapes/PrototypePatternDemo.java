package prototypes.shapes;

public class PrototypePatternDemo {
  private static final String SHAPE = "Shape : ";
  private static final String ORDINAL = " ordinal : ";

  public static void main(String[] args) {
    ShapeCache.loadCache();

    Shape clonedShape = ShapeCache.getShape(ShapeType.CIRCLE.getId());
    System.out.println(SHAPE + clonedShape.getType());

    Shape clonedShape2 = ShapeCache.getShape(ShapeType.SQUARE.getId());
    System.out.println(SHAPE + clonedShape2.getType());

    Shape clonedShape3 = ShapeCache.getShape(ShapeType.RECTANGLE.getId());
    System.out.println(SHAPE + clonedShape3.getType());

    // it will be not change the further new clones id
    clonedShape.setId("4");
    clonedShape2.setId("5");
    clonedShape3.setId("6");

    Shape clonedShape4 = ShapeCache.getShape("1");
    System.out.println(SHAPE + clonedShape4.getType());
    System.out.println(SHAPE + clonedShape4.getId());

    Shape clonedShape5 = ShapeCache.getShape("2");
    System.out.println(SHAPE + clonedShape5.getType());
    System.out.println(SHAPE + clonedShape5.getId());

    Shape clonedShape6 = ShapeCache.getShape("3");
    System.out.println(SHAPE + clonedShape6.getType());
    System.out.println(SHAPE + clonedShape6.getId());

    System.out.println("\nCloned objects changed Ids:");
    System.out.println(SHAPE + clonedShape.getType());
    System.out.println(SHAPE + clonedShape.getId());
    System.out.println(SHAPE + clonedShape2.getType());
    System.out.println(SHAPE + clonedShape2.getId());
    System.out.println(SHAPE + clonedShape3.getType());
    System.out.println(SHAPE + clonedShape3.getId());

    System.out.println("\nOrdinals of the types:");
    System.out.println(ShapeType.CIRCLE + ORDINAL + ShapeType.CIRCLE.ordinal());
    System.out.println(ShapeType.SQUARE + ORDINAL + ShapeType.SQUARE.ordinal());
    System.out.println(ShapeType.RECTANGLE + ORDINAL + ShapeType.RECTANGLE.ordinal());
  }
}
