package prototypes.gof;

class CloneableObject extends CloneableObjectPrototype {

  private final int ID;

  public CloneableObject(int id) {
    ID = id;
  }

  public CloneableObjectPrototype clone() {
    return new CloneableObject(ID);
  }

  public int getId() {
    return ID;
  }
}