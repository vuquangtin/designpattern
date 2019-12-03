package com.designpatterns.gof.creational.builder;

import java.util.ArrayList;

public class PizzaMargheritaBuilder extends PizzaBuilder {

	public PizzaMargheritaBuilder() {
		this.name = "margherita";
		this.ingredients = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;

			{
				add("pomodoro");
				add("mozzarella");
			}
		};
	}
}