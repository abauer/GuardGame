package com.abauer.GuardGame.game;

import java.util.ArrayList;

import com.abauer.GuardGame.turn.TurnManager;

public class DuoGame extends Game{
	
	private static final long serialVersionUID = 1L;
	
	public DuoGame(TurnManager tm){
		super(tm);
	}
	
	protected void drawHands(){
		super.drawHands();
		Card[] shelf = tm.getP2().getShelf();
		for(int index=0; index<shelf.length; index++){
			if(shelf[index]!=null){
				shelf[index].drawCard(main, 50+index*50, 100);
			}
		}
		ArrayList<Card> hand = tm.getP2().getHand();
		for(int index=0; index<hand.size(); index++){
			int spaceing = 300/hand.size();
			hand.get(index).drawCard(main,400+index*spaceing,100);
		}
	}
}
