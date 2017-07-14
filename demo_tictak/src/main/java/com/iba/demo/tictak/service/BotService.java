package com.iba.demo.tictak.service;

import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;

/**
 * @author Alexander Medvedev
 */

public interface BotService {

	Turn generateRandomTurn(Game game);

}