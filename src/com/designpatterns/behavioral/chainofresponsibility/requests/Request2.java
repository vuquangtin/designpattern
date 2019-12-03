package com.designpatterns.behavioral.chainofresponsibility.requests;

public class Request2  extends BaseRequest{
	public Request2(Object mObject) {
        super(mObject);
    }

    @Override
    protected int getRequestLevel() {
        return 2;
    }
}
