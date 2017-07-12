package com.iba.demo.tictactoe.model;

public class Game {
	
	private Player crossPlayer;
	
	private Player noughtPlayer;
	
	private Player turnTaker; 
	
	private Board board;
	
	public Board getBoard() {
		return board;
	}

	public Game(Player crossPlayer, Player noughtPlayer, Board board) {
		super();
		this.crossPlayer = crossPlayer;
		this.noughtPlayer = noughtPlayer;
		this.turnTaker = crossPlayer; 
		this.board = board;
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
	

}
