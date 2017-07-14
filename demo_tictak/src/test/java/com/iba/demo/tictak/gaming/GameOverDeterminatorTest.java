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
import com.iba.demo.tictak.model.GameOver;
import com.iba.demo.tictak.model.GameOverCond;
import com.iba.demo.tictak.model.Player;
import com.iba.demo.tictak.model.PlayerMark;
import com.iba.demo.tictak.model.factory.GameFactory;

@RunWith(Parameterized.class)
public class GameOverDeterminatorTest {
	
	private GameOverDeterminator gameOverDeterminator = new GameOverDeterminator();
	
	private Game game;
	
	private GameOver expectedGameOver; 
	
	public GameOverDeterminatorTest(Game game, GameOver gameOver) {
		super();
		this.game = game;
		this.expectedGameOver = gameOver;
	}

	@Parameters
    public static Collection<Object[]> data() {
    	Player crossPlayer = new Player("1", PlayerMark.CROSS);
    	Player noughtPlayer = new Player("2", PlayerMark.NOUGHT);
    	GameFactory gameFactory = GameFactory.newGameFactory(crossPlayer, noughtPlayer);
    	
    	Game game0 = gameFactory.createGame();
    	game0.setRemainingTurns(9);
    	
    	Game game1 = gameFactory.createGame();
    	game1.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game1.getBoard().getCell(1, 1).setState( BoardCellState.CROSS );
    	game1.getBoard().getCell(2, 2).setState( BoardCellState.CROSS );
    	game1.setRemainingTurns(4);
    	
    	Game game2 = gameFactory.createGame();
    	game2.getBoard().getCell(2, 0).setState( BoardCellState.NOUGHT );
    	game2.getBoard().getCell(1, 1).setState( BoardCellState.NOUGHT );
    	game2.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	game2.setRemainingTurns(4);
    	
    	Game game3 = gameFactory.createGame();
    	game3.getBoard().getCell(0, 0).setState( BoardCellState.NOUGHT );
    	game3.getBoard().getCell(0, 1).setState( BoardCellState.NOUGHT );
    	game3.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	game3.setRemainingTurns(4);
    	
    	Game game4 = gameFactory.createGame();
    	game4.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game4.getBoard().getCell(1, 0).setState( BoardCellState.CROSS );
    	game4.getBoard().getCell(2, 0).setState( BoardCellState.CROSS );
    	game4.setRemainingTurns(4);
    	
    	Game game5 = gameFactory.createGame();
    	game5.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game5.getBoard().getCell(0, 1).setState( BoardCellState.CROSS );
    	game5.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	game5.setRemainingTurns(4);
    	
    	Game game6 = gameFactory.createGame();
    	game6.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game6.getBoard().getCell(0, 1).setState( BoardCellState.CROSS );
    	game6.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	game6.getBoard().getCell(1, 2).setState( BoardCellState.NOUGHT );
    	game6.getBoard().getCell(2, 2).setState( BoardCellState.NOUGHT );
    	game6.setRemainingTurns(4);
    	
    	Game game7 = GameFactory.newGameFactory(null, null).createGame();
    	game7.getBoard().getCell(0, 0).setState( BoardCellState.CROSS );
    	game7.getBoard().getCell(0, 1).setState( BoardCellState.CROSS );
    	game7.getBoard().getCell(0, 2).setState( BoardCellState.NOUGHT );
    	
    	game7.getBoard().getCell(1, 0).setState( BoardCellState.NOUGHT );
    	game7.getBoard().getCell(1, 1).setState( BoardCellState.CROSS );
    	game7.getBoard().getCell(1, 2).setState( BoardCellState.NOUGHT );
    	
    	game7.getBoard().getCell(2, 0).setState( BoardCellState.NOUGHT );
    	game7.getBoard().getCell(2, 2).setState( BoardCellState.CROSS );
    	game7.getBoard().getCell(2, 2).setState( BoardCellState.CROSS );
    	
    	game7.setRemainingTurns(0);
    	
        return Arrays.asList(new Object[][] {
               //  { game0, new GameOver(null, GameOverCond.NONE) }, 
                 { game1, new GameOver(crossPlayer, GameOverCond.WON_WITH_DIAGONILE_LINE) }, 
                 { game2, new GameOver(noughtPlayer, GameOverCond.WON_WITH_DIAGONILE_LINE) },
                 { game3, new GameOver(noughtPlayer, GameOverCond.WON_WITH_VERTICAL_LINE) },
                 { game4, new GameOver(crossPlayer, GameOverCond.WON_WITH_HORIZONTAL_LINE) },
                 { game5, new GameOver(null, GameOverCond.NONE) },
                 { game6, new GameOver(noughtPlayer, GameOverCond.WON_WITH_HORIZONTAL_LINE) },
                 { game7, new GameOver(null, GameOverCond.DRAW) }
           });
    }

	@Test
	public void testDetermineWinner() {
		GameOver gameOver = gameOverDeterminator.determineGameOver(game);
		assertEquals(expectedGameOver.getWinner(), gameOver.getWinner());
		assertEquals(expectedGameOver.getGameOverCond(), gameOver.getGameOverCond());
	}

}
