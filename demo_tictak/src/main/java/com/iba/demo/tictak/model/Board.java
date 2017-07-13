package com.iba.demo.tictak.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<String[]> boardState;

    public Board() {
        boardState = new ArrayList<String[]>();
        String[] boardStateRow = new String[3];
        boardStateRow[0] = "x";
        boardStateRow[1] = "o";
        boardStateRow[2] = "x";
        boardState.add(boardStateRow);
        boardState.add(boardStateRow);
        boardState.add(boardStateRow);
    }

    public List<String[]> getBoardState() {
        return boardState;
    }
}
