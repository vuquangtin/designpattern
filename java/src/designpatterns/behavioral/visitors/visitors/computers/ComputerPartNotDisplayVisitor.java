package visitors.computers;

public class ComputerPartNotDisplayVisitor implements ComputerPartVisitor {

  @Override
  public void visit(Computer computer) {
    System.out.println("Not Displaying Computer.");
  }

  @Override
  public void visit(Mouse mouse) {
    System.out.println("Not Displaying Mouse.");
  }

  @Override
  public void visit(Keyboard keyboard) {
    System.out.println("Not Displaying Keyboard.");
  }

  @Override
  public void visit(Monitor monitor) {
    System.out.println("Not Displaying Monitor.");
  }

}
