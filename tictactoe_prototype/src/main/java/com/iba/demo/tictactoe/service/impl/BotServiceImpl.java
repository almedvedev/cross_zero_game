package com.iba.demo.tictactoe.service.impl;

import com.iba.demo.tictactoe.model.Board;
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

//TODO		
//		int turnRnd = RandomGenerator.getRandomNumInRange(0, game.getRemainingTurns()-1);
		int turnRnd = 0;
		
		
		int freeCellNum=0;
		Board board = game.getBoard();
		BoardCell  cell;
		
		for(int x = 0; x < Board.SIZE; x ++) {
			for(int y = 0; y < Board.SIZE; y ++) {
				cell = board.getCell(x, y);
				if(BoardCellState.EMPTY.equals(cell.getState()) && freeCellNum++ == turnRnd ){
					return new Turn(game.getTurnTaker(), cell);
					
				}
			}
		}
		return null;
	}

}
