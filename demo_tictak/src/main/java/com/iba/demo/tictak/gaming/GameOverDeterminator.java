package com.iba.demo.tictak.gaming;

import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.BoardCell;
import com.iba.demo.tictak.model.BoardCellState;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.GameOver;
import com.iba.demo.tictak.model.GameOverCond;
import com.iba.demo.tictak.model.Player;

public class GameOverDeterminator {
	
	private interface CellsInLineProvider {
		BoardCell getCell(int cellIndex);
	}
	
	public GameOver determineGameOver(Game game) {
		if (game.getRemainingTurns() > 4)
			return new GameOver(GameOverCond.NONE);
		
		return determineGameGameOverByBoard(game);
	}

	private GameOver determineGameGameOverByBoard(Game game) {
		Board board = game.getBoard();
		for(int j = 0; j < Board.SIZE; j ++) {
			Player winner = null;
			final int lineIdx = j;
			winner = findWinnerByLine(game, i -> board.getCell(i, lineIdx) );
			if (winner != null) {
				return new GameOver(winner, GameOverCond.WON_WITH_HORIZONTAL_LINE);				
			}			
			winner = findWinnerByLine(game, i -> board.getCell(lineIdx, i) );
			if (winner != null) {
				return new GameOver(winner, GameOverCond.WON_WITH_VERTICAL_LINE);				
			}			
			winner = findWinnerByLine(game, i -> board.getCell(i, i) );
			if (winner != null) {
				return  new GameOver(winner, GameOverCond.WON_WITH_DIAGONILE_LINE);				
			}
			winner = findWinnerByLine(game, i -> board.getCell(Board.SIZE - i - 1, i) );
			if (winner != null) {
				return new GameOver(winner, GameOverCond.WON_WITH_DIAGONILE_LINE);				
			}
		}
		if (game.getRemainingTurns() <= 0 ) {
			return new GameOver(GameOverCond.DICE);
		}
		return new GameOver(GameOverCond.NONE);
	}

	private Player findWinnerByLine(Game game, CellsInLineProvider cellProvider) {
		int crossCount = 0;
		int noughtCount = 0;
		for(int i = 0; i < Board.SIZE; i ++) {
			BoardCell cell = cellProvider.getCell(i);
			BoardCellState cellState = cell.getState();			
			if ( BoardCellState.CROSS.equals( cellState ) ) {
				crossCount ++;
			} else if ( BoardCellState.NOUGHT.equals( cellState ) ) {
				noughtCount ++;
			}
			if (crossCount == Board.SIZE) {
				return game.getCrossPlayer();
			}
			if (noughtCount == Board.SIZE) {
				return game.getNoughtPlayer();
			}
		}		
		return null;
	}

}
