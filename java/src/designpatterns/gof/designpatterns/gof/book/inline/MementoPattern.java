package designpatterns.gof.book.inline;



import com.google.common.base.Function;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

/**
 * <h1>Memento</h1> Không vi phạm tính đóng gói, nó nắm bắt và hiệu chỉnh trạng
 * thái bên trong của đối tượng để đối tượng có thể được khôi phục về trạng thái
 * này sau đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
@DesignPattern(value = Pattern.Memento, description = "备忘录")
public class MementoPattern implements DesignPatternClient {

  private class Caretaker {
    private ConstraintSolver constraintSolver;
    private SolverState solverState;

    public void solve(Function<ConstraintSolver, Void> function) {
      constraintSolver = new ConstraintSolver();

      // 创建备忘录
      solverState = constraintSolver.createSolverState();

      function.apply(constraintSolver);

      // 将备忘录送回原发器
      constraintSolver.setSolverState(solverState);
    }

  }

  @Override
  public void usage() {
    Caretaker caretaker = new Caretaker();

    // 模拟ConstraintSolver处理更新其内部的SolverState
    Function<ConstraintSolver, Void> function = new Function<ConstraintSolver, Void>() {
      @Override
      public Void apply(ConstraintSolver input) {
        input.doSolveStep();
        input.doSolveStep();
        return null;
      }
    };
    caretaker.solve(function);
  }

  public static void main(String[] args) {
    new MementoPattern().usage();
  }
}