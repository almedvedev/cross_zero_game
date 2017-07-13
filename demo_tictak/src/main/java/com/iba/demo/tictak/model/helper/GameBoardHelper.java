package com.iba.demo.tictak.model.helper;

import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.BoardCell;
import com.iba.demo.tictak.model.BoardCellState;

public class GameBoardHelper {

	public static BoardCell[][] buildEmptyBoardCells() {
		final BoardCell[][] cells = new BoardCell[Board.SIZE][Board.SIZE];
		for(int x = 0; x < Board.SIZE; x++) {
			for(int y = 0; y < Board.SIZE; y++) {
				cells[x][y] = new BoardCell(x, y, BoardCellState.EMPTY);
			}
		}
		return cells;
	}	
}
