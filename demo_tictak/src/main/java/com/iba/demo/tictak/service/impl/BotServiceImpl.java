package com.iba.demo.tictak.service.impl;

import com.iba.demo.tictak.model.BoardCell;
import com.iba.demo.tictak.model.BoardCellState;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.service.BotService;

public class BotServiceImpl implements BotService {
	
	/* (non-Javadoc)
	 * @see com.iba.demo.tictak.web.application.service.impl.BotService#makeRandomTurn(com.iba.demo.tictactoe.model.Game)
	 */
	@Override
	public Turn makeRandomTurn(Game game) {
		// TODO: by Victor
		Turn turn = null;
		BoardCell cell = game.getBoard().getCell(0, 0);
		BoardCellState state = cell.getState();
		
		return turn;
	}

}
