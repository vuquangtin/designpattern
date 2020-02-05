package builders.app.model;

import java.util.Random;
import java.util.TreeSet;

import builders.app.GameConfig;


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
public class BotPlayer implements Player {

	private Board board;

	BotPlayer(Board board) {
		this.board = board;
	}

	/**
	 * Bot should not return moves as they are random
	 */
	@Override
	public int getMove() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Bot always picks a random column
	 */
	@Override
	public void nextMove(int col) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Bot player override of the play function.
	 */
	@Override
	public void play() {
		int possibleNextCol = -1;
		possibleNextCol = checkSelf();
		possibleNextCol = checkOpponent();
		Random randomGenerator = new Random();
		if (possibleNextCol == -1) {
			do {
				possibleNextCol = randomGenerator.nextInt(GameConfig.COL);
			} while (this.board.chipsInColumn(possibleNextCol) >= GameConfig.ROW);
		}
		this.board.move(possibleNextCol);
	}

	/**
	 * Check is a win is possible for the current bot player
	 * 
	 * @return valid column number if a win is possible else -1
	 */
	private int checkSelf() {

		int possibleNextCol = -1;
		boolean gameOver = false;
		TreeSet<Integer> colHash = new TreeSet<Integer>();
		Random randomGenerator = new Random();

		while (gameOver == false && colHash.size() < GameConfig.COL) {

			int randomCol = randomGenerator.nextInt(GameConfig.COL);
			if (colHash.contains(randomCol) == false) {
				colHash.add(randomCol);
				if (this.board.chipsInColumn(randomCol) < GameConfig.ROW) {
					this.board.move(randomCol);
					if (this.board.isGameOver()) {
						possibleNextCol = randomCol;
						gameOver = true;
					}
					this.board.backTrack();
				}
			}
		}

		return possibleNextCol;
	}

	/**
	 * anticipate whether the other bot can win
	 * 
	 * @return valid column number if a win is possible or -1
	 */
	private int checkOpponent() {

		int possibleNextCol = -1;
		TreeSet<Integer> colHash = new TreeSet<Integer>();
		Random randomGenerator = new Random();
		boolean gameOver = false;

		while (gameOver == false && colHash.size() < GameConfig.COL) {
			int randomCol = randomGenerator.nextInt(GameConfig.COL);
			if (colHash.contains(randomCol) == false) {
				colHash.add(randomCol);
				if (this.board.chipsInColumn(randomCol) < GameConfig.ROW) {
					this.board.move(randomCol);
					int opponentStep = this.checkSelf();
					if (opponentStep != -1) {
						possibleNextCol = opponentStep;
						gameOver = true;
					}
					this.board.backTrack();
				}
			}
		}

		return possibleNextCol;
	}
}