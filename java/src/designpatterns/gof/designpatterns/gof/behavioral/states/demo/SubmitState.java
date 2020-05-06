package designpatterns.gof.behavioral.states.demo;

/**
 * <h1>State</h1> cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính
 * nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class SubmitState implements BugState {

	@Override
	public String toString() {
		return "提交状态";
	}

	@Override
	public String handle(BugManager bugManager) {
		bugManager.setBugState(bugManager.getDevState());
		return "缺陷已提交，现在是开发状态";
	}
}