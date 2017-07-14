package com.iba.demo.tictak.model;


/**
 * @author Alexander Medvedev, Pavel Bekish
 */

public class BoardCell {
	
	private int coordX;
	
	private int coordY;
	
	private BoardCellState state;
	
	public BoardCell(int coordX, int coordY, BoardCellState state) {
		super();
		this.coordX = coordX;
		this.coordY = coordY;
		this.state = state;
	}

	public BoardCell(int coordX, int coordY) {
		this(coordX, coordY, BoardCellState.EMPTY);		
	}

	public int getCoordX() {
		return coordX;
	}

	public int getCoordY() {
		return coordY;
	}
	
	public BoardCellState getState() {
		return state;
	}	
	
	public void setState(BoardCellState state) {
		this.state = state;
	}
	

}
