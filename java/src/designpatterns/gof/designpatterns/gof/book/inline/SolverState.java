package designpatterns.gof.book.inline;

import com.google.common.base.MoreObjects;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class SolverState {
	private int state;

	public SolverState(int state) {
		this.state = state;
	}

	/** 对除{@link ConstraintSolver}的类隐藏这些方法，即区分宽接口、窄接口 */
	protected void setState(int state) {
		this.state = state;
	}

	protected int getState() {
		return state;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("state", state).toString();
	}

}