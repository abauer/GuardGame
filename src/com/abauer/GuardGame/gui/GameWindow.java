package com.abauer.GuardGame.gui;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import com.abauer.GuardGame.game.Game;

public class GameWindow extends BaseWindow implements ComponentListener{
	private static final long serialVersionUID = 1L;
	Game contained;
	public GameWindow(Game g){
		super(800,600);
		contained = g;
		myHandler.registerWhiteList(this);
		addComponentListener(this);
		setResizable(true);
		g.setLocation(0,0);
		g.onResize(width,height);
		setContentPane(g);
	}
	public void componentHidden(ComponentEvent ce) {		
	}
	public void componentMoved(ComponentEvent ce) {
	}
	public void componentResized(ComponentEvent ce) {
		width = ce.getComponent().getWidth();
		height= ce.getComponent().getHeight();
		contained.onResize(width, height);
	}
	public void componentShown(ComponentEvent ce) {
	}
	
	
}
