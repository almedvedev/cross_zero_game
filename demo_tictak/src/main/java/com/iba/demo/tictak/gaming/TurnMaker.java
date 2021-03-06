package com.iba.demo.tictak.gaming;

import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.BoardCell;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.GameOver;
import com.iba.demo.tictak.model.Player;
import com.iba.demo.tictak.model.PlayerMark;
import com.iba.demo.tictak.model.Turn;

/**
 * @author Alexander Medvedev
 */

public class TurnMaker {
	
	public void makeTurn(Game game, Turn turn) throws GameException {
		final BoardCell turnCell = turn.getCell();
		final Player turnTaker = turn.getTaker();
		updateBoardCell(game, turnCell);
		updateTurnTaker(game, turnTaker);
		updateRemainingTurns(game);		
		updateGameStatus(game);
	}

	private void updateRemainingTurns(Game game) {
		int remainingTurns = game.getRemainingTurns();
		remainingTurns --;
		game.setRemainingTurns(remainingTurns);
	}

	private void updateBoardCell(Game game, BoardCell cell) {
		Board board = game.getBoard();
		board.updateWithCell(cell);
	}
	
	private void updateTurnTaker(Game game, Player turnTaker) throws GameException {
		Player nextTurnPlayer = resolveNextTurnTaker(game, turnTaker);
		game.setTurnTaker(nextTurnPlayer);
	}

	private Player resolveNextTurnTaker(Game game, Player turnTaker) throws GameException {
		if (PlayerMark.CROSS.equals( turnTaker.getMark() ) ) {
			return game.getNoughtPlayer();
		}
		return game.getCrossPlayer();
	}
	
	private void updateGameStatus(Game game) {
		GameOver gameOver = new GameOverDeterminator().determineGameOver(game);		
		game.setGameOver(gameOver);		
	}

}
