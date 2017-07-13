package com.iba.demo.tictak.service.impl;

import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Player;
import com.iba.demo.tictak.model.factory.GameFactory;

public class GameCreatorServiceImpl {
	
	public Game createGame(Player creator) {
		// TODO: 
		GameFactory gameFactory = GameFactory.newGameFactory(null, null);
		return gameFactory.createGame();
	}

}
