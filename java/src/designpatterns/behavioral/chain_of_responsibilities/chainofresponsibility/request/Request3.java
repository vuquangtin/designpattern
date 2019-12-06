package chainofresponsibility.request;

public class Request3  extends BaseRequest{
	public Request3(Object mObject) {
        super(mObject);
    }

    @Override
    protected int getRequestLevel() {
        return 3;
    }
}
