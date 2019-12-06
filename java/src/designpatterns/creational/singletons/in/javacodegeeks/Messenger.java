package in.javacodegeeks;

public class Messenger {

    private static Messenger messenger = new Messenger();

    private Messenger() {}

    public static Messenger getInstance() {
        return messenger;
    }

    public void send(String message) {

    }

}
