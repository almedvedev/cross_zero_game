package com.iba.demo.tictak.web.controller;

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
import com.iba.demo.tictak.model.validation.TurnValidator;
import com.iba.demo.tictak.service.BotService;
import com.iba.demo.tictak.service.GameService;

@Controller
public class GameController {
	
	private BotService botService;
	
	private GameService gameService; 

    @RequestMapping("/game")
    public void newGame(Model model) {
    	
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

}
