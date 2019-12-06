package factorymethods.gof.products;


class LimitedCreator extends Creator {

  public Product factoryMethod() {
    return new LimitedProduct();
  }
}