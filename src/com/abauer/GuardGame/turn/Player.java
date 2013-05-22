package com.abauer.GuardGame.turn;

import java.util.ArrayList;

import com.abauer.GuardGame.game.Card;

public class Player {
	
	ArrayList<Card> hand;
	Card shelf[] = new Card[4];
	Card flop[] = new Card[4];
	
	public Player(){
		hand = new ArrayList<Card>();
	}
	
	public void addCard(Card c){
		hand.add(c);
	}
	
	public void setflop(Card...cards){
		shelf[0]=cards[0];
		shelf[1]=cards[1];
		shelf[2]=cards[2];
		if(cards.length>3)
		shelf[3]=cards[3];
	}
	
//	public void setshelf(Card...cards){
//		shelf[0]=c1;
//		shelf[1]=c2;
//		shelf[2]=c3;
//		shelf[3]=c4;
//	}
	
	public Card[] getFlop(){
		return flop;
	}
	
	public Card[] getShelf(){
		return shelf;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
}
