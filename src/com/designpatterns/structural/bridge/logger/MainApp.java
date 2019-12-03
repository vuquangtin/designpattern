package com.designpatterns.structural.bridge.logger;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class MainApp {
	public static void main(String[] args) {
		// chọn log kiểu show ra console
		MessageLogger messageLogger = new ConsoleLogger();
		// chọn cách thức hiển thị kiểu mã hóa
		Message message1 = new EncryptedMessage(messageLogger);
		// chọn cách thức hiển thị kiểu text rõ
		Message message2 = new TextMessage(messageLogger);
		// thực thi phương thức log
		message1.log("stackjava.com");
		message2.log("stackjava.com");
	}
}