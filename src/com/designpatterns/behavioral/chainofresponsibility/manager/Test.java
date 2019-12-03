package com.designpatterns.behavioral.chainofresponsibility.manager;

public class Test {
	public static void main(String[] args) {
		DireLeader mDireLeader = new DireLeader();
		GroupLrader mGroupLrader = new GroupLrader();
		Manager mManager = new Manager();

		mDireLeader.mNextLeader = mGroupLrader;
		mGroupLrader.mNextLeader = mManager;
		mManager.mNextLeader = mDireLeader;

		mDireLeader.handleRequest(10000000);
	}
}
