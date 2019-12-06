package iterators.tests;

public interface Aggregate<T> {

    void add(T t);

    void delete(T t);

    Iterator<T> iterator();
}