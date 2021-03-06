package com.abauer.GuardGame.game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.abauer.GuardGame.turn.TurnManager;
import com.abauer.GuardGame.util.FileUtils;

public class Game extends JComponent implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Card> pot;
	BufferedImage buffer;
	Graphics main;
	int width,height;
	public TurnManager tm;
	private int seed;
	Deck cards;
	static Image board = FileUtils.getImage("tabletexture.jpg");
	JButton play;
	
	public Game(TurnManager tm){
		this.tm = tm;
		seed = (int) (Math.random()*100);
		init();
	}
	
	public Game(TurnManager tm, int seed){
		this.tm = tm;
		this.seed = seed;
		init();
	}
	
	public void init(){
		addMouseListener(this);
		buffer = new BufferedImage(800,600,BufferedImage.TYPE_4BYTE_ABGR);
		main = buffer.getGraphics();
		cards = new Deck(seed);
		pot = new ArrayList<Card>();
		play = new JButton("Play");
		play.setBounds(355,285,90,30);
		add(play);
		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tm.play();
				repaint();
			}
		});
	}
	
	protected void drawDeck(){
		for(int index = 0; index<cards.getCards().size();index++){
			Card temp = cards.getCards().get(0);
			temp.setVisible(false);
			temp.drawCard(main, 540, 300);
		}
	}
	
	protected void drawPot(){
		if(pot.size()>0){
			pot.get(pot.size()-1).setVisible(true);
			pot.get(pot.size()-1).drawCard(main, 256, 300);
			for(int index=pot.size()-1;index>0;index--){
				if(pot.get(index-1).getCardNumber()==pot.get(pot.size()-1).getCardNumber()){
					pot.get(index-1).setVisible(true);
					pot.get(index-1).drawCard(main, 256+20*Math.abs(pot.size()-index), 300);
				}
				else
					break;
			}
		}
	}
	
	public void playCards(Card[] cards){
		for(int index = 0; index<cards.length; index++){
			if(cards[index]!=null)
				pot.add(cards[index]);
		}
		repaint();
	}
	
	protected void drawHands(){
		Card[] shelf = tm.getP1().getShelf();
		for(int index=0; index<shelf.length; index++){
			if(shelf[index]!=null){
				shelf[index].drawCard(main, 50+index*50, 500);
			}
		}
		
		Card[] flop = tm.getP1().getFlop();
		for(int index=0; index<flop.length; index++){
			if(flop[index]!=null){
				flop[index].setVisible(true);
				flop[index].drawCard(main, 50+index*50, 450);
			}
		}
		
		ArrayList<Card> hand = tm.getP1().getHand();
		for(int index=0; index<hand.size(); index++){
			int spaceing = 300/hand.size();
			if(!tm.getP1().isSelected(hand.get(index)))
				hand.get(index).drawCard(main,400+index*spaceing,500);
			else
				hand.get(index).drawCard(main,400+index*spaceing,450);
		}
	}
	
	public Deck getDeck(){
		return cards;
	}
	
	public void paintComponent(Graphics g) {
		main.drawImage(board,0, 0, 800, 600, null);
		drawDeck();
		drawPot();
		drawHands();
		g.drawImage(buffer, 0, 0, width, height, null);
	}
	
	public void onResize(int width,int height){
		this.width = width;
		this.height = height;
	}

	public void mouseClicked(MouseEvent arg0) {	
	}
	public void mouseEntered(MouseEvent arg0) {	
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
		tm.sendClick(arg0);
		repaint();
	}
	
}
