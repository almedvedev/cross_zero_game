package com.iba.demo.tictak.model;

public class GameOver {
	
	private Player winner;
	
	private GameOverCond gameOverCond;

	public GameOver(Player winner, GameOverCond gameOverCond) {
		super();
		this.winner = winner;
		this.gameOverCond = gameOverCond;
	}

	public GameOver(GameOverCond cond) {
		this(null, cond);
	}

	public Player getWinner() {
		return winner;
	}

	public GameOverCond getGameOverCond() {
		return gameOverCond;
	}

}
