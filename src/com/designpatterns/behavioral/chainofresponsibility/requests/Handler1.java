package com.designpatterns.behavioral.chainofresponsibility.requests;

public class Handler1 extends BaseHandle {
	@Override
	protected int getHandleLevel() {
		return 1;
	}

	@Override
	protected void handle(BaseRequest mBaseRequest) {

		System.out.println("Handler1 handle request :" + mBaseRequest.getRequestLevel());
	}
}