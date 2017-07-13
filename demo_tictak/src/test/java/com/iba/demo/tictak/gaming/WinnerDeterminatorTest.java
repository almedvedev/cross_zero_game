package com.iba.demo.tictak.gaming;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.factory.GameFactory;

public class WinnerDeterminatorTest {
	
	private WinnerDeterminator winnerDeterminator = new WinnerDeterminator();

	@Test
	public void testDetermineWinner() {
		Game game = GameFactory.newGameFactory().createGame();
		Board board = game.getBoard();
		winnerDeterminator.determineWinner(game);
		assertEquals(null, game.getWinner());
		
	}

}
