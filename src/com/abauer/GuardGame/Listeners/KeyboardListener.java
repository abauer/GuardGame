/*
 * Copyright (C) 2012 JPII and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.abauer.GuardGame.Listeners;

import java.awt.event.*;
import java.util.ArrayList;

import com.abauer.GuardGame.gui.LoginWindow;
import com.jpii.gamekit.gui.BaseWindow;

public class KeyboardListener implements KeyListener {
	
	ArrayList<BaseWindow> windows;
	
	public KeyboardListener() {
		super();
		windows = new ArrayList<BaseWindow>();
	}
	
	public void add(BaseWindow classname){
		windows.add(classname);
	}
	
	public void remove(BaseWindow classname){
		windows.remove(classname);
	}
	
	public void keyPressed(KeyEvent k) {	
		if(k.getKeyCode() == KeyEvent.VK_ESCAPE) {
			WindowCloser.close();
		}
		for(int index=0; index<windows.size();index++) {
			BaseWindow window = windows.get(index);
			if(window.name.equals("LoginWindow")) {
				LoginWindow l = (LoginWindow) window;
				if(k.getKeyCode() == KeyEvent.VK_ENTER) {
					l.login();
				}
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
