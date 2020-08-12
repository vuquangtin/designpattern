package com.db.app.paint.models;

import java.util.Iterator;
import java.util.List;

import com.db.app.paint.model.interfaces.IIterator;
import com.db.app.paint.model.interfaces.IShape;
import com.db.app.paint.view.gui.PaintCanvas;

public class ShapeRepository {
	List<IShape> shapes;
	PaintCanvas paintcanvas = PaintCanvas.getInstance();

public ShapeRepository() {
	shapes = paintcanvas.getShapes();
}

public void addItem(IShape shape) {
	shapes.add(shape);
}

public Iterator<IShape> iterator() {
	return new ShapeIterator();
}

class ShapeIterator implements Iterator<IShape>,IIterator {
	int currentIndex = 0;

	@Override
	public boolean hasNext() {
		if (currentIndex >= shapes.size()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public IShape next() {
		return shapes.get(currentIndex++);
	}

	@Override
	public void remove() {
		shapes.remove(--currentIndex);
	}

}


}
