package factorymethods.products;

public abstract class Factory {
    public abstract <T extends Product>T creatProduct(Class<T> mTClass);
}