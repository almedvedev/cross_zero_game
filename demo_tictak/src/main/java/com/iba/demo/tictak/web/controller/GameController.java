package com.iba.demo.tictak.web.controller;

import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iba.demo.tictak.model.Game;
import com.iba.demo.tictak.model.Turn;
import com.iba.demo.tictak.service.BotService;
import com.iba.demo.tictak.service.GameService;
import com.iba.demo.tictak.service.impl.BotServiceImpl;
import com.iba.demo.tictak.service.impl.GameServiceImpl;

/**
 * @author  Alexandra Karpova, Alexander Medvedev
 */

@Controller
public class GameController {

    @Autowired
    private BotService botService;

    @Autowired
    private GameService gameService;

    @RequestMapping("/game")
    public void newGame(Model model) {
        botService = new BotServiceImpl();
        gameService = new GameServiceImpl();
        model.addAttribute("name", "TicTak");
    }

    @PostMapping("/new_game")
    public ResponseEntity<?> createNewGame(@RequestBody String postAction, Errors errors) {
        Game game = gameService.createRandomGame();
        gameService.saveGame(game);
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
        String gameId = getGameIdFromRequest(gson, postAction);
        
        //TODO: validate game id
        
        Game game = gameService.findGameById(gameId);
        Turn turn = botService.generateRandomTurn(game);
        gameService.makeTurn(game, turn);

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body("Error on:" + postAction);
        }
        return ResponseEntity.ok(gson.toJson(game));
    }
    
//    public ResponseEntity<?> makeTurn(@RequestBody Turn turn) throws Exception {
//    	String gameId = null; //  get gameId
//   	 	Game game = gameService.findGameById(gameId);
//   	 	TurnValidator turnValidator = new TurnValidator(game, turn);
//   	 	turnValidator.validate();
//   	 	if ( turnValidator.hasError() ) {
//   	 		// handle error 
//   	 	}
//   	 	gameService.makeTurn(game, turn);    	
//    	return ResponseEntity.ok(game);
//    }

	private String getGameIdFromRequest(Gson gson, String postAction) {
		Type mapType = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> postParams = gson.fromJson(postAction, mapType);
        return postParams.get("id");		
	}

}
