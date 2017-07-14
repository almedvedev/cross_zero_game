package com.iba.demo.tictak.model.validation;

import java.util.ArrayList;
import java.util.List;

import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.BoardCell;
import com.iba.demo.tictak.model.BoardCellState;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;

/**
 * @author Pavel Bekish
 */

public class TurnValidator {
	
	private Game game;
	
	private Turn turn;
	
	private List<ErrorMessage> messages;

	public TurnValidator(Game game, Turn turn) {
		super();
		this.game = game;
		this.turn = turn;
	}
	
	public ErrorMessage[] getMessages() {
		if (messages == null) {
			return new ErrorMessage[0]; 
		}
		return messages.toArray(new ErrorMessage[0]);
	}
	
	public boolean hasError() {
		return (messages != null) && (messages.size() > 0);
	}
	
	public boolean validate() {		
		validateTurnTaker();
		validateTurnCell();		
		return hasError();
	}

	private void validateTurnCell() {
		BoardCell turnCell  = turn.getCell();		
		validateCellIsInRange(turnCell);		
		validateCellIsEmpty(turnCell);
	}

	private void validateTurnTaker() {
		if ( !game.getTurnTaker().equals( turn.getTaker() ) ) {
			addMessage(ErrorCode.WRONG_TURN_TAKER, "Sorry, it's not your turn");
		}
	}

	private void validateCellIsInRange(BoardCell turnCell) {
		boolean isInXRange = isInRange( turnCell.getCoordX() );
		boolean isInYRange = isInRange( turnCell.getCoordY() );
		boolean isRangesValid = isInXRange && isInYRange;		
		if ( !isRangesValid ) {
			addMessage(ErrorCode.CELL_OUT_OF_BOARD, "Cell is out of board");
		}
	}
	
	private void validateCellIsEmpty(BoardCell turnCell) {
		Board board = game.getBoard();
		BoardCell boardCell = board.getCell( turnCell.getCoordX(), turnCell.getCoordY() );
		BoardCellState boardCellState = boardCell.getState();
		
		if ( !BoardCellState.EMPTY.equals(boardCellState) ) {
			addMessage(ErrorCode.INALID_CELL_STATE, "Cell is buisy");
		}
	}

	private boolean isInRange(int coord) {
		return (coord >= 0) || (coord < Board.SIZE);
	}

	private void addMessage(String code, String message) {
		if (messages != null) {
			messages = new ArrayList<ErrorMessage>();
		}
		messages.add(new ErrorMessage(code, message));
	}
	

}
