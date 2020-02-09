package com.app.game.fruitninjar.strategy;
/**
 * <h1>Desktop-Fruit-Ninja-App</h1>This is Desktop Fruit Ninjar App using Java programming language. 
 *Used MVC architecture pattern, singleton, strategy and factory design pattern.
 *Stored user data in Amazon SimpleDB and showed user information by update HTML file stored in Amazon S3
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
//level1 is the first level of this game. 
//it contain 2 member variables
//hasBomb means whether this is bomb in this level
//speed define the speed for the fruit to move
public class Level3 implements Strategy{

	private boolean hasBomb;
	private static int speed = 5;
	
	public Level3(){
		hasBomb = true;
	}
	public boolean isHasBomb() {
		return hasBomb;
	}
	public int getSpeed(){
		return speed;
	}
}