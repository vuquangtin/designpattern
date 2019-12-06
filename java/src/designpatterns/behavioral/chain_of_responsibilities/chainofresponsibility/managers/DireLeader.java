package chainofresponsibility.managers;

public class DireLeader extends Leader {
	@Override
	public int limit() {
		return 1000;
	}

	@Override
	public void handle(int money) {

		System.out.println("direLeader" + money);
	}
}
