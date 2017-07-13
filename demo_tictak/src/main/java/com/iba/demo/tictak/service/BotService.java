package com.iba.demo.tictak.service;

import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;

public interface BotService {

	Turn makeRandomTurn(Game game);

}