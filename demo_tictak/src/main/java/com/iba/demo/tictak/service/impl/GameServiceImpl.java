package com.iba.demo.tictak.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.gaming.TurnMaker;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Player;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.model.factory.GameFactory;
import com.iba.demo.tictak.service.GameService;
import com.iba.demo.tictak.store.GameStore;

public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameStore store;
	
	public Game createGame(Player creator) {
		// TODO: 
		GameFactory gameFactory = GameFactory.newGameFactory(null, null);
		return gameFactory.createGame();
	}
	
	public void saveGame(Game game) {
		store.saveGame(game);
	}
	
	public Game findGameById(String gameId) throws GameException {
		return store.findGameById(gameId);
	}
	
	public void makeTurn(Game game, Turn turn) throws GameException {
		TurnMaker turnMaker = new TurnMaker();
		turnMaker.makeTurn(game, turn);
	}

}
