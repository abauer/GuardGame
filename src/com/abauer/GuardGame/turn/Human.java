package com.abauer.GuardGame.turn;

import java.awt.event.MouseEvent;

import com.abauer.GuardGame.game.Card;

public class Human extends Player{
	
	public Human(){
		super();
	}
	
	public void sendClick(MouseEvent me){
		for(int index = hand.size()-1; index>=0; index--){
			if(hand.get(index).isInside(me.getX(),me.getY())){
				toggleSelected(hand.get(index));
				return;
			}
		}
	}
	
	private void toggleSelected(Card c){
		for(int index = 0; index<selected.length; index++){
			if(selected[index]!=null){
				if(selected[index].equals(c)){
					selected[index]=null;
					return;
				}
			}
		}
		for(int index = 0; index<selected.length; index++){
			if(selected[index]==null){
				selected[index]=c;
				return;
			}
		}
	}
	
	public boolean isSelected(Card c){
		for(int index = 0; index<selected.length; index++){
			if(selected[index]!=null){
				if(selected[index].equals(c)){
					return true;
				}
			}
		}
		return false;
	}	
}
