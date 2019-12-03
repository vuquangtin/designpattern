package com.designpatterns.behavioral.iterator;

public interface Aggregate<T> {

    void add(T t);

    void delete(T t);

    Iterator<T> iterator();
}