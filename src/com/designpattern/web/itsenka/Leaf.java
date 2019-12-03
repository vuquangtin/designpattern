package com.designpattern.web.itsenka;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Leaf extends Component {
	private String name;
	private int value;

	public Leaf(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	protected int sumValue() {
		System.out.println(" + " + value);
		return value;
	}

	protected void printTree(String path) {
		System.out.println(path + "-" + name);
	}
}
