package com.app.game.fruitninjar.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JPanel;

import com.app.game.fruitninjar.factory.Bomb;
import com.app.game.fruitninjar.factory.Factory;
import com.app.game.fruitninjar.factory.Fruit;
import com.app.game.fruitninjar.model.Fruits;
import com.app.game.fruitninjar.model.User;
import com.app.game.fruitninjar.model.UserDB;
import com.app.game.fruitninjar.strategy.Level1;
import com.app.game.fruitninjar.strategy.Level2;
import com.app.game.fruitninjar.strategy.Level3;
import com.app.game.fruitninjar.strategy.Strategy;
import com.app.game.fruitninjar.view.GamePanel;

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
public class Controller implements Runnable {

	public static final int TIMEFORLEVEL2 = 10; // after 10 seconds go to level2
	public static final int TIMEFORLEVEL3 = 20; // after 20 seconds go to level3
	public static final int HIGHESTSCORE = 99990; // highest score for this game
	public static final int FREQUENCY = 2; // generate a fruit for every 2
											// seconds
	private boolean dead;
	private boolean start;
	private boolean setUsername;
	private boolean hitBomb;
	private Strategy strategy;
	private Fruits model;
	private MouseMovement mouse;
	private GamePanel panel;
	private UserDB userDB;
	private User user;
	private Factory factory;

	public Controller() {
		this.dead = false;
		this.start = false;
		this.setUsername = false;
		this.model = new Fruits();
		this.user = new User();
		this.userDB = UserDB.getInstance();
		this.strategy = new Level1();
		this.mouse = new MouseMovement(this);
		this.factory = Factory.getFactory();
	}

	public static void main(String[] args) {
		// get username and verified username
		Controller controller = new Controller();
		// controller.userDB.destroyDomain();
		Scanner scanner = new Scanner(System.in);
		while (!controller.start) {
			System.out.println("Please enter your username:");
			controller.user.setUsername(scanner.nextLine());
			System.out.println("Please enter your password:");
			controller.user.setPassword(scanner.nextLine());
			if (controller.verifyUser()) {
				controller.start = true;
			}
		}
		// start game
		controller.panel = new GamePanel(controller.getMouse());
		Thread thread = new Thread(controller);
		thread.start();
	}

	// if get good username, return true
	// a good username: 1. not empty string 2. not exist in userDB
	// set start in controller, if get name not in database, return true
	public boolean verifyUser() {
		if (this.user.getUsername().length() == 0) {
			return false;
		}
		//String userExpression = "Select * from `oofinalproject` where username = '" + this.user.getUsername() + "'";
//		List<Item> sameName = userDB.searchBy(userExpression);
//		if (sameName.size() == 0) {
//			return true;
//		}
//		String selectExpression = "Select * from `oofinalproject` where username = '" + this.user.getUsername()
//				+ "' and password = '" + this.user.getPassword() + "'";
//		List<Item> user = userDB.searchBy(selectExpression);
//		if (user.size() > 0) {
//			return true;
//		}
		return true;
		//return false;
	}

	// show fruit in screen by double buffer image method
	public void run() {
		long startTime = System.currentTimeMillis();
		int fruitRound = -1;
		// Double buffer image
		while (!dead) {
			// to draw in every 3 seconds(frequency),
			// compare time range with frequency
			long time = System.currentTimeMillis();
			int seconds = (int) ((time - startTime) / 1000);
			if (seconds / FREQUENCY > fruitRound) {
				getFruits();
				fruitRound = seconds / FREQUENCY;
			}
			// automatically change to higher level base on how long the user
			// play
			if (seconds > TIMEFORLEVEL2) {
				strategy = new Level2();
			} else if (seconds > TIMEFORLEVEL3) {
				strategy = new Level3();
			}
			BufferedImage buffImage = new BufferedImage(GamePanel.WIDTH, GamePanel.LENGTH, 1);
			Graphics g = buffImage.getGraphics();
			paint(g);
			this.panel.draw(buffImage);
			this.panel.printComponents(this.panel.getGraphics());
			move();
			removeFruit();
			checkLost();

			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		model.getFruits().clear();
		// write to simpleDB and Amazon S3
		this.user.setDate(dateToString());
		//this.userDB.addUser(user);

		System.exit(0);
	}

	// show all fruits in view
	public void paint(Graphics g) {
		int size = model.getFruits().size();
		for (int i = 0; i < size; i++) {
			BufferedImage image = model.getFruits().get(i).getImage();
			int x = model.getFruits().get(i).getCenter().x;
			int y = model.getFruits().get(i).getCenter().y;
			g.drawImage(image, x - model.getFruits().get(i).getRadius(), y - model.getFruits().get(i).getRadius(),
					model.getFruits().get(i).getRadius(), model.getFruits().get(i).getRadius(), null);
		}
	}

	// get fruits by calling factory
	public void getFruits() {
		Fruit fruit = factory.makeFruit(strategy);
		this.model.getFruits().add(fruit);

	}

	// movement of all fruits in model fruit array
	public void move() {
		int size = model.getFruits().size();
		for (int i = 0; i < size; i++) {
			model.getFruits().get(i).move();
		}
	}

	// check if mouse hit fruit or bomb
	// if hit fruit, earn points else if hit bomb, set dead = true
	public void hitFruit() {
		int size = model.getFruits().size();
		int distance = 0;
		for (int i = 0; i < size; i++) {
			distance = (int) Math.pow(Math.abs(mouse.getCenter().x - model.getFruits().get(i).getCenter().x), 2)
					+ (int) Math.pow(Math.abs(mouse.getCenter().y - model.getFruits().get(i).getCenter().y), 2);
			if (distance < (int) Math.pow(model.getFruits().get(i).getRadius(), 2)) {
				model.getFruits().get(i).setHit(true);
				if (model.getFruits().get(i) instanceof Bomb) {
					dead = true;
					System.out.println("Dead because hit bomb");
				} else {
					if (this.user.getScore() < HIGHESTSCORE) {
						this.user.setScore(this.user.getScore() + model.getFruits().get(i).getPoints());
					}
					System.out.println("score is: " + this.user.getScore());
				}
			}
		}
	}

	// remove all fruits or bombs whose isHit is true
	public void removeFruit() {
		int size = model.getFruits().size();
		for (int i = size - 1; i >= 0; i--) {
			if (model.getFruits().get(i).isHit()) {
				model.getFruits().remove(i);
			}
		}
	}

	// check if fruit is out of view, then game over
	public void checkLost() {
		int size = model.getFruits().size();
		for (int i = 0; i < size; i++) {
			if (model.getFruits().get(i).getCenter().getX() < 0 || model.getFruits().get(i).getCenter().getY() < 0
					|| model.getFruits().get(i).getCenter().getX() > GamePanel.WIDTH
					|| model.getFruits().get(i).getCenter().getY() > GamePanel.LENGTH) {
				if (!(model.getFruits().get(i) instanceof Bomb)) {
					dead = true;
					System.out.println("Lost becasue miss catch fruit");
				}
			}
		}
	}

	public MouseMovement getMouse() {
		return this.mouse;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public boolean isHitBomb() {
		return hitBomb;
	}

	public void setHitBomb(boolean hitBomb) {
		this.hitBomb = hitBomb;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public boolean isSetUsername() {
		return setUsername;
	}

	public void setSetUsername(boolean setUsername) {
		this.setUsername = setUsername;
	}

	public UserDB getSimpleDB() {
		return userDB;
	}

	public void setSimpleDB(UserDB userDB) {
		this.userDB = userDB;
	}

	// save date in user.date as String
	public String dateToString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}