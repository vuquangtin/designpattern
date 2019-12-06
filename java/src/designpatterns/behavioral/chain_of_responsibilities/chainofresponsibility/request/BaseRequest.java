package chainofresponsibility.request;

public abstract class BaseRequest {
	private Object mObject;

	public BaseRequest(Object mObject) {
		this.mObject = mObject;
	}

	public Object getContent() {
		return mObject;
	}

	protected abstract int getRequestLevel();
}
