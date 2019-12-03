package com.designpatterns.creational.builder;

public class BuilderTest {

    public static void main(String[] args) {
        Car.Builder mBuilder=new Car.Builder()
                .setColor("green")
                .setMoney(100)
                .setName("lanbojini")
                .setSeat();
        Car mCar=mBuilder.build();
        System.out.println(mCar.toString());

    }
}