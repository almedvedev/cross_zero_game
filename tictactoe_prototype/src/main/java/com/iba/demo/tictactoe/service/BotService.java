package com.iba.demo.tictactoe.service;

import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Turn;

public interface BotService {

	Turn makeRandomTurn(Game game);

}