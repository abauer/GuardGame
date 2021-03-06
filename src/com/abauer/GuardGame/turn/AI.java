package com.abauer.GuardGame.turn;

import com.abauer.GuardGame.game.Card;
import com.abauer.GuardGame.game.Deck;
import com.abauer.GuardGame.gui.GameWindow;

public class AI extends Player{
	
	boolean done = false;
	
	public AI(){
		super();
	}
	
	public void takeTurn(int turn){
//		delay(1000);
		for(int index = 0; index<hand.size(); index++){
			hand.get(index).setVisible(false);
		}
		if(turn == 1){
			for(int index = 0; index<selected.length; index++){
				selected[index] = hand.get(index);
			}				
		}
		else{
			selected[0] = hand.get(0);
		}
		done = true;
		GameWindow.contained.tm.play();
		GameWindow.contained.repaint();
	}
	
	public void draw(Deck d){
		while(hand.size()<4&&d.hasCard()){
			Card c = d.pop();
			hand.add(c);
		}
	}
	
	public boolean finished(int turn){
		return (done&&TurnManager.followsRules(turn,selected));
	}	
}
