package com.iba.demo.tictak.model;

/**
 * @author Alexander Medvedev, Pavel Bekish
 */

public class Turn {

	private Player taker;
	
	private BoardCell cell;
	
	public Turn(Player taker, BoardCell cell) {
		super();
		this.taker = taker;
		this.cell = cell;
	}

	public Player getTaker() {
		return taker;
	}

	public BoardCell getTurnCell() {
		return getCell();
	}

	public BoardCell getCell() {
		return cell;
	}
	
	
}
