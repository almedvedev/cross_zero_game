package com.iba.demo.tictak.store;

import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.model.Game;

/**
 * @author Alexander Medvedev
 */


public interface GameStore {

	public void saveGame(Game game);

	public Game findGameById(String gameId) throws GameException;

}