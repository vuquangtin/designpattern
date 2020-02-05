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
public interface Player {
	/**
	 * only applicable for human players
	 * @param nextMove is the column number for the next move
	 */
  public void nextMove(int nextMove);
  
  /**
   * only applicable for human player
   * @return stored move number
   */
  public int getMove();
  public void play();
}