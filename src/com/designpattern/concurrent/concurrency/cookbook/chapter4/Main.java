package com.designpattern.concurrent.concurrency.cookbook.chapter4;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Main {

	/**
	 * Main method of the example
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the server
		Server server=new Server();
		
		// Send 100 request to the server and finish
		for (int i=0; i<100; i++){
			Task task=new Task("Task "+i);
			server.executeTask(task);
		}
		
		server.endServer();
		System.out.printf("endServer");
	}

}