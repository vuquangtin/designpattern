package chainofresponsibility.request;

public class Request1 extends BaseRequest{

    public Request1(Object mObject) {
        super(mObject);
    }

    @Override
    protected int getRequestLevel() {
        return 1;
    }
}