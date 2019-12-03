package com.designpatterns.behavioral.chainofresponsibility.requests;

public class Handler2 extends BaseHandle {
	@Override
	protected int getHandleLevel() {
		return 2;
	}

	@Override
	protected void handle(BaseRequest mBaseRequest) {
		System.out.println("Handler2 handle request :" + mBaseRequest.getRequestLevel());

	}
}