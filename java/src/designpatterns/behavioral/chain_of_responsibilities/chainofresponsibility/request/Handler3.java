package chainofresponsibility.request;

public class Handler3 extends BaseHandle {
    @Override
    protected int getHandleLevel() {
        return 3;
    }

    @Override
    protected void handle(BaseRequest mBaseRequest) {
        System.out.println("Handler3 handle request :"+mBaseRequest.getRequestLevel());

    }
}