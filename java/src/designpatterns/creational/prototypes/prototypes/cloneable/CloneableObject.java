package prototypes.cloneable;

class CloneableObject extends Prototype {

  private final int ID;

  public CloneableObject(int id) {
    ID = id;
  }

  public Prototype clone() {
    return new CloneableObject(ID);
  }

  public int getId() {
    return ID;
  }
}