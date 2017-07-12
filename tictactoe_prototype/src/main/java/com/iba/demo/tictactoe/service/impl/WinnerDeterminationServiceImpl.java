package com.iba.demo.tictactoe.service.impl;

import com.iba.demo.tictactoe.model.Board;
import com.iba.demo.tictactoe.model.BoardCell;
import com.iba.demo.tictactoe.model.BoardCellState;
import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Player;

public class WinnerDeterminationServiceImpl {
	
	interface CellProvider {
		BoardCell getCell(int i);
	}
	
	public Player determineWinner(Game game) {
		Player winner = null;		
		Board board = game.getBoard();
		for(int j = 0; j < Board.SIZE; j ++) {			
			final int coord = j;
			winner = checkBoardLine(game, winner, i -> board.getCell(coord, i) );
			if (winner != null) 
				return winner;			
			winner = checkBoardLine(game, winner, i -> board.getCell(i, coord) );
			if (winner != null) 
				return winner;			
			winner = checkBoardLine(game, winner, i -> board.getCell(i, i) );
			if (winner != null) 
				return winner;
		}
		return winner;
	}

	private Player checkBoardLine(Game game, Player winner, CellProvider cellProvider) {
		int crossCount = 0;
		int noughtCount = 0;
		for(int i = 0; i < Board.SIZE; i ++) {
			BoardCell cell = cellProvider.getCell(i);
			BoardCellState cellState = cell.getState();
			if ( BoardCellState.CROSS.equals( cellState ) ) {
				crossCount ++;
			} else if ( BoardCellState.CROSS.equals( cellState ) ) {
				noughtCount ++;
			}
			if (crossCount == Board.SIZE) {
				return game.getCrossPlayer();
			} else if (noughtCount == Board.SIZE) {
				return game.getNoughtPlayer();
			}
		}		
		return null;
	}

}
