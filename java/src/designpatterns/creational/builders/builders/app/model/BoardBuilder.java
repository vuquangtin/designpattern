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
public class BoardBuilder {
  private int row;
  private int col;

  public BoardBuilder buildFromRow(int row) {
    this.row = row;
    return this;
  }

  public BoardBuilder buildFromCol(int col) {
    this.col = col;
    return this;
  }

  /**
   * builder function for the board class
   * @return board object
   */
  public Board build() {
    return Board.getBoard(row, col);
  }
}