package com.iba.demo.tictak.gaming;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.model.factory.GameFactory;
import com.iba.demo.tictak.model.factory.RandomPlayerGameFactory;
import com.iba.demo.tictak.model.helper.GameBoardHelper;
import com.iba.demo.tictak.screen.Screen;
import com.iba.demo.tictak.screen.console.BoardTemplate;
import com.iba.demo.tictak.screen.console.ConsoleScreen;
import com.iba.demo.tictak.screen.console.View;
import com.iba.demo.tictak.service.BotService;
import com.iba.demo.tictak.service.GameService;
import com.iba.demo.tictak.service.impl.BotServiceImpl;
import com.iba.demo.tictak.service.impl.GameServiceImpl;

public class GamePlayTest {
	
	private Screen screen = new ConsoleScreen();
	
	private GameService gameService = new GameServiceImpl();
	
	private BotService botService = new BotServiceImpl();
	
	@Test
	public void testGamePlay() {
		GameFactory gameFactory = RandomPlayerGameFactory.newGameFactory(); 
		Game game = gameFactory.createGame();
		
		int turnCounter = 0;
		
		while( !game.isGameOver() ) {
			turnCounter ++;
			if (turnCounter > Board.SIZE * Board.SIZE) {
				fail("Game is not over: too many turns");
			}
			
			Turn turn = botService.generateRandomTurn(game);
			try {
				gameService.makeTurn(game, turn);
			} catch (GameException e) {	
				fail( e.getMessage() );
				e.printStackTrace();
			}
			
			View view = buildView( game.getBoard() );
			screen.display( view );
		}
		
	}
	
	private View buildView(Board board) {
		View view = new View();
		view.setTemplate(new BoardTemplate().buildTemplate(Board.SIZE));
		view.setValues(board);
		return view;
	}	
	

}
