package com.iba.demo.tictak.screen.console;

import java.util.List;

import com.iba.demo.tictak.model.BoardCellState;
import com.iba.demo.tictak.screen.Screen;

/**
 * @author Pavel Bekish
 */
public class ConsoleScreen implements Screen {

	@Override
	public void display(View view) {
		List<BoardCellState> states = view.getValues();
		StringBuilder templ = new StringBuilder(view.getTemplate());
		
		Integer counter = 0;
		
		for(int i=0; i < templ.length(); i++) {
			Character c = templ.charAt(i);
			
			if(c.equals(Primitives.EMPTY) ) {
				BoardCellState state = states.get(counter);
				if(state == BoardCellState.CROSS) {
					templ.setCharAt(i, Primitives.CROSS_MARK);
				} else if(state == BoardCellState.NOUGHT) {
					templ.setCharAt(i, Primitives.NOUGHT_MARK);
				} else {
					templ.setCharAt(i, Primitives.EMPTY);
				}

				counter++;
			}
		}
		
		System.out.println(templ.toString()); 
	}
	
}
