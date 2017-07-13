package com.iba.demo.tictak.gaming;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.iba.demo.tictak.model.BoardCellState;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Player;
import com.iba.demo.tictak.model.PlayerMark;
import com.iba.demo.tictak.model.factory.GameFactory;

@RunWith(Parameterized.class)
public class WinnerDeterminatorTest {
	
	private WinnerDeterminator winnerDeterminator = new WinnerDeterminator();
	
	private Game game;
	
	private Player expectedWinner; 
	
	public WinnerDeterminatorTest(Game game, Player winner) {
		super();
		this.game = game;
		this.expectedWinner = winner;
	}

	@Parameters
    public static Collection<Object[]> data() {
    	Player crossPlayer = new Player("1", PlayerMark.CROSS);
    	Player noughtPlayer = new Player("2", PlayerMark.NOUGHT);
    	GameFactory gameFactory = GameFactory.newGameFactory(crossPlayer, noughtPlayer);
    	
    	Game game1 = gameFactory.createGame();
    	
    	Game game2 = gameFactory.createGame();
    	game2.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game2.getBoard().getCell(1, 1).setState( BoardCellState.CROSS );
    	game2.getBoard().getCell(2, 2).setState( BoardCellState.CROSS );
    	
    	Game game3 = gameFactory.createGame();
    	game3.getBoard().getCell(2, 0).setState( BoardCellState.NOUGHT );
    	game3.getBoard().getCell(1, 1).setState( BoardCellState.NOUGHT );
    	game3.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	
    	Game game4 = gameFactory.createGame();
    	game4.getBoard().getCell(0, 0).setState( BoardCellState.NOUGHT );
    	game4.getBoard().getCell(0, 1).setState( BoardCellState.NOUGHT );
    	game4.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	
    	Game game5 = gameFactory.createGame();
    	game5.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game5.getBoard().getCell(1, 0).setState( BoardCellState.CROSS );
    	game5.getBoard().getCell(2, 0).setState( BoardCellState.CROSS );
    	
    	Game game6 = gameFactory.createGame();
    	game6.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game6.getBoard().getCell(0, 1).setState( BoardCellState.CROSS );
    	game6.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	
    	Game game7 = gameFactory.createGame();
    	game7.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game7.getBoard().getCell(0, 1).setState( BoardCellState.CROSS );
    	game7.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	game7.getBoard().getCell(1, 2).setState( BoardCellState.NOUGHT );
    	game7.getBoard().getCell(2, 2).setState( BoardCellState.NOUGHT );
    	
        return Arrays.asList(new Object[][] {     
                 { game1, null }, 
                 { game2, crossPlayer }, 
                 { game3, noughtPlayer },
                 { game4, noughtPlayer },
                 { game5, crossPlayer },
                 { game6, null },
                 { game7, noughtPlayer }
           });
    }

	@Test
	public void testDetermineWinner() {
		Player winner = winnerDeterminator.determineWinner(game);
		assertEquals(expectedWinner, winner);		
	}

}
