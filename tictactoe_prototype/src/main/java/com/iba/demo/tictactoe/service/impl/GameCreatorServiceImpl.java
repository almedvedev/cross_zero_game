package com.iba.demo.tictactoe.service.impl;

import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.factory.GameFactory;

public class GameCreatorServiceImpl {
	
	public Game createGame() {
		// TODO: 
		GameFactory gameFactory = GameFactory.newGameFactory(null, null);
		return gameFactory.createGame();
	}

}
