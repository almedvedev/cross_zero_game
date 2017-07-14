package com.iba.demo.tictak.service.impl;

import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.BoardCell;
import com.iba.demo.tictak.model.BoardCellState;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.PlayerMark;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.service.BotService;
import com.iba.demo.tictak.util.RandomGenerator;

/**
 * @author Tatarenko_V
 *
 */
public class BotServiceImpl implements BotService {
	
	/* (non-Javadoc)
	 * @see com.iba.demo.tictak.service.BotService#generateRandomTurn(com.iba.demo.tictak.model.Game)
	 */
	@Override
	public Turn generateRandomTurn(Game game) {
		if (game.getRemainingTurns() > 0) {
			
			int turnNumRnd = new RandomGenerator().getRandomNumInRange(0, game.getRemainingTurns() - 1);
			int freeCellNum = 0;
			Board board = game.getBoard();
			BoardCell cell;

			for (int x = 0; x < Board.SIZE; x++) {
				for (int y = 0; y < Board.SIZE; y++) {
					cell = board.getCell(x, y);
					if (BoardCellState.EMPTY.equals(cell.getState()) && freeCellNum++ == turnNumRnd) {
						return new Turn(game.getTurnTaker(), 
								new BoardCell(x, y, PlayerMark.CROSS.equals( game.getTurnTaker().getMark()) ?
								BoardCellState.CROSS:BoardCellState.NOUGHT));
					}
				}
			}
		}
		return null;
	}
}

