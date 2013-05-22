package com.abauer.GuardGame.turn;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.abauer.GuardGame.game.Card;
import com.abauer.GuardGame.game.Deck;

public class Player {
	
	ArrayList<Card> hand;
	Card shelf[] = new Card[4];
	Card flop[] = new Card[4];
	Card[] selected = new Card[4];
	
	public Player(){
		hand = new ArrayList<Card>();
	}
	
	public void addCard(Card c){
		hand.add(c);
	}
	
	public void setflop(Card...cards){
		flop[0]=cards[0];
		flop[1]=cards[1];
		flop[2]=cards[2];
		if(cards.length>3)
			flop[3]=cards[3];
	}
	
	public void setshelf(Card...cards){
		shelf[0]=cards[0];
		shelf[1]=cards[1];
		shelf[2]=cards[2];
		if(cards.length>3)
			shelf[3]=cards[3];
	}
	
	public void sendClick(MouseEvent me){
		
	}
	
	protected void addSelected(Card c){

	}
	
	public void takeTurn(int turn){
		
	}
	
	public boolean isSelected(Card c){
		return false;
	}
	
	public void draw(Deck d){
		while(hand.size()<4&&d.hasCard()){
			Card c = d.pop();
			c.setVisible(true);
			hand.add(c);
		}
	}
	
	public boolean finished(int turn){
		return TurnManager.followsRules(turn,selected);
	}
	
	public Card[] getFlop(){
		return flop;
	}
	
	public Card[] getShelf(){
		return shelf;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public void remove(){
		for(int index = 0; index<selected.length; index++){
			hand.remove(selected[index]);
		}
		selected = new Card[selected.length];
	}
	
	protected void delay(int time){
		try{
			Thread.sleep(time);
		} catch(Exception e) {}
	}
}
