package com.abauer.GuardGame.game;

import java.awt.Graphics;
import java.awt.Image;

import com.abauer.GuardGame.util.FileUtils;

public class Card
{
	private static String suitLetters = "cdhs";
	private static Image back = FileUtils.getImage("CardImages/back.gif");
	private int cardNumber;
	private int suitNumber;
	private String cardSuit;
	private String cardName;
	private Image cardImage;
	boolean visible;
	int width = 73;
	int height = 97;
	int x,y;
	
	public Card()
	{
		cardNumber = 2;
		suitNumber = 1;
		cardSuit = suitLetters.substring(suitNumber-1,suitNumber);
		setCardName();
		cardImage = null;
		visible = false;
	}

	public Card(int cN, int sN)
	{
		cardNumber = cN;
		suitNumber = sN;
		cardSuit = suitLetters.substring(suitNumber-1,suitNumber);
		setCardName();
		loadCardImage();
		visible = false;
	}

	public int getCardNumber()
	{
		return cardNumber;
	}

	public int getSuitNumber()
	{
		return suitNumber;
	}

	public String getCardSuit()
	{
		return cardSuit;
	}

	public String getCardName()
	{
		return cardName;
	}

	public Image getCardImage()
	{
		return cardImage;
	}
	
	public boolean isInside(int x, int y){
		if(visible){
			if(x>this.x&&y>this.y)
				if(x<this.x+width&&y<this.y+height){
					return true;
				}
		}
		return false;
	}
	
	public boolean equals(Card c){
		return(c.getCardName().equals(this.getCardName()));
	}
	
	public void setCardNumber(int cN)
	{
		cardNumber = cN;
	}

	public void setCardSuit(String cS)
	{
		cardSuit = cS;
	}

	public void setSuitNumber(int sN)
	{
		suitNumber = sN;
	}

	public void setCardName()
	{
		cardName = "CardImages/" + cardNumber + cardSuit + ".gif";
	}

	public void setCardName(String cN)
	{
		cardName = cN;
	}

	public void setCardImage(Image cI)
	{
		cardImage = cI;
	}

	public void loadCardImage()
	{
		cardImage = FileUtils.getImage(cardName);
	}
	
	public void setVisible(boolean vis){
		visible = vis;
	}
	
	public void drawCard(Graphics g,int x, int y){
		x -= width/2;
		y -= height/2;
		this.x = x;
		this.y = y;
		if(visible)
			g.drawImage(cardImage,x,y,null);
		else
			g.drawImage(back,x,y,null);
	}

	public String toString()
	{
		String cardInfo = "";
		cardInfo += "cardNumber:  " + getCardNumber() + "\n";
		cardInfo += "suitNumber:  " + getSuitNumber() + "\n";
		cardInfo += "cardSuit:    " + getCardSuit() + "\n";
		cardInfo += "cardName:    " + getCardName() + "\n";
		return cardInfo;
	}

}

