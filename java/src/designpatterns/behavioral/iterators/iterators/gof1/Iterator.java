package iterators.gof1;

abstract class Iterator {

  abstract String current();

  abstract boolean hasNext();

  abstract String first();

  abstract String last();

  abstract String next();
}