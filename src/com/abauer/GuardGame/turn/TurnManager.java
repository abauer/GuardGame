package com.abauer.GuardGame.turn;

import com.abauer.GuardGame.game.*;

public class TurnManager {
	
	Game g;
	boolean triple = false;
	Player p1,p2,p3;
	
	public TurnManager(Player p1,Player p2){
		g = new DuoGame(this);
		this.p1 = p1;
		this.p2 = p2;
		dealCards();
	}
	public TurnManager(Player p1,Player p2,Player p3){
		g = new TriGame(this);
		triple = true;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		dealCards();
	}
	
	private void dealCards(){
		System.out.println("Here once");
		Deck d = g.getDeck();
		Card c;
		int loop = 4;
		if(!triple){
			p1.setflop(d.pop(), d.pop(), d.pop(), d.pop());
			p2.setflop(d.pop(), d.pop(), d.pop(), d.pop());
		}
		else{
			p1.setflop(d.pop(), d.pop(), d.pop());
			p2.setflop(d.pop(), d.pop(), d.pop());
			p3.setflop(d.pop(), d.pop(), d.pop());
		}
		loop = 8;
		if(triple)
			loop = 6;
		for(int index=0; index<loop; index++){
			c = d.pop();
			c.setVisible(true);
			p1.addCard(c);
			c = d.pop();
			if(index<loop/2)
				c.setVisible(true);
			p2.addCard(c);
			if(triple){
				c = d.pop();
				if(index<loop/2)
					c.setVisible(true);
				p3.addCard(c);
			}
		}
	}
	
	public Game getGame(){
		return g;
	}
	
	public Player getP1(){
		return p1;
	}
	
	public Player getP2(){
		return p2;
	}
}
