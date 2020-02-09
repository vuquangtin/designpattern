package com.app.game.fruitninjar.factory;

import java.util.Random;

import com.app.game.fruitninjar.strategy.Level2;
import com.app.game.fruitninjar.strategy.Level3;
import com.app.game.fruitninjar.strategy.Strategy;

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
public class Factory implements AbstractFactory{

	private static final Factory factory = new Factory();
	
	private Factory(){}
	
	public static Factory getFactory(){
		return factory;
	}
//	return random fruit base on random number
	
	public Fruit makeFruit( Strategy strategy ){
		Random rand = new Random();
		int random = rand.nextInt(10);
		if (random < 2) {
			return new Apple( strategy.getSpeed() );
		} else if (random < 4) {
			return new Banana( strategy.getSpeed());
		} else if (random < 6) {
			return new Strawberry( strategy.getSpeed());
		} else if (random < 7) {
			return new Pineapple( strategy.getSpeed());
		} else if( (strategy instanceof Level2 || strategy instanceof Level3) && random < 9 ){
			return new Bomb( strategy.getSpeed());
		}
		return new Peach( strategy.getSpeed());
	}
	
}