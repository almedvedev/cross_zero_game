package com.iba.demo.tictak.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.gaming.TurnMaker;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.model.factory.GameFactory;
import com.iba.demo.tictak.model.factory.RandomPlayerGameFactory;
import com.iba.demo.tictak.service.GameService;
import com.iba.demo.tictak.store.GameStore;
import com.iba.demo.tictak.store.InMemoryGameStore;

/**
 * @author Alexander Medvedev
 */


@Service("gameService")
public class GameServiceImpl implements GameService {
	
	//@Autowired
	private GameStore gameStore = InMemoryGameStore.getInstance();
	
	public Game createRandomGame() {
		GameFactory gameFactory = RandomPlayerGameFactory.newGameFactory();
		return gameFactory.createGame();
	}
	
	public void saveGame(Game game) {
		gameStore.saveGame(game);
	}
	
	public Game findGameById(String gameId) throws GameException {
		return gameStore.findGameById(gameId);
	}
	
	public void makeTurn(Game game, Turn turn) throws GameException {
		TurnMaker turnMaker = new TurnMaker();
		turnMaker.makeTurn(game, turn);
	}

}
