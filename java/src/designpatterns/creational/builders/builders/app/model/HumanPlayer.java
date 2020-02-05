package builders.app.model;


/**
 * <h1>Builder</h1> Tách rời việc xây dựng (khởi tạo) của một đối tượng phức tạp
 * khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng (khởi tạo) có
 * thể tạo ra các biểu diễn khác nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class HumanPlayer implements Player {
  
  private Board board;
  private int nextMove;

  HumanPlayer(Board board) {
    this.board = board;
    this.nextMove = -1;
  }

  @Override
  public void nextMove(int nextMove) {
    this.nextMove = nextMove;
  }

  @Override
  public void play() {
    this.board.move(nextMove);
  }

  @Override
  public int getMove() {
    return nextMove;
  }
}