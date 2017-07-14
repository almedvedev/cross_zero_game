package com.iba.demo.tictak.web.controller;

import com.google.gson.reflect.TypeToken;
import com.iba.demo.tictak.model.factory.RandomPlayerGameFactory;
import com.iba.demo.tictak.service.impl.BotServiceImpl;
import com.iba.demo.tictak.service.impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.iba.demo.tictak.model.BoardMock;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.model.factory.GameFactory;
import com.iba.demo.tictak.model.validation.TurnValidator;
import com.iba.demo.tictak.service.BotService;
import com.iba.demo.tictak.service.GameService;

import java.lang.reflect.Type;
import java.util.Map;

@Controller
public class GameController {

    private Game game;

    private BotService botService;

    private GameService gameService;

    @RequestMapping("/game")
    public void newGame(Model model) {
        botService = new BotServiceImpl();
        gameService = new GameServiceImpl();
        model.addAttribute("name", "TicTak");
    }

    @PostMapping("/board")    
    public ResponseEntity<?> getSearchResultViaAjax(@RequestBody String search, Errors errors) {
        BoardMock board = new BoardMock();
        Gson gson = new Gson();
        String result = gson.toJson(board);
        if (errors.hasErrors()) {
            result = "Something went wrong";
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
    
    @PostMapping("/game2")
    public ResponseEntity<?> getGame(@RequestBody String search, Errors errors) {        
        return ResponseEntity.ok(GameFactory.newGameFactory(null, null).createGame());
    }
    
    public ResponseEntity<?> makeBotTurn(@RequestParam String gameId) throws Exception {
    	Game game = null; // get from GameServiceImpl
    	Turn turn = botService.generateRandomTurn(game);
    	gameService.makeTurn(game, turn);
    	return ResponseEntity.ok(game);
    }
    
    public ResponseEntity<?> makeTurn(@RequestBody Turn turn) throws Exception {
    	String gameId = null; // TODO: somehow get gameId
   	 	Game game = gameService.findGameById(gameId);
   	 	TurnValidator turnValidator = new TurnValidator(game, turn);
   	 	turnValidator.validate();
   	 	if ( turnValidator.hasError() ) {
   	 		// TODO: handle error 
   	 	}
   	 	gameService.makeTurn(game, turn);    	
    	return ResponseEntity.ok(game);
    }

    @PostMapping("/new_game")
    public ResponseEntity<?> createNewGame(@RequestBody String postAction, Errors errors) {
        game = RandomPlayerGameFactory.newGameFactory().createGame();
        Gson gson = new Gson();
        String result = gson.toJson(game);
        if (errors.hasErrors()) {
            result = "Error on:" + postAction;
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/make_bot_turn")
    public ResponseEntity<?> makeBotTurn(@RequestBody String postAction, Errors errors) throws Exception {
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> postParams = gson.fromJson(postAction, mapType);
        String id = postParams.get("id");
        Turn turn = botService.generateRandomTurn(game);
        gameService.makeTurn(game, turn);

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body("Error on:" + postAction);
        }
        return ResponseEntity.ok(gson.toJson(game));
    }

}
