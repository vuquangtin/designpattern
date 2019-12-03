package com.designpattern.concurrent.beginner;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Temp2 {
    private int age = 10;
    private synchronized void hello(String name, int age){
        String temp = name + " there";
        synchronized(this){
            this.setAge(age);
        }
        System.out.println(temp + " age " + age);
    }
 
    public static void main(String[] args){
        Temp2 t2 = new Temp2();
		t2.hello("user", 20);
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}