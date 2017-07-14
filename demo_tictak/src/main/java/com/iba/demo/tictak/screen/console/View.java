package com.iba.demo.tictak.screen.console;

import java.util.ArrayList;
import java.util.List;

import com.iba.demo.tictak.model.Board;
import com.iba.demo.tictak.model.BoardCell;
import com.iba.demo.tictak.model.BoardCellState;

/**
 * @author Pavel Bekish
 */
public class View {

	private StringBuilder template;
	private List<BoardCellState> values;
	
	public void setValues(Board board) {
		values = new ArrayList<>();
		
		for(int i = 0; i < Board.SIZE; i++) {
			for(int j = 0; j < Board.SIZE; j++) {
				BoardCell cell = board.getCell(i, j);
				values.add(cell.getState());
			}
		}
	}
	
	public void setTemplate(StringBuilder sb) {
		this.template = sb;
	}

	public StringBuilder getTemplate() {
		return template;
	}

	public List<BoardCellState> getValues() {
		return values;
	}
	
	
	
}
