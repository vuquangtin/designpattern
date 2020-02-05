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
public class ConnectFourModel {

  private Player playerOne;
  private Player playerTwo;
  private Player currentPlayer;
  private Player nextPlayer;
  private Board board;

  /**
   * called by controller to change the current player
   * @param player
   */
  public void setCurrentPlayer(Player player) {
    this.currentPlayer = player;
  }

  /**
   * 
   * @return current player
   */
  public Player getCurrentPlayer() {
    return this.currentPlayer;
  }

  /**
   * sets 'Player 1' entity of the model
   * @param playerOne
   */
  public void setPlayerOne(Player playerOne) {
    this.playerOne = playerOne;
  }

  /**
   * 
   * @return Player 1' entity of the model
   */
  public Player getPlayerOne() {
    return this.playerOne;
  }

  /**
   * set 'Player 2' entity of the model
   * @param playerTwo
   */
  public void setPlayerTwo(Player playerTwo) {
    this.playerTwo = playerTwo;
  }

  /**
   * 
   * @return 'Player 2' entity of the model
   */
  public Player getPlayerTwo() {
    return this.playerTwo;
  }

  /**
   * stores a reference of the board used by controller
   * @param board
   */
  public void setBoard(Board board) {
    this.board = board;
  }

  /**
   * 
   * @return reference to the board
   */
  public Board getBoard() {
    return this.board;
  }
}