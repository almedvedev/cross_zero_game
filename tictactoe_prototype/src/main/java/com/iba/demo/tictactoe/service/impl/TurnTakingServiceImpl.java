package com.iba.demo.tictactoe.service.impl;

import com.iba.demo.tictactoe.exceptions.GameException;
import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Board;
import com.iba.demo.tictactoe.model.BoardCell;
import com.iba.demo.tictactoe.model.Player;
import com.iba.demo.tictactoe.model.PlayerMark;
import com.iba.demo.tictactoe.model.Turn;

public class TurnTakingServiceImpl {
	
	public void takeTurn(Game game, Turn turn) throws GameException {
		final BoardCell turnCell = turn.getCell();
		final Player turnTaker = turn.getTaker();
		updateBoardCell(game, turnCell);
		updateTurnTaker(game, turnTaker);
	}

	private void updateBoardCell(Game game, BoardCell cell) {
		Board board = game.getBoard();
		board.putCell(cell);
	}
	
	private void updateTurnTaker(Game game, Player turnTaker) throws GameException {
		Player nextTurnPlayer = resolveNextTurnTaker(game, turnTaker);
		game.setTurnTaker(nextTurnPlayer);
	}

	private Player resolveNextTurnTaker(Game game, Player turnTaker) throws GameException {
		Player nextTurnTaker = null;		
		if (PlayerMark.CROSS.equals( turnTaker.getMark() ) ) {
			nextTurnTaker = game.getNoughtPlayer();
		} else {
			nextTurnTaker = game.getCrossPlayer();
		}			
		return nextTurnTaker;
	}

}
