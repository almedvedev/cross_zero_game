package com.iba.demo.tictak.app;


import com.iba.demo.tictak.exception.GameException;
import com.iba.demo.tictak.gaming.GameOverDeterminator;
import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.BoardCellState;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.GameOver;
import com.iba.demo.tictak.model.GameOverCond;
import com.iba.demo.tictak.model.PlayerMark;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.model.factory.GameFactory;
import com.iba.demo.tictak.model.factory.RandomPlayerGameFactory;
import com.iba.demo.tictak.screen.Screen;
import com.iba.demo.tictak.screen.console.BoardTemplate;
import com.iba.demo.tictak.screen.console.ConsoleScreen;
import com.iba.demo.tictak.screen.console.View;
import com.iba.demo.tictak.service.BotService;
import com.iba.demo.tictak.service.GameService;
import com.iba.demo.tictak.service.impl.BotServiceImpl;
import com.iba.demo.tictak.service.impl.GameServiceImpl;

/**
 * @author Tatarenko_V
 *
 */
public class ConsoleDemoApp {
	private static final  int TURN_DELAY =2000;
	private Screen screen = new ConsoleScreen();
	private static View view = null;
	private GameService gameService = new GameServiceImpl();
	private BotService botService = new BotServiceImpl();

	public static void main(String[] args) {
		 
		ConsoleDemoApp demo = new ConsoleDemoApp();
		GameFactory gameFactory = RandomPlayerGameFactory.newGameFactory(); 
		Game game = gameFactory.createGame();

		GameOverDeterminator determinator = new GameOverDeterminator();
		GameOver gamover;
		String gameResult;
		int turnCounter = 0;

		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println("\nGame Board Creation…");
		try {
			Thread.sleep(TURN_DELAY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view = demo.buildView( game.getBoard() );
		demo.screen.display( view );
		
		System.out.println("Board is created."); 
		System.out.println("The game will start with player "+ (PlayerMark.CROSS.equals( game.getTurnTaker().getMark()) ?'X':'O'));


		while( !game.isGameOver() ) {
			turnCounter ++;
			if (turnCounter > Board.SIZE * Board.SIZE) {
				System.out.println("Game is not over: too many turns");
			}
			
			Turn turn = demo.botService.generateRandomTurn(game);

			System.out.println();
			System.out.println("Player "+(PlayerMark.CROSS.equals( game.getTurnTaker().getMark()) ?'X':'O') +" turn: ");
			
			try {
				demo.gameService.makeTurn(game, turn);
			} catch (GameException e) {	
				e.printStackTrace();
			}
			
			
			try {
				Thread.sleep(TURN_DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			view = demo.buildView( game.getBoard() );
			demo.screen.display( view );
			
			gamover  = determinator.determineGameOver(game);
			if (!GameOverCond.NONE.equals(gamover.getGameOverCond())) {
				
				if (GameOverCond.DRAW.equals(gamover.getGameOverCond())) {
					gameResult = "No winner";
					System.out.println("No winner");
				}
				else {
					GameOverCond  cond = gamover.getGameOverCond();
					if (cond.equals(gamover.getGameOverCond().WON_WITH_HORIZONTAL_LINE)) {
						gameResult = "won with horizontal line";
					}else if (cond.equals(gamover.getGameOverCond().WON_WITH_VERTICAL_LINE)) {
						gameResult = "won with vertical line";
					}else {
						gameResult = "won with diagonal  line";
					} 
					
//					System.out.println((PlayerMark.CROSS.equals( game.getTurnTaker().getMark()) ?
	//						BoardCellState.NOUGHT:BoardCellState.CROSS)+" player "+gameResult);
					System.out.println("Player "+(PlayerMark.CROSS.equals( game.getTurnTaker().getMark()) ?
							'O':'X')+" "+gameResult);
					
					
				}
			}
			
		}
		
		System.out.println("Game is over ...");
		
	}
	
	private View buildView(Board board) {
		View view = new View();
		view.setTemplate(new BoardTemplate().buildTemplate(Board.SIZE));
		view.setValues(board);
		return view;
	}	
	

}
