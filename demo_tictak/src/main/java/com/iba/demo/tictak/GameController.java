package com.iba.demo.tictak;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.iba.demo.tictak.model.Board;

@Controller
public class GameController {

    @RequestMapping("/game")
    public void newGame(Model model) {
        model.addAttribute("name", "TicTak");
    }

    @PostMapping("/board")
    public ResponseEntity<?> getSearchResultViaAjax(@RequestBody String search, Errors errors) {
        Board board = new Board();
        Gson gson = new Gson();
        String result = gson.toJson(board);
        if (errors.hasErrors()) {
            result = "Something went wrong";
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

}
