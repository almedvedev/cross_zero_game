package com.iba.demo.tictak.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.iba.demo.tictak.model.BoardMock;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.service.BotService;
import com.iba.demo.tictak.service.TurnTakingService;

@Controller
public class GameController {
	
	private TurnTakingService turnTakingService;
	
	private BotService botService;

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
    
    public ResponseEntity<?> makeBotTurn() throws Exception {
    	 
    	Game game = null; // get from GameService
    	Turn turn = botService.makeRandomTurn(game);
    	turnTakingService.takeTurn(game, turn);
    	return ResponseEntity.ok(game);
    }
    
    public ResponseEntity<?> makeTurn(@RequestBody Turn turn) throws Exception {
   	 	Game game = null; // get from GameService
   	 	// turn validation
    	turnTakingService.takeTurn(game, turn);    	
    	return ResponseEntity.ok(game);
    }

}
