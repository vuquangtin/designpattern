package com.db.app.paint.classes;

import java.awt.Color;
import java.awt.Graphics;

import com.db.app.paint.model.interfaces.IShape;
import com.db.app.paint.models.ShapeShadingType;
import com.db.app.paint.view.gui.Ellipse;
import com.db.app.paint.view.gui.Polygon;
import com.db.app.paint.view.gui.Rectangle;

/**
 *
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ShapeFactory {

	public IShape getShape(String shapeType, Graphics g, int x, int y, int x2,
			int y2, ShapeShadingType shapeShadingType, Color contextColor,
			Color secColor) {

		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("ELLIPSE")) {
			return new Ellipse(g, x, y, x2, y2, shapeShadingType, contextColor,
					secColor);

		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle(g, x, y, x2, y2, shapeShadingType,
					contextColor, secColor);

		} else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
			return new Polygon(g, x, y, x2, y2, shapeShadingType, contextColor,
					secColor);
		}

		return null;
	}
}