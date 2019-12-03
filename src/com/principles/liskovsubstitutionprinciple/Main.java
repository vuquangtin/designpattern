package com.principles.liskovsubstitutionprinciple;


/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int func(Stack p) {
		p.push(5);
		p.push(6);
		p.push(7);
		int a = p.pop();
		int b = p.pop();
		if (a == 7 && b == 6)
			return a * b;
		throw new IllegalArgumentException();
	}
	
}
