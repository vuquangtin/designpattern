package observers.converts;

public class ObserverPatternDemo {
  public static void main(String[] args) {
    Subject subject = new Subject();

    Observer hexaObserver = new HexaObserver(subject);
    Observer octalObserver = new OctalObserver(subject);
    new BinaryObserver(subject);

    System.out.println("First state change: 15");
    subject.setState(15);
    System.out.println("Second state change: 10");
    subject.setState(10);

    System.out.println("---Remove HexaObserver---");
    subject.detach(hexaObserver);
    System.out.println("Third state change: 11");
    subject.setState(11);
    System.out.println("Fourth state change: 7");
    subject.setState(7);

    System.out.println("---Remove OctalObserver---");
    subject.detach(octalObserver);
    System.out.println("Fifth state change: 8");
    subject.setState(8);
    System.out.println("Sixth state change: 4");
    subject.setState(4);
  }
}
