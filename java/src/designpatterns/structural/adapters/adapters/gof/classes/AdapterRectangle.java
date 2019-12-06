package adapters.gof.classes;

class AdapterRectangle extends Rectangle implements Figure {

  public String draw() {
    return this.drawRectangle();
  }
}