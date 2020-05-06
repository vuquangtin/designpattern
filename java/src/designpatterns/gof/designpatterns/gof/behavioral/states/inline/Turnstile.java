package designpatterns.gof.behavioral.states.inline;

/**
 * <h1>State</h1> cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính
 * nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Turnstile {
	TurnstileState currentState = TurnstileState.lockedState;

	public void insertToken() {
		currentState.insertToken(this);
		System.out.println("Current State after inserting Token: "
				+ currentState.getClass());
	}

	public void passThru() {
		currentState.passThru(this);
		System.out.println("Current State after Passing through: "
				+ currentState.getClass());
	}

	public static void main(String[] args) {
		Turnstile t = new Turnstile();
		t.insertToken();
		t.passThru();
		t.insertToken();
		t.passThru();
		t.insertToken();
		t.insertToken();
		t.passThru();
		t.passThru();
		t.insertToken();
	}
}

interface TurnstileState {
	public static final LockedState lockedState = new LockedState();
	public static final UnLockedState unlockedState = new UnLockedState();

	public void passThru(Turnstile turnstile);

	public void insertToken(Turnstile turnstile);

	public String getState();

}

class LockedState implements TurnstileState {
	@Override
	public void insertToken(Turnstile turnstile) {
		System.out.println("**Locked State** Insert Token : Change State");
		turnstile.currentState = unlockedState;
	}

	@Override
	public void passThru(Turnstile turnstile) {
		// raiseAlarm();
		System.out.println("**Locked State** Pass Thru : No Change State");
		System.out.println("** RAISE ALARM **");
		turnstile.currentState = lockedState;

	}

	public String getState() {
		return "Locked State";
	}

}

class UnLockedState implements TurnstileState {
	@Override
	public void insertToken(Turnstile turnstile) {
		System.out.println("**UnLocked State** InsertToken : No Change State");
		turnstile.currentState = unlockedState;
	}

	@Override
	public void passThru(Turnstile turnstile) {
		System.out.println("**UnLocked State** Pass Thru : Change State");
		turnstile.currentState = lockedState;
	}

	public String getState() {
		return "UnLocked State";
	}

}