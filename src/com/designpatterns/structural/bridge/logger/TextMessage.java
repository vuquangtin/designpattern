package com.designpatterns.structural.bridge.logger;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class TextMessage extends Message {
	public TextMessage() {
	}

	public TextMessage(MessageLogger messageLogger) {
		super(messageLogger);
	}

	public MessageLogger getMessageLogger() {
		return messageLogger;
	}

	public void setMessageLogger(MessageLogger messageLogger) {
		this.messageLogger = messageLogger;
	}

	public String preProcess(String str) {
		return str;
	}

	@Override
	public void log(String msg) {
		this.messageLogger.log(preProcess(msg));
	}
}
