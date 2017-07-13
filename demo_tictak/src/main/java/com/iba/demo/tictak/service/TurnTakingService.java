package com.iba.demo.tictak.service;

import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;

public interface TurnTakingService {

	void takeTurn(Game game, Turn turn) throws GameException;

}