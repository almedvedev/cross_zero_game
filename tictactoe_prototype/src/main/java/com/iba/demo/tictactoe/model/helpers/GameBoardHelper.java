package com.iba.demo.tictactoe.model.helpers;

import com.iba.demo.tictactoe.model.Board;
import com.iba.demo.tictactoe.model.BoardCell;
import com.iba.demo.tictactoe.model.BoardCellState;

public class GameBoardHelper {

	public static BoardCell[][] buildEmptyBoardCells() {
		final BoardCell[][] cells = new BoardCell[Board.SIZE_X][Board.SIZE_Y];
		for(int x = 0; x < Board.SIZE_X; x++) {
			for(int y = 0; y < Board.SIZE_Y; y++) {
				cells[x][y] = new BoardCell(x, y, BoardCellState.EMPTY);
			}
		}
		return cells;
	}	
}
