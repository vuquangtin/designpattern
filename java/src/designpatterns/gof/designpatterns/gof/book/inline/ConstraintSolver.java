package designpatterns.gof.book.inline;

public class ConstraintSolver {
	private SolverState solverState;

	/** 生成解决器状态 */
	public SolverState createSolverState() {
		if (solverState == null) {
			solverState = new SolverState(0);
			System.out.println("ConstraintSolver创建SolverState: " + solverState);
		}
		return solverState;
	}

	/** 更新解决器状态 */
	public void setSolverState(SolverState solverState) {
		System.out.println("ConstraintSolver更新SolverState" + solverState);
		this.solverState = solverState;
	}

	public void doSolveStep() {
		int state = RandomUtils.nextInt(1, 11);
		System.out.println("ConstraintSolver更新SolverState：" + state);
		solverState.setState(state);
	}

}