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

package com.abauer.GuardGame.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import com.abauer.GuardGame.GuardGame;
import com.abauer.GuardGame.data.Constants;
import com.abauer.GuardGame.util.FileUtils;

public class LoggingInWindow extends BaseWindow {
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private int currentImage = 0;
	private int length = 0;
	
	/**
	 * <code>LoggingInWindow</code> constructor.
	 */
	public LoggingInWindow() {
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		final JLabel label = new JLabel("");
		
		progressBar.setBounds(0, 326, 492, 14);
		label.setBounds(0, 0, 492, 340);
		
		progressBar.setIndeterminate(true);
		
		getContentPane().add(progressBar);
		getContentPane().add(label);
		
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				length += Constants.SPLASH_DURATION;
				if (currentImage == 0) {
					label.setIcon(new ImageIcon(FileUtils.getResourcePath(("/roketgamer_title.png"))));
				}
				else {
					label.setIcon(new ImageIcon(FileUtils.getResourcePath(("/guardgame_title.png"))));
				}
				if (currentImage == 1)
					currentImage = 0;
				else
					currentImage++;
				
				if(GuardGame.getGameState().isOffline()) {
					if(length > Constants.SPLASH_SCREEN_TIMEOUT)
						openMenu();
				} else {
					if (length > Constants.SPLASH_SCREEN_TIMEOUT && GuardGame.getRoketGamer().getPlayer().hasLoadedData()) {
						openMenu();
						GuardGame.getWindowHandler().getToasterManager().showToaster(new ImageIcon(GuardGame.getRoketGamer().getPlayer().getAvatarAsBytes(64)), " Logged in as " + GuardGame.getRoketGamer().getPlayer().getName());
					}
				}
			}
		};
		timer = new Timer(Constants.SPLASH_DURATION,al);
		timer.setInitialDelay(0);
		timer.start();
		
		label.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				openMenu();
			}
		});
		if(!isVisible())
			timer.stop();
	}
	
	boolean alreadyOpened = false;
	
	/**
	 * Open <code>MainMenuWindow</code>
	 */
	public void openMenu() {
		if (!alreadyOpened) {
			alreadyOpened = true;
			nextWindow("MainMenuWindow");
			donewithMe();
		}
	}

	/**
	 * Set <code>Window</code> visible.
	 */
	public void setVisible(boolean visible){
		super.setVisible(visible);
		if(isVisible()){
			alreadyOpened = false;
			timer.start();
		}
		else{
			if(timer!=null)
				timer.stop();
			length = 0;
		}
	}
}
