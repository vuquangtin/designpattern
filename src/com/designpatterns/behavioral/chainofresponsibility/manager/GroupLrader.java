package com.designpatterns.behavioral.chainofresponsibility.manager;

public class GroupLrader extends Leader {

    @Override
    public int limit() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        System.out.println("groupLeader"+money);

    }
}