package com.abauer.GuardGame.turn;

import java.awt.event.MouseEvent;

import com.abauer.GuardGame.game.*;

public class TurnManager {
	
	Game g;
	static boolean triple = false;
	Player p1,p2,p3;
	Player turn;
	int turnnumber = 1;
	
	public TurnManager(Player p1,Player p2){
		g = new DuoGame(this);
		this.p1 = p1;
		this.p2 = p2;
		dealCards();
		turn = p1;
	}
	public TurnManager(Player p1,Player p2,Player p3){
		g = new TriGame(this);
		triple = true;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		dealCards();
		turn = p1;
	}
	
	private void dealCards(){
		Deck d = g.getDeck();
		Card c;
		int loop = 4;
		if(!triple){
			p1.setshelf(d.pop(), d.pop(), d.pop(), d.pop());
			p2.setshelf(d.pop(), d.pop(), d.pop(), d.pop());
		}
		else{
			p1.setshelf(d.pop(), d.pop(), d.pop());
			p2.setshelf(d.pop(), d.pop(), d.pop());
			p3.setshelf(d.pop(), d.pop(), d.pop());
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
	
	public void takeTurn(){
		turn.takeTurn(turnnumber);
	}
	
	public void play(){
		if(turn.finished(turnnumber)){
			moveCards();
			prepareNextTurn();
		}
	}
	
	private void prepareNextTurn(){
		if(turn.equals(p1))
			turn = p2;
		else if(turn.equals(p2))
			if(triple)
				turn = p3;
			else{
				turn = p1;
				turnnumber++;
			}
		else{
			turn = p1;
			turnnumber++;
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
	
	public void sendClick(MouseEvent me){
		if(turn instanceof Human){
			turn.sendClick(me);
		}
	}
	
	private void moveCards(){
		if(turnnumber == 1){
			turn.setflop(turn.selected);
			turn.remove();
		}
		else{
			g.playCards(turn.selected);
			turn.remove();
			turn.draw(g.getDeck());
		}
	}
	
	public static boolean followsRules(int turn, Card[] selected){
		boolean flag = false;
		if(turn==1){
			flag = true;
			for(int index=0;index<selected.length;index++)
				if(selected[index]==null)
					if(index!=3)
						return false;
					else if(!triple)
						return false;
		}
		else{
			for(int index=0;index<selected.length;index++){
				for(int count=1+index;count<selected.length;count++){
					if(selected[index]!=null){
						flag = true;
						if(selected[count]!=null)
							if(selected[index].getCardNumber()!=selected[count].getCardNumber())
								return false;
					}
				}
			}
		}
		return flag;
	}
}
