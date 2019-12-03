package com.designpatterns.behavioral.chainofresponsibility.manager;

public abstract class Leader {

	protected Leader mNextLeader;

	/**
	 * 处理请求
	 * 
	 * @param money
	 */
	public final void handleRequest(int money) {
		if (money < limit()) {
			handle(money);
		} else {
			if (mNextLeader != null) {
				money=money/10;
				System.out.println("handleRequest:" + money);
				mNextLeader.handleRequest(money);
			}
		}
	}

	/**
	 * 自身能承受的最大额度
	 * 
	 * @return
	 */
	public abstract int limit();

	/**
	 * 处理报销
	 * 
	 * @param money
	 */
	public abstract void handle(int money);

}