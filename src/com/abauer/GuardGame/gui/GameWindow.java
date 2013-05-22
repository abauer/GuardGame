package com.abauer.GuardGame.gui;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import com.abauer.GuardGame.game.Game;
import com.abauer.GuardGame.turn.TurnManager;

public class GameWindow extends BaseWindow implements ComponentListener{
	private static final long serialVersionUID = 1L;
	public static Game contained;
	public GameWindow(TurnManager tm){
		super(800,600);
		contained = tm.getGame();
		myHandler.registerWhiteList(this);
		addComponentListener(this);
		contained.setLocation(0,0);
		contained.onResize(width,height);
		setContentPane(contained);
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
