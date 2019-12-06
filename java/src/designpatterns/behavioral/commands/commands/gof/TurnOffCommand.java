package commands.gof;

class TurnOffCommand extends Command {

  public TurnOffCommand(Receiver r) {
    super(r);
  }

  public void execute() {
    r.turnOff();
  }

  public String toString() {
    return "Turn off Command";
  }
}
