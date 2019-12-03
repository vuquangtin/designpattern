package com.designpatterns.creational.af_and_singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Client {

	public static void main(String[] args) {
		System.out.println("Enter your selection:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String selection = null;
		try {
			selection = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Factory factory = StatementFactory.getUniqueInstance();
		StatementType objStmtType = factory.createStatements(selection);
		System.out.println(objStmtType.print());
	}

}