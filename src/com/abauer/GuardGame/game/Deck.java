package com.abauer.GuardGame.game;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	ArrayList<Card> cards;
	boolean exists[][];
	Random r;
	
	public Deck(long seed) {
		cards = new ArrayList<Card>();
		exists = new boolean[13][4];
		r = new Random(seed);
		createDeck();
	}

	public void createDeck() {
		for(int count = 0; count < 52; count++) {
			int c = 0;
			int s = 0;
			do {
			 	c = getInteger(1,13);
			 	s = getInteger(1,4);
			} while(exists[c-1][s-1]==true);
			exists[c-1][s-1]=true;
			cards.add(new Card(c,s));
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public Card pop(){
		return cards.remove(0);
	}
	
	private int getInteger(int min, int max){
		int flag = 
		r.nextInt(max-min+1)+min;
		return flag;
	}
}
