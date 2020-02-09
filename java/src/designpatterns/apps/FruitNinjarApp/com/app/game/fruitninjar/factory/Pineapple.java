package com.app.game.fruitninjar.factory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * <h1>Desktop-Fruit-Ninja-App</h1>This is Desktop Fruit Ninjar App using Java
 * programming language. Used MVC architecture pattern, singleton, strategy and
 * factory design pattern. Stored user data in Amazon SimpleDB and showed user
 * information by update HTML file stored in Amazon S3
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Pineapple extends Fruit {

	public Pineapple() {
		super();
		this.points = 6;
		this.radius = 50;
		this.isHit = false;
		this.center.x = new Random().nextInt(100) + 30;
		this.center.y = new Random().nextInt(100) + 30;
		// this.speed = 5;
	}

	public Pineapple(int speed) {
		super();
		this.points = 6;
		this.radius = 50;
		this.isHit = false;
		this.center.x = new Random().nextInt(100) + 30;
		this.center.y = new Random().nextInt(100) + 30;
		this.speed = speed;
	}

	public void move() {
		center.x = center.x + speed;
		center.y = Math.abs(400 - center.x);
		center.y = 200;
		// center.y = (int)(0.003*center.x*center.x + -3*center.x + 80);
	}

	// get image of pineapple
	public BufferedImage getImage() {
		try {
			image = ImageIO.read(new File(PATH_NINJAR + "pineApple.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}