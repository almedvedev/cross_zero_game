package com.iba.demo.tictactoe.model.validation;

import java.util.ArrayList;
import java.util.List;

import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Board;
import com.iba.demo.tictactoe.model.BoardCell;
import com.iba.demo.tictactoe.model.Turn;

public class TurnValidator {
	
	private Game game;
	
	private Turn turn;
	
	private List<ErrorMessage> messages;

	public TurnValidator(Game game, Turn turn) {
		super();
		this.game = game;
		this.turn = turn;
	}
	
	public boolean validate() {
		if ( !game.getTurnTaker().equals( turn.getTaker() )) {
			addMessage("WRONG_PLAYER", "Sorry, it's not your turn");
		} 
		BoardCell turnCell  = turn.getCell(); //game.getBoard().getCells()
		
		//TODO: improve
		if ( turnCell.getCoordX() < 0 || turnCell.getCoordX() > Board.SIZE_X ) {
			addMessage(ErrorCode.WRONG_TURN_CELL, "Invalid cell");
		} else if ( turnCell.getCoordY() < 0 || turnCell.getCoordY() > Board.SIZE_Y ) {
			addMessage(ErrorCode.WRONG_TURN_TAKER, "Invalid cell");
		}
		//TODO: check the turn cell is applicable
		return false;
	}

	public ErrorMessage[] getMessages() {
		if (messages == null) {
			return new ErrorMessage[0]; 
		}
		return messages.toArray(new ErrorMessage[0]);
	}
	
	private void addMessage(String code, String message) {
		if (messages != null) {
			messages = new ArrayList<ErrorMessage>();
		}
		messages.add(new ErrorMessage(code, message));
	}
	
	

}
