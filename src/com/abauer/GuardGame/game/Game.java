package com.abauer.GuardGame.game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.JComponent;

import com.abauer.GuardGame.turn.TurnManager;
import com.abauer.GuardGame.util.FileUtils;

public class Game extends JComponent implements MouseListener{
	private static final long serialVersionUID = 1L;

	BufferedImage buffer;
	Graphics main;
	int width,height;
	TurnManager tm;
	
	public Game(TurnManager tm){
		addMouseListener(this);
		buffer = new BufferedImage(800,600,BufferedImage.TYPE_4BYTE_ABGR);
		main = buffer.getGraphics();
		Image board = FileUtils.getImage("tabletexture.jpg");
		main.drawImage(board,0, 0, 800, 600, null);
		this.tm = tm;
	}
	
	public BufferedImage getImage() {
		return buffer;
	}

	public void paintComponent(Graphics g) {
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
