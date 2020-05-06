package designpatterns.gof.behavioral.states.demo;

/**
 * <h1>State</h1> cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính
 * nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DevState implements BugState {
    @Override
    public String handle(BugManager bugManager) {
        bugManager.setBugState(bugManager.getReviewState());
        return "缺陷已经开发完成，进入复审状态";
    }

    @Override
    public String toString() {
        return "开发状态";
    }
}