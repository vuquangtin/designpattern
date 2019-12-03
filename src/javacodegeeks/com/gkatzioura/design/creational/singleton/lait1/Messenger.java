package javacodegeeks.com.gkatzioura.design.creational.singleton.lait1;

public class Messenger {

    private static Messenger messenger;

    private Messenger() {}

    public synchronized static Messenger getInstance() {

        if(messenger==null) {
            messenger = new Messenger();
        }

        return messenger;
    }

    public void send(String message) {

    }
}
