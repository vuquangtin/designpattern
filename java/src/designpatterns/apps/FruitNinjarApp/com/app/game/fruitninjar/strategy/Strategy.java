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
//strategy is to define various game level 
//getSpeed return the speed that the fruit move
//isHasBomb return whether this strategy has bomb
public interface Strategy {
	public int getSpeed();
	public boolean isHasBomb();
}