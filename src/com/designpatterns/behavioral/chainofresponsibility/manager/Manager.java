package com.designpatterns.behavioral.chainofresponsibility.manager;

public class Manager extends Leader {
    @Override
    public int limit() {
        return 10000;
    }

    @Override
    public void handle(int money) {
        System.out.println("manager"+money);

    }
}