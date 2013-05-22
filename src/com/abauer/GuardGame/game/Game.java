package com.abauer.GuardGame.game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.abauer.GuardGame.turn.TurnManager;
import com.abauer.GuardGame.util.FileUtils;

public class Game extends JComponent implements MouseListener{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Card> pot;
	BufferedImage buffer;
	Graphics main;
	int width,height;
	TurnManager tm;
	private int seed;
	Deck cards;
	
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
		Image board = FileUtils.getImage("tabletexture.jpg");
		main.drawImage(board,0, 0, 800, 600, null);
		cards = new Deck(seed);
		pot = new ArrayList<Card>();
	}
	
	protected void drawDeck(){
		if(cards.getCards().size()>0){
			Card temp = cards.getCards().get(0);
			temp.setVisible(false);
			temp.drawCard(main, 533, 300);
		}
	}
	
	public void dealCards(){
		
	}
	
	protected void drawPot(){
		if(pot.size()>0){
			pot.get(0).setVisible(true);
			pot.get(0).drawCard(main, 256, 300);
			for(int index=1;index<pot.size();index++){
				if(pot.get(index-1).getCardNumber()==pot.get(index).getCardNumber()){
					pot.get(index).setVisible(true);
					pot.get(index).drawCard(main, 256+20*index, 300);
				}
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		drawDeck();
		drawPot();
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
	}
	
}
