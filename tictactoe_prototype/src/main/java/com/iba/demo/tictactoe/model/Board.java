package com.iba.demo.tictactoe.model;

public class Board {
	
	public final static int SIZE_X = 3;
	
	public final static int SIZE_Y = 3;
	
	private BoardCell[][] cells;
	
	public Board() {
		super();
	}

	public Board(BoardCell[][] cells) {
		this.cells = cells;
	}
	
	public BoardCell[][] getCells() {
		return cells;
	}
	
	public void setCells(BoardCell[][] cells) {
		this.cells = cells;
	}

	public void putCell(BoardCell cell) {
		int x = cell.getCoordX();
		int y = cell.getCoordY();
		this.cells[x][y] = cell;
	}
	

}
