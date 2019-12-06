package commands.gof;

abstract class Command {

  protected Receiver r;

  public Command(Receiver r) {
    this.r = r;
  }

  public abstract void execute();
}