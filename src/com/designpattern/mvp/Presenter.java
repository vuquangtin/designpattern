package com.designpattern.mvp;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Presenter {

	private View view;
	private Model model;

	public Presenter(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void login(String pass) {
		String result = "Incorrect password";

		if (model.getPassword().equals(pass)) {
			result = "Correct password";
		}
		view.updateStatusLabel(result);
	}
}
