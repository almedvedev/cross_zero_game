package com.iba.demo.tictactoe.model.factory;

import com.iba.demo.tictactoe.model.Game;
import com.iba.demo.tictactoe.model.Board;
import com.iba.demo.tictactoe.model.BoardCell;
import com.iba.demo.tictactoe.model.Player;
import com.iba.demo.tictactoe.model.helpers.GameBoardHelper;

public class GameFactory {
	
	private Player crossPlayer;
	
	private Player noughtPlayer;
	
	private GameFactory(Player crossPlayer, Player noughtPlayer) {
		this.crossPlayer = crossPlayer;
		this.noughtPlayer = noughtPlayer;
	}
	
	public static GameFactory newGameFactory(Player crossPlayer, Player noughtPlayer) {
		return new GameFactory(crossPlayer, noughtPlayer);
	}
	
	public Game createGame() {
		BoardCell[][] cells = GameBoardHelper.buildEmptyBoardCells(); 
		return new Game(crossPlayer, noughtPlayer, new Board(cells));
	}

}
