package com.iba.demo.tictactoe.service.impl;

import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Board;
import com.iba.demo.tictactoe.model.BoardCell;
import com.iba.demo.tictactoe.model.BoardCellState;
import com.iba.demo.tictactoe.model.Player;

public class WinnerDeterminationServiceImpl {
	
	public Player determineWinner(Game game) {
		// TODO: lambda or whatever...
		Player winner = null;
		BoardCell[][] cells = game.getBoard().getCells();
		for(int x = 0; x < Board.SIZE_X; x ++) {
			int crossCount = 0;
			int noughtCount = 0;
			for(int y = 0; y < Board.SIZE_Y; y ++) {
				BoardCellState cellState = cells[x][y].getState();
				if ( BoardCellState.CROSS.equals( cellState ) ) {
					crossCount ++;
				} else if ( BoardCellState.CROSS.equals( cellState ) ) {
					noughtCount ++;
				}
				if (crossCount == Board.SIZE_X) {
					return game.getCrossPlayer();
				} else if (noughtCount == Board.SIZE_X) {
					return game.getNoughtPlayer();
				}
				
			}
		}
		return winner;
	}

}
