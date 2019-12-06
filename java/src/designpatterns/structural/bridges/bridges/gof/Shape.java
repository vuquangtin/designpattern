package bridges.gof;

abstract class Shape {

  protected DrawProgram drawProgram;

  public Shape(DrawProgram drawProgram) {
    this.drawProgram = drawProgram;
  }

  public abstract String draw();
}