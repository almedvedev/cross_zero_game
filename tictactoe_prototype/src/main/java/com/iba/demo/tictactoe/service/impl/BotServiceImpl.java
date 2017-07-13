package com.iba.demo.tictactoe.service.impl;

import com.iba.demo.tictactoe.model.BoardCell;
import com.iba.demo.tictactoe.model.BoardCellState;
import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Turn;
import com.iba.demo.tictactoe.service.BotService;

public class BotServiceImpl implements BotService {
	
	/* (non-Javadoc)
	 * @see com.iba.demo.tictactoe.service.impl.BotService#makeRandomTurn(com.iba.demo.tictactoe.model.Game)
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
