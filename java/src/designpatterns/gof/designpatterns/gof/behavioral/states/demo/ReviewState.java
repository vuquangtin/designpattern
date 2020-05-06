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
public class ReviewState implements BugState {
	@Override
	public String handle(BugManager bugManager) {
		if (bugManager.getExpertOpinion().equals("通过")) {
			bugManager.setBugState(bugManager.getFixedState());
			return "缺陷修复完成，本次修改结束";
		}
		bugManager.setBugState(bugManager.getDevState());
		return "缺陷开发有问题，回到开发状态";
	}

	@Override
	public String toString() {
		return "复审状态";
	}
}