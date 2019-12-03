package com.designpatterns.structural.adapter.translation;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class VietnameseClient {

	public static void main(String[] args) {
		VietnameseTarget client = new TranslatorAdapter(new JapaneseAdaptee());
		client.send("Xin chào");
	}
}