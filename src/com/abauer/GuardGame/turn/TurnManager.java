package com.abauer.GuardGame.turn;

import com.abauer.GuardGame.game.*;

public class TurnManager {
	
	Game g;
	
	public TurnManager(Player... players){
		if(players.length>=3)
			g = new TriGame(this);
		else
			g = new DuoGame(this);
		g.dealCards();
	}
	
	public Game getGame(){
		return g;
	}
}
