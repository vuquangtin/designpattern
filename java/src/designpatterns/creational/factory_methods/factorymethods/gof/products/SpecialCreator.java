package factorymethods.gof.products;


class SpecialCreator extends Creator {

  public Product factoryMethod() {
    return new SpecialProduct();
  }
}