package com.abauer.GuardGame.gui;

import com.abauer.GuardGame.Listeners.Focus;
import com.abauer.GuardGame.data.Constants;

public class BaseWindow extends com.jpii.gamekit.gui.BaseWindow{
	private static final long serialVersionUID = 1L;
	
	public BaseWindow() {
		super();
	}
	
	public BaseWindow(int arg0, int arg1) {
		super(arg0, arg1);
	}
	
	public void setDefaults() {
		setTitle("NavalBattle");
		addWindowListener(Constants.closer);
		addKeyListener(Constants.keys);
		addFocusListener(new Focus(this));
		super.setDefaults();
	}
	
}
