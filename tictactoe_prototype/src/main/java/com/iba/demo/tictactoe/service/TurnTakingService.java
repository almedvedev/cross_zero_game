package com.iba.demo.tictactoe.service;

import com.iba.demo.tictactoe.exceptions.GameException;
import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Turn;

public interface TurnTakingService {

	void takeTurn(Game game, Turn turn) throws GameException;

}