package com.iba.demo.tictak.model;

public class Board {
	
	public final static int SIZE = 3;
	
	private BoardCell[][] cells;
	
	public Board(BoardCell[][] cells) {
		this.cells = cells;
	}
	
	public BoardCell getCell(int coordX, int coordY) {
		return cells[coordX][coordY];
	}
	
	public void updateWithCell(BoardCell cell) {
		int x = cell.getCoordX();
		int y = cell.getCoordY();
		this.cells[x][y] = cell;
	}
	

}
