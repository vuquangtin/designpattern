package com.designpatterns.behavioral.mediator.chat;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public interface ChatMediator {

	public void sendMessage(String msg, User user);

	void addUser(User user);
}