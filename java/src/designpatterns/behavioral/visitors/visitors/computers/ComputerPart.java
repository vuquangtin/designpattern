package visitors.computers;

public interface ComputerPart {
  public void accept(ComputerPartVisitor computerPartVisitor);
}