package com.iba.demo.tictak.store;

import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.model.Game;

/**
 * @author Alexander Medvedev
 */

//@Component("gameStore")
public class InMemoryGameStore implements GameStore {
	
	private Map<String, Game> idGameMap = new ConcurrentHashMap<String, Game>();
	
	private volatile static GameStore instance;
	
	public static GameStore getInstance() { // TODO: autowire
		if (instance == null) {
			synchronized (InMemoryGameStore.class) {
				if (instance == null) {
					instance = new InMemoryGameStore();
				}
			}
		}
		return instance;
	}
	
	
	/* (non-Javadoc)
	 * @see com.iba.demo.tictak.store.GameStore#saveGame(com.iba.demo.tictak.model.Game)
	 */
	@Override
	public void saveGame(Game game) {
		idGameMap.put(game.getId(), game);
	}
	
	/* (non-Javadoc)
	 * @see com.iba.demo.tictak.store.GameStore#findGameById(java.lang.String)
	 */
	@Override
	public Game findGameById(String gameId) throws GameException {		
		final Game game = idGameMap.get(gameId);
		if (game == null) {
			String message = String.format("Game not found in store, used id=%s ", gameId);
			throw new GameException(message);
		}
		return game;
	}

}
