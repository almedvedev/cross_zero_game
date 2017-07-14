package com.iba.demo.tictak.model.factory;

import com.iba.demo.tictak.model.Player;
import com.iba.demo.tictak.model.PlayerMark;

public class RandomPlayerGameFactory extends GameFactory {
	
	protected RandomPlayerGameFactory() {
		super(new Player("1", PlayerMark.CROSS), new Player("2", PlayerMark.NOUGHT));
	}
	
	public static GameFactory newGameFactory() {
		return new RandomPlayerGameFactory();
	}
}
