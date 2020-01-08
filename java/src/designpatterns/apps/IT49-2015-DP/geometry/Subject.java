package geometry;

import geometry.Observer;

public interface Subject {
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers(int a, int b, int c);

}
