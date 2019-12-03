package com.designpatterns.creational.factorymethod.product;

public abstract class Factory {
    public abstract <T extends Product>T creatProduct(Class<T> mTClass);
}