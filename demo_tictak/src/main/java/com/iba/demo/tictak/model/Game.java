package com.iba.demo.tictak.model;

import java.util.UUID;

public class Game {
	
	private String id;
	
	private Player crossPlayer;
	
	private Player noughtPlayer;
	
	private Player turnTaker;
	
	private int remainingTurns;
	
	private Board board;
	
	public Game(Player crossPlayer, Player noughtPlayer, Board board) {
		super();
		this.crossPlayer = crossPlayer;
		this.noughtPlayer = noughtPlayer;
		this.turnTaker = crossPlayer; 
		this.board = board;
		this.remainingTurns = Board.SIZE * Board.SIZE;
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	
	public Player getCrossPlayer() {
		return crossPlayer;
	}

	public Player getNoughtPlayer() {
		return noughtPlayer;
	}
	
	public Player getTurnTaker() {
		return turnTaker;
	}

	public void setTurnTaker(Player turnTaker) {
		this.turnTaker = turnTaker;
	}
	
	public Board getBoard() {
		return board;
	}

	public int getRemainingTurns() {
		// or count empty cells
		return remainingTurns;
	}

	public void setRemainingTurns(int remainingTurns) {
		this.remainingTurns = remainingTurns;
	}
	

}
