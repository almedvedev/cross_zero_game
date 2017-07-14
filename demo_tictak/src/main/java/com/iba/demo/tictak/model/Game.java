package com.iba.demo.tictak.model;

import java.util.UUID;

public class Game {
	
	private String id;
	
	private Player crossPlayer;
	
	private Player noughtPlayer;
	
	private Player turnTaker;
	
	private int remainingTurns;
	
	private GameStatus status;
	
	private GameOver gameOver;
	
	private Board board;
	
	public Game(Player crossPlayer, Player noughtPlayer, Board board) {
		super();
		this.crossPlayer = crossPlayer;
		this.noughtPlayer = noughtPlayer;
		this.turnTaker = crossPlayer; 
		this.board = board;
		this.remainingTurns = Board.SIZE * Board.SIZE;
		this.id = UUID.randomUUID().toString();
		this.status = GameStatus.IN_PROPGRESS;
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
	
	public int getRemainingTurns() {
		// or count empty cells
		return remainingTurns;
	}

	public void setRemainingTurns(int remainingTurns) {
		this.remainingTurns = remainingTurns;
	}
	
	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public GameOver getGameOver() {
		return gameOver;
	}
	
	public boolean isGameOver() {
		return GameStatus.GAME_OVER.equals( getStatus() ); 
	}

	public void setGameOver(GameOver gameOver) {
		this.gameOver = gameOver;
		if ( !GameOverCond.NONE.equals( gameOver.getGameOverCond() ) ) {
			this.setStatus(GameStatus.GAME_OVER);
		}
	}

	public Board getBoard() {
		return board;
	}
	

}
