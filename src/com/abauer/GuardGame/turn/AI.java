package com.abauer.GuardGame.turn;

public class AI extends Player{
	
	boolean done = false;
	
	public AI(){
		super();
	}
	
	public void takeTurn(int turn){
		for(int index = 0; index<hand.size(); index++){
			hand.get(index).setVisible(false);
		}
		if(turn == 1){
			for(int index = 0; index<selected.length; index++){
				selected[index] = hand.get(index);
			}				
		}
		done = true;
	}
	
	public boolean finished(int turn){
		return (done&&TurnManager.followsRules(turn,selected));
	}
	
}
