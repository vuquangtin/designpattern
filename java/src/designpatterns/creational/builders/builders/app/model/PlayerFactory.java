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
public class PlayerFactory {
  
	/**
	 * 
	 * @param id, "Human" refers to human players, "Bot" to computer players
	 * @param board, every player object has a reference of the board for quick lookup
	 * @return Player object
	 */
  public static Player getPlayer(String id, Board board) {
    if (id.equals("Bot")) {
      return new BotPlayer(board);
    }
    else if (id.equals("Human")) {
      return new HumanPlayer(board);
    }
    return new HumanPlayer(board);
  }
}