package chainofresponsibility.gof;

public class NetworkLog extends Chain {

  public NetworkLog() {
    super.priority = Chain.ERR_NETWORK;
  }

  public String writeMessage() {
    return "Network error logged";
  }
}
