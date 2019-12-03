package com.designpatterns.creational.singleton.full;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SingletonPattern {

	public static void main(String[] args) {
		try {
			FullSingleton obj1 = FullSingleton.getInstance();
			FullSingleton obj2 = obj1.clone();

			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("singleton.ser"));
			oos.writeObject(obj1);
			oos.close();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"singleton.ser"));
			FullSingleton obj3 = (FullSingleton) ois.readObject();
			ois.close();

			System.out.println("First Object      :: " + obj1.getVal());
			System.out.println("Clone Object      :: " + obj2.getVal());
			System.out
					.println("Serialized Object :: " + obj3.getVal() + "\n\n");

			// Changing value in Object 3
			obj3.setVal(100);

			System.out.println("First Object      :: " + obj1.getVal());
			System.out.println("Clone Object      :: " + obj2.getVal());
			System.out
					.println("Serialized Object :: " + obj3.getVal() + "\n\n");

			// Changing value in Object 3
			obj2.setVal(1234);

			System.out.println("First Object      :: " + obj1.getVal());
			System.out.println("Clone Object      :: " + obj2.getVal());
			System.out.println("Serialized Object :: " + obj3.getVal());

			Constructor<FullSingleton> constructor = FullSingleton.class
					.getDeclaredConstructor();
			constructor.setAccessible(true);
			FullSingleton newInstance = (FullSingleton) constructor
					.newInstance();

			System.out.println("NEW INSTANCE : " + newInstance.getVal());

		} catch (Exception e) {
			System.out.println(e.getCause());
		}
	}
}