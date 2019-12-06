package commands.gof;

class TurnOnCommand extends Command {

  public TurnOnCommand(Receiver r) {
    super(r);
  }

  public void execute() {
    r.turnOn();
  }

  public String toString() {
    return "Turn on Command";
  }
}
