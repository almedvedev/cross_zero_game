package com.iba.demo.tictak.service;

import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;

/**
 * @author Alexander Medvedev
 */

public interface GameService {
	
	public Game createRandomGame();
	
	public void saveGame(Game game);
	
	public Game findGameById(String gameId) throws GameException;
	
	public void makeTurn(Game game, Turn turn) throws GameException;

}