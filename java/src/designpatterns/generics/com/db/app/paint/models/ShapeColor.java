package com.db.app.paint.models;

import java.awt.Color;

public enum ShapeColor {
    BLACK(Color.BLACK, "BLACK"),
	BLUE(Color.BLUE, "BLUE"),
    CYAN(Color.CYAN, "CYAN"),
    DARK_GRAY(Color.DARK_GRAY, "DARK_GRAY"),
    GRAY(Color.GRAY, "GRAY"),
    GREEN(Color.GREEN, "GREEN"),
    LIGHT_GRAY(Color.LIGHT_GRAY, "LIGHT_GRAY"),
    MAGENTA(Color.MAGENTA, "MAGENTA"),
    ORANGE(Color.ORANGE, "ORANGE"),
    PINK(Color.PINK, "PINK"),
    RED(Color.RED, "RED"),
    WHITE(Color.WHITE, "WHITE"),
    YELLOW(Color.YELLOW, "YELLOW");
    
    private final Color awtColor;
	private final String colorName;
	
	private ShapeColor(Color awtColor, String name){
		this.awtColor = awtColor;
		this.colorName = name;
	}

	public Color getAwtColor() {
		return awtColor;
	}

	public String getColorName() {
		return colorName;
	}
	
	
}
